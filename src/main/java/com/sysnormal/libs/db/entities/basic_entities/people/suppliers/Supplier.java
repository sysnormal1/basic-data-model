package com.sysnormal.libs.db.entities.basic_entities.people.suppliers;

import com.sysnormal.libs.db.entities.basic_entities.people.BasePeopleEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
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
                                "(coalesce(parent_id, 0))","status_reg_id","data_origin_id","(coalesce(table_origin_id, 0))","(coalesce(id_at_origin, 0))",
                                "people_id"
                        }
                )
        }
)

public class Supplier extends BasePeopleEntity {
    protected static final long TABLE_ID = 5000L;
    public static long getTableId() {
        return TABLE_ID;
    }
}