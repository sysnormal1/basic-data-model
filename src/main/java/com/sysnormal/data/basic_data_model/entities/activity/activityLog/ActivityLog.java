package com.sysnormal.data.basic_data_model.entities.activity.activityLog;

import com.sysnormal.data.base_data_model.entities.BaseEntity;
import com.sysnormal.data.basic_data_model.entities.activity.activityType.ActivityType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

/**
 * O que aconteceu no ecossistema: uma requisicao no backend ou um clique na tela.
 *
 * Sucede o `request_logs`, que respondia "qual endpoint foi chamado" e nao "quem usou
 * qual tela". A troca de nome e proposital: "request" descreve trafego, e o que se quer
 * medir tambem e comportamento.
 *
 * ⚠️ **O `request_logs` continua existindo e nao foi migrado.** As linhas dele sao
 * trafego interno -- IP 127.0.0.1, agente nulo ou zero, `headers` NULL em todas -- e
 * nao teriam como preencher os campos que dao sentido a esta tabela.
 *
 * ## Por que ela NAO estende BaseBasicEntity
 *
 * Segue o precedente do proprio `RequestLog`, e por uma razao que vale repetir: um log e
 * **append-only**. `updated_at`, `updater_agent_id` e `deleted_at` descrevem edicao e
 * exclusao logica, que aqui nao existem -- evento nao se corrige, se contradiz com outro
 * evento. Sao colunas multiplicadas por milhoes de linhas para uma semantica ausente.
 *
 * ## As tres colunas de identidade, e por que se chamam assim
 *
 * - {@code ssoAgentId} tem o prefixo de proposito: a referencia vive no banco do SSO, e
 *   varios sistemas mantem cadastro proprio de agente. Sem o prefixo, alguem um dia liga
 *   isto ao `agents` local e o numero passa a apontar para outra pessoa.
 *   ⚠️ Por viver noutro banco, **nao tem FK**. Perde-se integridade referencial e
 *   ganha-se portabilidade; num log append-only uma referencia orfa nao corrompe nada.
 * - {@code domainName} e **obrigatorio** e {@code domainId} e opcional, nesta ordem de
 *   propósito. Quem loga sempre sabe o proprio nome -- e constante na configuracao
 *   dele --, enquanto o id exige ter se procurado no SSO.
 *   ⚠️ Se as duas fossem anulaveis, existiriam tres estados e um deles seria lixo
 *   silencioso; pior, o mesmo sistema mandando id numa hora e nome noutra PARTIRIA os
 *   grupos de um relatorio sem ninguem perceber. O nome obrigatorio garante uma chave de
 *   agrupamento; o id entra como precisao a mais.
 * - {@code sessionId} amarra os eventos de uma mesma visita sem depender do agente, e e
 *   o unico jeito de registrar clique ANTES do login.
 */
