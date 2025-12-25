package com.sysnormal.libs.db.entities.basic_entities.agents;

import com.sysnormal.libs.db.entities.basic_entities.BaseBasicEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(
        name = "agent_tokens",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "agent_tokens_u1",
                        columnNames = {
                                "(coalesce(parent_id, 0))","status_reg_id","data_origin_id","(coalesce(table_origin_id, 0))","(coalesce(id_at_origin, 0))",
                                "agent_id",
                                "token"
                        }
                )
        }
)
public class AgentToken extends BaseBasicEntity {

    @Column(name = "agent_id", nullable = false)
    private Long agentId;

    @Column(name = "token", nullable = false, length = 255)
    private String token;

    @Column(name = "expired_at")
    private LocalDateTime expiredAt;

    @Column(name = "expired", nullable = false)
    @ColumnDefault("0")
    @Check(constraints = "expired in (0,1)")
    private byte expired = 0;

    @Column(name = "device_information", length = 2000)
    private String deviceInformation;

    @Column(name = "timezone_offset")
    private Integer timezoneOffset;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agent_id", insertable = false, updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Agent agent;

    protected static final long TABLE_ID = 121;
    public static long getTableId() {
        return TABLE_ID;
    }

}
