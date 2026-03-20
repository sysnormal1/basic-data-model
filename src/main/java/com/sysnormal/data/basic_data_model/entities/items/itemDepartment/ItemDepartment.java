package com.sysnormal.data.basic_data_model.entities.items.itemDepartment;

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
        name = "item_departments",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "item_departments_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "name"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class ItemDepartment extends BaseBasicEntity<ItemDepartment> {
    @Column(name = "name", nullable = false)
    private String name;

    protected static final long TABLE_ID = 8006L;
    public static long getTableId() {
        return TABLE_ID;
    }
}
