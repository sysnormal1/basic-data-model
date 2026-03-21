package com.sysnormal.data.basic_data_model.entities.people.contacts.contactType;

import com.sysnormal.data.basic_data_model.entities.BaseBasicEntity;
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
        name = "contact_types",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "contact_types_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "name"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class ContactType extends BaseBasicEntity<ContactType> {

    @Column(name = "name", nullable = false, length = 127)
    private String name;

}