package com.sysnormal.data.basic_data_model.entities.resources.resourcePermission;

import com.sysnormal.data.basic_data_model.entities.BaseBasicEntity;
import com.sysnormal.data.basic_data_model.entities.agents.access.accessProfile.AccessProfile;
import com.sysnormal.data.basic_data_model.entities.agents.agent.Agent;
import com.sysnormal.data.basic_data_model.entities.resources.resource.Resource;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.ColumnDefault;
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
        name = "resource_permissions",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "resource_permissions_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "resource_id",
                                "(coalesce(access_profile_id,-1))",
                                "(coalesce(agent_id,-1))",
                                "(coalesce(start_at,0))",
                                "(coalesce(end_at,0))"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class ResourcePermission extends BaseBasicEntity<ResourcePermission> {

    @Column(name = "resource_id", nullable = false)
    private Long resourceId;

    @Column(name = "access_profile_id")
    private Long accessProfileId;

    @Column(name = "agent_id")
    private Long agentId;

    @Column(name = "start_at")
    private LocalDateTime startAt;

    @Column(name = "end_at")
    private LocalDateTime endAt;

    @Column(name = "allowed_access", nullable = false)
    @ColumnDefault("1")
    @Check(constraints = "allowed_access in (0,1)")
    private byte allowedAccess = 1;

    @Column(name = "allowed_create", nullable = false)
    @ColumnDefault("0")
    @Check(constraints = "allowed_create in (0,1)")
    private byte allowedCreate = 0;

    @Column(name = "allowed_update", nullable = false)
    @ColumnDefault("0")
    @Check(constraints = "allowed_update in (0,1)")
    private byte allowedUpdate = 0;

    @Column(name = "allowed_delete", nullable = false)
    @ColumnDefault("0")
    @Check(constraints = "allowed_delete in (0,1)")
    private byte allowedDelete = 0;

    @Column(name = "condition", length = Integer.MAX_VALUE)
    private String condition;

    @Column(name = "notes", length = Integer.MAX_VALUE)
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

    public static final long SYSTEM_PERMISSIONS_ID = 0;

    public static final ResourcePermission SYSTEM_PERMISSIONS = new ResourcePermission(){{
        setId(SYSTEM_PERMISSIONS_ID);
        setIsSysRec((byte) 1);
        setResourceId(22102L);
        setAccessProfileId(AccessProfile.SYSTEM_ID);
        setAllowedAccess((byte) 1);
    }};


}
