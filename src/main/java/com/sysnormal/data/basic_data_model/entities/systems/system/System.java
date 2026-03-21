package com.sysnormal.data.basic_data_model.entities.systems.system;

import com.sysnormal.data.basic_data_model.entities.BaseBasicEntity;
import com.sysnormal.data.basic_data_model.entities.systems.systemPlatform.SystemPlatform;
import com.sysnormal.data.basic_data_model.entities.systems.systemSide.SystemSide;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Entity class
 */
@Entity
@Getter
@Setter
@Table(
        name = "systems",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "systems_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "system_platform_id",
                                "system_side_id",
                                "name"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class System extends BaseBasicEntity<System> {

    @Column(name = "system_platform_id", nullable = false)
    private Long systemPlatformId;

    @Column(name = "system_side_id", nullable = false)
    private Long systemSideId;

    @Column(name = "name", length = 127, nullable = false)
    private String name;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @Column(name = "notes", length = Integer.MAX_VALUE)
    private String notes;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "system_platform_id", insertable = false, updatable = false)
    private SystemPlatform systemPlatform;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "system_side_id", insertable = false, updatable = false)
    private SystemSide systemSide;

    public static final long THIS_ID = 0;
    public static final long DEFAULT_WEB_CLIENT_ID = 1;

    public static final System THIS = new System(){{
        setId(THIS_ID);
        setIsSysRec((byte) 1);
        setName("THIS");
        setSystemPlatformId(SystemPlatform.DESKTOP_ID);
        setSystemSideId(SystemSide.SERVER_SIDE_ID);
    }};

    public static final System DEFAULT_WEB_CLIENT = new System(){{
        setId(DEFAULT_WEB_CLIENT_ID);
        setIsSysRec((byte) 1);
        setName("DEFAULT_WEB_CLIENT");
        setSystemPlatformId(SystemPlatform.WEB_ID);
        setSystemSideId(SystemSide.CLIENT_SIDE_ID);
    }};



}