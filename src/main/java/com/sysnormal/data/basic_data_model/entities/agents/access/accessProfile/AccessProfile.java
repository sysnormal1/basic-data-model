package com.sysnormal.data.basic_data_model.entities.agents.access.accessProfile;

import com.sysnormal.data.basic_data_model.entities.BaseBasicEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.ColumnDefault;

/**
 * Entity class
 */
@Getter
@Setter
@Entity
@Table(
        name = "access_profiles",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "access_profiles_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "name"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class AccessProfile extends BaseBasicEntity<AccessProfile> {

    @Column(name = "name", nullable = false, length = 127)
    private String name;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @Column(name = "allow_access_to_all_module_routines", nullable = false, length = 1)
    @ColumnDefault("0")
    @Check(constraints = "allow_access_to_all_module_routines in (0,1)")
    private byte allowAccessToAllModuleRoutines = 0;

    public static final long SYSTEM_ID = 0;
    public static final long DEFAULT_ID = 1;
    public static final long PRESIDENCE_ID = 2L;
    public static final long ADMINISTRATIVE_ID = 3L;
    public static final long GERENCIAL_ID = 4L;
    public static final long SUPERVISOR_ID = 5L;
    public static final long HUMAN_RESOURCES_ID = 6L;
    public static final long INVOICING_ID = 10L;
    public static final long FINANCIAL_ID = 20L;
    public static final long SELLER_ID = 50L;
    public static final long SUPLIER_ID = 60L;

    public static final AccessProfile SYSTEM = new AccessProfile(){{
        setId(SYSTEM_ID);
        setIsSysRec((byte) 1);
        setName("SYSTEM");
        setAllowAccessToAllModuleRoutines((byte) 1);
    }};
    public static final AccessProfile DEFAULT = new AccessProfile(){{
        setId(DEFAULT_ID);
        setIsSysRec((byte) 1);
        setName("DEFAULT");
    }};
    public static final AccessProfile PRESIDENCE = new AccessProfile(){{
        setId(PRESIDENCE_ID);
        setIsSysRec((byte) 1);
        setName("PRESIDENCE");
    }};
    public static final AccessProfile ADMINISTRATIVE = new AccessProfile(){{
        setId(ADMINISTRATIVE_ID);
        setIsSysRec((byte) 1);
        setName("ADMINISTRATIVE");
    }};
    public static final AccessProfile GERENCIAL = new AccessProfile(){{
        setId(GERENCIAL_ID);
        setIsSysRec((byte) 1);
        setName("GERENCIAL");
    }};
    public static final AccessProfile SUPERVISOR = new AccessProfile(){{
        setId(SUPERVISOR_ID);
        setIsSysRec((byte) 1);
        setName("SUPERVISOR");
    }};
    public static final AccessProfile HUMAN_RESOURCES = new AccessProfile(){{
        setId(HUMAN_RESOURCES_ID);
        setIsSysRec((byte) 1);
        setName("HUMAN RESOURCES");
    }};
    public static final AccessProfile INVOICING = new AccessProfile(){{
        setId(INVOICING_ID);
        setIsSysRec((byte) 1);
        setName("INVOICING");
    }};
    public static final AccessProfile FINANCIAL = new AccessProfile(){{
        setId(FINANCIAL_ID);
        setIsSysRec((byte) 1);
        setName("FINANCIAL");
    }};
    public static final AccessProfile SELLER = new AccessProfile(){{
        setId(SELLER_ID);
        setIsSysRec((byte) 1);
        setName("SELLER");
    }};
    public static final AccessProfile SUPLIER = new AccessProfile(){{
        setId(SUPLIER_ID);
        setIsSysRec((byte) 1);
        setName("SUPLIER");
    }};
}
