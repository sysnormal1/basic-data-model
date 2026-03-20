package com.sysnormal.data.basic_data_model.entities.commons.valueName;

import com.sysnormal.data.basic_data_model.entities.BaseBasicEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Entity class
 */
@Getter
@Setter
@Entity
@Table(
        name = "value_names",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "value_names_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "name"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class ValueName extends BaseBasicEntity<ValueName> {
    @Column(name = "name", nullable = false, length = 127)
    private String name;

    protected static final long TABLE_ID = 1002;
    public static long getTableId() {
        return TABLE_ID;
    }

    public static final long INVOICENUM_ID = 1;

    public static final ValueName INVOICENUM = new ValueName(){{
        setId(INVOICENUM_ID);
        setIsSysRec((byte) 1);
        setName("INVOICENUM");
    }};
}
