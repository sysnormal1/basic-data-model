package com.sysnormal.data.basic_data_model.entities.people.businesses.businessUnits.businessUnit;

import com.sysnormal.data.basic_data_model.entities.people.BasePeopleEntity;
import com.sysnormal.data.basic_data_model.entities.people.businesses.companies.company.Company;
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
        name = "business_units",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "business_units_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "people_id"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class BusinessUnit extends BasePeopleEntity<BusinessUnit> {
    @Column(name = "company_id", nullable = false)
    private Long companyId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", insertable = false, updatable = false)
    private Company company;
}
