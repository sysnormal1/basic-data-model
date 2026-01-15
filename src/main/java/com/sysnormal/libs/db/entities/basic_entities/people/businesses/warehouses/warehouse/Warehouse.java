package com.sysnormal.libs.db.entities.basic_entities.people.businesses.warehouses.warehouse;

import com.sysnormal.libs.db.entities.basic_entities.people.BasePeopleEntity;
import com.sysnormal.libs.db.entities.basic_entities.people.businesses.companies.company.Company;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(
        name = "warehouses",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "warehouses_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "people_id"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Warehouse extends BasePeopleEntity<Warehouse> {
    @Column(name = "company_id", nullable = false)
    private Long companyId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", insertable = false, updatable = false)
    private Company company;

    protected static final long TABLE_ID = 3002L;
    public static long getTableId() {
        return TABLE_ID;
    }
}
