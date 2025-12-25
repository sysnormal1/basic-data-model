package com.sysnormal.libs.db.entities.basic_entities.agents.access;

import com.sysnormal.libs.db.entities.basic_entities.BaseBasicEntity;
import com.sysnormal.libs.db.entities.basic_entities.agents.Agent;
import com.sysnormal.libs.db.entities.basic_entities.commons.Context;
import com.sysnormal.libs.db.entities.basic_entities.database.Tables;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(
        name = "permissions",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "permissions_u1",
                        columnNames = {
                                "(coalesce(parent_id, 0))","status_reg_id","data_origin_id","(coalesce(table_origin_id, 0))","(coalesce(id_at_origin, 0))",
                                "power_type_id",
                                "(COALESCE(access_profile_id,0))",
                                "(COALESCE(agent_id,0))",
                                "(COALESCE(context_id,0))",
                                "(COALESCE(table_id,0))",
                                "(COALESCE(start_at,'1900-01-01'))"
                        }
                )
        }
)
public class Permission extends BaseBasicEntity {

    @Column(name = "power_type_id", nullable = false)
    private Long powerTypeId;

    @Column(name = "access_profile_id")
    private Long accessProfileId;

    @Column(name = "agent_id")
    private Long agentId;

    @Column(name = "context_id")
    private Long contextId;

    @Column(name = "table_id")
    private Long tableId;

    @Column(name = "start_at")
    private LocalDateTime startAt;

    @Column(name = "end_at")
    private LocalDateTime endAt;

    @Column(name = "allowed_access", nullable = false)
    @ColumnDefault("1")
    @Check(constraints = "allowed_access in (0,1)")
    private byte allowedAccess = 1;

    @Column(name = "allowed_search", nullable = false)
    @ColumnDefault("1")
    @Check(constraints = "allowed_search in (0,1)")
    private byte allowedSearch = 1;

    @Column(name = "allowed_read", nullable = false)
    @ColumnDefault("1")
    @Check(constraints = "allowed_read in (0,1)")
    private byte allowedRead = 1;

    @Column(name = "allowed_update", nullable = false)
    @ColumnDefault("1")
    @Check(constraints = "allowed_update in (0,1)")
    private byte allowedUpdate = 1;

    @Column(name = "allowed_create", nullable = false)
    @ColumnDefault("1")
    @Check(constraints = "allowed_create in (0,1)")
    private byte allowedCreate = 1;

    @Column(name = "allowed_delete", nullable = false)
    @ColumnDefault("1")
    @Check(constraints = "allowed_delete in (0,1)")
    private byte allowedDelete = 1;

    @Column(name = "notes")
    private String notes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "power_type_id", insertable = false, updatable = false)
    private PowerType powerType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "access_profile_id", insertable = false, updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private AccessProfile accessProfile;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agent_id", insertable = false, updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Agent agent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "context_id", insertable = false, updatable = false)
    private Context context;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "table_id", insertable = false, updatable = false)
    private Tables table;


    protected static final long TABLE_ID = 7003;
    public static long getTableId() {
        return TABLE_ID;
    }

    public static final long SYSTEM_ID = 0;

    public static final Permission SYSTEM_PERMISSION = new Permission(){{
        setId(SYSTEM_ID);
        setIsSysRec((byte) 1);
        setPowerTypeId(PowerType.SYSTEM_ID);
        setAccessProfileId(AccessProfile.SYSTEM_ID);
        setAllowedAccess((byte) 1);
        setAllowedSearch((byte) 1);
        setAllowedRead((byte) 1);
        setAllowedUpdate((byte) 1);
        setAllowedCreate((byte) 1);
        setAllowedDelete((byte) 1);
    }};

}