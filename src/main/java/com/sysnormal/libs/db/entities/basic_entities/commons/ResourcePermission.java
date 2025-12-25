package com.sysnormal.libs.db.entities.basic_entities.commons;

import com.sysnormal.libs.db.entities.basic_entities.BaseBasicEntity;
import com.sysnormal.libs.db.entities.basic_entities.agents.Agent;
import com.sysnormal.libs.db.entities.basic_entities.agents.access.AccessProfile;
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
        name = "resource_permissions",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "resource_permissions_u1",
                        columnNames = {
                                "(coalesce(parent_id, 0))","status_reg_id","data_origin_id","(coalesce(table_origin_id, 0))","(coalesce(id_at_origin, 0))",
                                "resource_id",
                                "(coalesce(access_profile_id,0))",
                                "(coalesce(agent_id,0))",
                                "(coalesce(start_at,0))",
                                "(coalesce(end_at,0))",
                                "allowed_access",
                                "allowed_create",
                                "allowed_update",
                                "allowed_delete"
                        }
                )
        }
)
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


    protected static final long TABLE_ID = 203;
    public static long getTableId() {
        return TABLE_ID;
    }

}
