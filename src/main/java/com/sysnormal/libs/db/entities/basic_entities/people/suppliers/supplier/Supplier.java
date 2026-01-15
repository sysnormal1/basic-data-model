package com.sysnormal.libs.db.entities.basic_entities.people.suppliers.supplier;

import com.sysnormal.libs.db.entities.basic_entities.people.BasePeopleEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(
        name = "suppliers",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "suppliers_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "people_id"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Supplier extends BasePeopleEntity<Supplier> {
    protected static final long TABLE_ID = 5000L;
    public static long getTableId() {
        return TABLE_ID;
    }
}