@Getter
@Setter
@Entity
@Table(
        name = "activity_logs",
        indexes = {
                @Index(name = "activity_logs_domain_created_ix", columnList = "domain_name,created_at"),
                @Index(name = "activity_logs_agent_created_ix", columnList = "sso_agent_id,created_at"),
                @Index(name = "activity_logs_type_path_ix", columnList = "activity_type_id,path,created_at"),
                @Index(name = "activity_logs_session_ix", columnList = "session_id,created_at")
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class ActivityLog extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * Quando o servidor gravou.
     *
     * ⚠️ E o momento do EVENTO enquanto o envio for imediato -- `sendBeacon` e
     * `keepalive` entregam em milissegundos. Se um dia entrar buffer com descarga por
     * tempo, o instante real do clique passa a divergir daqui e precisa viajar em
     * {@link #jsonData} como `occurred_at`. Foi por isso que a coluna dedicada nao
     * nasceu: numa tabela deste volume, ela custaria em disco todo dia por um caso que
     * ainda nao existe.
     */
    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    /** Agente do SSO. Sem FK — ver o javadoc da classe. */
    @Column(name = "sso_agent_id")
    private Long ssoAgentId;

    /** Obrigatorio: e a unica chave de agrupamento garantida. */
    @Column(name = "domain_name", nullable = false, length = 127)
    private String domainName;

    /** Opcional, e so quando o sistema sabe o proprio id no SSO. */
    @Column(name = "domain_id")
    private Long domainId;

    @Column(name = "session_id", length = 64)
    private String sessionId;

    @Column(name = "activity_type_id", nullable = false)
    private Long activityTypeId;

    /**
     * A rota do front OU o endpoint do backend — o campo que os dois tipos de evento
     * compartilham, e o que permite uma consulta so responder "onde as pessoas estao".
     *
     * ⚠️ 512, e nao o `longtext` do `request_logs`: entra num indice composto, e em
     * utf8mb4 uma coluna maior estouraria o limite de 3.072 bytes de chave do InnoDB.
     * Rota de front e endpoint cabem folgadamente.
     */
    @Column(name = "path", length = 512)
    private String path;

    /** Qual componente foi acionado. Nulo em requisicao. */
    @Column(name = "component", length = 255)
    private String component;

    /**
     * O rotulo que a pessoa viu no momento do clique.
     *
     * ⚠️ Guardado junto de proposito, e nao resolvido na leitura: o `path` e estavel, o
     * rotulo muda. Sem isto, renomear uma aba faria o relatorio de seis meses atras
     * passar a mostrar o nome novo -- uma forma silenciosa de o historico mentir.
     */
    @Column(name = "label", length = 255)
    private String label;

    /**
     * O caminho do recurso no SSO, quando o evento corresponder a um.
     *
     * ⚠️ Texto, e nao FK para `resources`: os ids do SSO sao por ambiente, enquanto o
     * `resource_path` ("rootDashboard/president-panel") atravessa. E a mesma licao que o
     * `tables.id` custou a este projeto.
     */
    @Column(name = "resource_path", length = 511)
    private String resourcePath;

    @Column(name = "method", length = 10)
    private String method;

    /** ⚠️ E o que separa "acessou" de "tentou e levou 403". Nao existia antes. */
    @Column(name = "status_code")
    private Short statusCode;

    /** Idem: e o que torna o log util para desempenho sem uma segunda ferramenta. */
    @Column(name = "duration_ms")
    private Integer durationMs;

    @Column(name = "params", length = 16777215)
    private String params;

    @Column(name = "body", length = 16777215)
    private String body;

    /**
     * ⚠️ Tem de vir do `X-Forwarded-For` quando houver proxy.
     *
     * O `request_logs` grava `127.0.0.1` e `::1` em toda a amostra porque le o socket:
     * atras de proxy, o socket e o proxy. Trocar o tamanho da coluna nao conserta isso --
     * quem escreve e que precisa ler o cabecalho, senao a coluna nova nasce com o mesmo
     * defeito da velha.
     *
     * 45 caracteres cobrem IPv6 com folga; os 127 de antes eram exagero.
     */
    @Column(name = "client_ip", length = 45)
    private String clientIp;

    /** O user-agent cru. E a fonte da verdade, e o que permite reprocessar. */
    @Column(name = "user_agent", length = 512)
    private String userAgent;

    /**
     * Navegador e sistema ja decodificados NA GRAVACAO.
     *
     * Decodificar em tempo de consulta e caro e o parser envelhece. Guardando o cru
     * ({@link #userAgent}) e o decodificado, da para recorrigir quando o parser melhorar
     * sem perder o passado.
     *
     * ⚠️ A versao vem em granularidade de versao MAIOR na maioria dos casos: os
     * navegadores congelaram a versao menor no user-agent. Em Chromium da para pedir a
     * versao cheia via `userAgentData.getHighEntropyValues()`; em Firefox e Safari, nao.
     */
    @Column(name = "browser_name", length = 64)
    private String browserName;

    @Column(name = "browser_version", length = 32)
    private String browserVersion;

    @Column(name = "os_name", length = 64)
    private String osName;

    @Column(name = "os_version", length = 32)
    private String osVersion;

    @Column(name = "device_type", length = 32)
    private String deviceType;

    @Column(name = "locale", length = 16)
    private String locale;

    @Column(name = "timezone", length = 64)
    private String timezone;

    /** "1920x1080". Diz se a pessoa esta vendo a tela larga ou o painel espremido. */
    @Column(name = "viewport", length = 16)
    private String viewport;

    @Column(name = "referrer", length = 1024)
    private String referrer;

    /**
     * O escape para o que ainda nao sabemos que vamos querer.
     *
     * E o que evita ALTER TABLE numa tabela gigante toda vez que alguem quiser registrar
     * mais um detalhe -- e o que abriga o `occurred_at` se um dia houver buffer.
     *
     * ⚠️ TEXT, e nao o tipo JSON do MySQL: esta biblioteca nao tem NENHUMA coluna JSON
     * hoje, e estrear um mapeamento novo numa lib compartilhada por sete servicos e
     * decisao maior do que uma coluna. Trocar depois e uma anotacao por coluna.
     */
    @Column(name = "json_data", length = 16777215)
    private String jsonData;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "activity_type_id", insertable = false, updatable = false)
    private ActivityType activityType;
}
