package com.sysnormal.libs.db.entities.basic_entities.people.businesses.businessNetwork;

import com.sysnormal.libs.db.entities.basic_entities.BaseBasicEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(
        name = "business_networks",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "business_networks_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "name"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class BusinessNetwork extends BaseBasicEntity<BusinessNetwork> {

    @Column(name = "name", nullable = false, length = 127)
    private String name;

    protected static final long TABLE_ID = 1036L;
    public static long getTableId() {
        return TABLE_ID;
    }
}
