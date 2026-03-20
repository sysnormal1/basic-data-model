package com.sysnormal.data.basic_data_model.entities.agents.agentTimeWork;

import com.sysnormal.data.basic_data_model.entities.BaseBasicEntity;
import com.sysnormal.data.basic_data_model.entities.agents.agentProfileTimework.AgentProfileTimework;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;

/**
 * Entity class
 */
@Getter
@Setter
@Entity
@Table(
        name = "agent_timeworks",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "agent_timeworks_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "agent_profile_timework_id",
                                "week_day",
                                "start_at"
                        }
                ),
                @UniqueConstraint(
                        name = "agent_timeworks_u2",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "agent_profile_timework_id",
                                "week_day",
                                "end_at"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class AgentTimework extends BaseBasicEntity<AgentTimework> {

    @Column(name = "agent_profile_timework_id", nullable = false)
    private Long agentProfileTimeworkId;

    @Column(name = "week_day",nullable = false)
    @Check(constraints = "week_day in (0,1,2,3,4,5,6)")
    private Byte weekDay;

    @Column(name = "start_at", nullable = false)
    private LocalDateTime startAt;

    @Column(name = "end_at", nullable = false)
    private LocalDateTime endAt;

    @Column(name = "notes", length = Integer.MAX_VALUE)
    private String notes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agent_profile_timework_id", insertable = false, updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private AgentProfileTimework agentProfileTimework;

    protected static final long TABLE_ID = 123;
    public static long getTableId() {
        return TABLE_ID;
    }

}
