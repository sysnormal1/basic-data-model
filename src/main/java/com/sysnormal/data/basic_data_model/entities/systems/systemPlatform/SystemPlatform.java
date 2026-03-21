package com.sysnormal.data.basic_data_model.entities.systems.systemPlatform;

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
        name = "system_platform_types",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "system_platform_types_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "name"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class SystemPlatform extends BaseBasicEntity<SystemPlatform> {

    @Column(name = "name", nullable = false, length = 127)
    private String name;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @Column(name = "is_desktop", nullable = false)
    @ColumnDefault("0")
    @Check(constraints = "is_desktop in (0,1)")
    private byte isDesktop = 0;

    @Column(name = "is_web", nullable = false)
    @ColumnDefault("0")
    @Check(constraints = "is_web in (0,1)")
    private byte isWeb = 0;

    @Column(name = "is_mobile", nullable = false)
    @ColumnDefault("0")
    @Check(constraints = "is_mobile in (0,1)")
    private byte isMobile = 0;

    @Column(name = "notes", length = Integer.MAX_VALUE)
    private String notes;

    public static final long DESKTOP_ID = 1;
    public static final long WEB_ID = 2;
    public static final long MOBILE_ID = 3;

    public static final SystemPlatform DESKTOP = new SystemPlatform(){{
        setId(DESKTOP_ID);
        setIsSysRec((byte) 1);
        setName("DESKTOP");
        setIsDesktop((byte) 1);
    }};

    public static final SystemPlatform WEB = new SystemPlatform(){{
        setId(WEB_ID);
        setIsSysRec((byte) 1);
        setName("WEB");
        setIsWeb((byte) 1);
    }};

    public static final SystemPlatform MOBILE = new SystemPlatform(){{
        setId(MOBILE_ID);
        setIsSysRec((byte) 1);
        setName("MOBILE");
        setIsMobile((byte) 1);
    }};
    

}
