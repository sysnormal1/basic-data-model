package com.sysnormal.data.basic_data_model.entities.people.contacts.contact;

import com.sysnormal.data.basic_data_model.entities.BaseBasicEntity;
import com.sysnormal.data.basic_data_model.entities.people.contacts.contactType.ContactType;
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
        name = "contacts",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "contacts_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "contact_type_id", "name"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Contact extends BaseBasicEntity<Contact> {

    @Column(name = "contact_type_id", nullable = false)
    private Long contactTypeId;

    @Column(name = "name", nullable = false, length = 127)
    private String name;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contact_type_id", updatable = false, insertable = false)
    private ContactType contactType;

    protected static final long TABLE_ID = 2013;
    public static long getTableId() {
        return TABLE_ID;
    }
}
