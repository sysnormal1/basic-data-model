package com.sysnormal.data.basic_data_model.entities.activity.activityType;

import com.sysnormal.data.basic_data_model.entities.BaseBasicEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

/**
 * O que aconteceu, em vocabulario fechado.
 *
 * Tabela de tipo, e nao ENUM nem varchar livre, pelo mesmo motivo das demais
 * `*_types` da casa: acrescentar um tipo depois nao pode exigir ALTER TABLE numa
 * tabela de milhoes de linhas, e o rotulo precisa de descricao em algum lugar.
 *
 * ⚠️ REQUEST e o unico que ja existe hoje, escrito pelo backend. Os demais nascem
 * com a instrumentacao do front -- NAVIGATION no clique de menu, COMPONENT_CLICK
 * quando a configuracao estender para componentes.
 */
@Entity
@Getter
@Setter
@Table(
        name = "activity_types",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "activity_types_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "name"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class ActivityType extends BaseBasicEntity<ActivityType> {

    @Column(name = "name", nullable = false, length = 127)
    private String name;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    public static final long REQUEST_ID = 1;
    public static final long NAVIGATION_ID = 2;
    public static final long COMPONENT_CLICK_ID = 3;
    public static final long LOGIN_ID = 4;
    public static final long LOGOUT_ID = 5;
    public static final long ERROR_ID = 6;

    public static final ActivityType REQUEST = new ActivityType(){{
        setId(REQUEST_ID);
        setIsSysRec((byte) 1);
        setName("REQUEST");
        setDescription("Chamada a um endpoint, registrada pelo proprio backend. E o unico tipo que existia no request_logs.");
    }};
    public static final ActivityType NAVIGATION = new ActivityType(){{
        setId(NAVIGATION_ID);
        setIsSysRec((byte) 1);
        setName("NAVIGATION");
        setDescription("A pessoa abriu uma tela: clique no menu, ou entrada por link. O `path` e a rota do front.");
    }};
    public static final ActivityType COMPONENT_CLICK = new ActivityType(){{
        setId(COMPONENT_CLICK_ID);
        setIsSysRec((byte) 1);
        setName("COMPONENT_CLICK");
        setDescription("Interacao dentro de uma tela ja aberta: aba, card, botao. O `component` diz qual, e o `path` diz onde.");
    }};
    public static final ActivityType LOGIN = new ActivityType(){{
        setId(LOGIN_ID);
        setIsSysRec((byte) 1);
        setName("LOGIN");
        setDescription("Entrada no sistema. Marca o inicio de uma sessao, e e a linha que da nome ao session_id dos eventos seguintes.");
    }};
    public static final ActivityType LOGOUT = new ActivityType(){{
        setId(LOGOUT_ID);
        setIsSysRec((byte) 1);
        setName("LOGOUT");
        setDescription("Saida explicita. ⚠️ Nao confundir com fim de sessao: a maioria das sessoes termina por expiracao e nunca gera esta linha.");
    }};
    public static final ActivityType ERROR = new ActivityType(){{
        setId(ERROR_ID);
        setIsSysRec((byte) 1);
        setName("ERROR");
        setDescription("Falha que a pessoa viu. Fica aqui, e nao numa tabela propria, para que a linha do tempo de uma sessao mostre o erro no meio do caminho que levou a ele.");
    }};
}
