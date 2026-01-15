package com.sysnormal.libs.db.entities.basic_entities.people.businesses.companies.company;

import com.sysnormal.libs.db.entities.basic_entities.people.BasePeopleEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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

    protected static final long TABLE_ID = 3000L;
    public static long getTableId() {
        return TABLE_ID;
    }

}