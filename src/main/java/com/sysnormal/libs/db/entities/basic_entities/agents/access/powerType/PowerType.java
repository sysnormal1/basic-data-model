package com.sysnormal.libs.db.entities.basic_entities.agents.access.powerType;

import com.sysnormal.libs.db.entities.basic_entities.BaseBasicEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(
        name = "power_types",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "power_types_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "name"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class PowerType extends BaseBasicEntity<PowerType> {

    @Column(name = "name", nullable = false, length = 127)
    private String name;

    @Column(name = "description")
    private String description;

    protected static final long TABLE_ID = 7002;
    public static long getTableId() {
        return TABLE_ID;
    }

    public static final long SYSTEM_ID = 0;
    public static final long ACCESS_ID = 1;

    public static final PowerType SYSTEM = new PowerType(){{
        setId(SYSTEM_ID);
        setIsSysRec((byte) 1);
        setName("SYSTEM");
    }};
    public static final PowerType ACCESS = new PowerType(){{
        setId(ACCESS_ID);
        setIsSysRec((byte) 1);
        setName("ACCESS");
    }};

}