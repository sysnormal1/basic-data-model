package com.sysnormal.libs.db.entities.basic_entities.commons;

import com.sysnormal.libs.db.entities.basic_entities.BaseBasicEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(
        name = "value_names",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "value_names_u1",
                        columnNames = {
                                "(coalesce(parent_id, 0))","status_reg_id","data_origin_id","(coalesce(table_origin_id, 0))","(coalesce(id_at_origin, 0))",
                                "name"
                        }
                )
        }
)

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
