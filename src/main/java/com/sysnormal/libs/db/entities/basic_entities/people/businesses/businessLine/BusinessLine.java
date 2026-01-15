package com.sysnormal.libs.db.entities.basic_entities.people.businesses.businessLine;

import com.sysnormal.libs.db.entities.basic_entities.BaseBasicEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(
        name = "business_lines",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "business_lines_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "name"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class BusinessLine extends BaseBasicEntity<BusinessLine> {

    @Column(name = "name", nullable = false, length = 127)
    private String name;

    protected static final long TABLE_ID = 1035L;
    public static long getTableId() {
        return TABLE_ID;
    }
}
