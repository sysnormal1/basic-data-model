package com.sysnormal.libs.db.entities.basic_entities.resources.resourceConfiguration;

import com.sysnormal.libs.db.entities.basic_entities.BaseBasicEntity;
import com.sysnormal.libs.db.entities.basic_entities.agents.access.accessProfile.AccessProfile;
import com.sysnormal.libs.db.entities.basic_entities.agents.agent.Agent;
import com.sysnormal.libs.db.entities.basic_entities.resources.resource.Resource;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Table(
        name = "resource_configurations",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "resource_configurations_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "resource_id",
                                "(coalesce(access_profile_id,-1))",
                                "(coalesce(agent_id,-1))"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class ResourceConfiguration extends BaseBasicEntity<ResourceConfiguration> {

    @Column(name = "resource_id", nullable = false)
    private Long resourceId;

    @Column(name = "access_profile_id")
    private Long accessProfileId;

    @Column(name = "agent_id")
    private Long agentId;

    @Column(name = "configurations", length = Integer.MAX_VALUE)
    private String configurations;

    @Column(name = "notes")
    private String notes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resource_id", insertable = false, updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Resource resource;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "access_profile_id", insertable = false, updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private AccessProfile accessProfile;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agent_id", insertable = false, updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Agent agent;


    protected static final long TABLE_ID = 220;
    public static long getTableId() {
        return TABLE_ID;
    }

}
