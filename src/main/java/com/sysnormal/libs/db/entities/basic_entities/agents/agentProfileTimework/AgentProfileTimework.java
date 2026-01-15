package com.sysnormal.libs.db.entities.basic_entities.agents.agentProfileTimework;

import com.sysnormal.libs.db.entities.basic_entities.BaseBasicEntity;
import com.sysnormal.libs.db.entities.basic_entities.agents.agent.Agent;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Table(
        name = "agent_profile_timeworks",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "agent_profile_timeworks_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "agent_id",
                                "name"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class AgentProfileTimework extends BaseBasicEntity<AgentProfileTimework> {

    @Column(name = "agent_id", nullable = false)
    private Long agentId;

    @Column(name = "name", nullable = false, length = 127)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agent_id", insertable = false, updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Agent agent;

    protected static final long TABLE_ID = 122;
    public static long getTableId() {
        return TABLE_ID;
    }

}
