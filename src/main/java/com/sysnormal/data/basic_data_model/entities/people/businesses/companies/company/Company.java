package com.sysnormal.data.basic_data_model.entities.people.businesses.companies.company;

import com.sysnormal.data.basic_data_model.entities.people.BasePeopleEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Entity class
 */
@Entity
@Getter
@Setter
@Table(
        name = "companies",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "companies_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "people_id"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Company extends BasePeopleEntity<Company> {

}