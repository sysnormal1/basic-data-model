package com.sysnormal.libs.db.entities.basic_entities.people.peopleContact;

import com.sysnormal.libs.db.entities.basic_entities.BaseBasicEntity;
import com.sysnormal.libs.db.entities.basic_entities.people.contacts.contact.Contact;
import com.sysnormal.libs.db.entities.basic_entities.people.contacts.contactType.ContactType;
import com.sysnormal.libs.db.entities.basic_entities.people.people.People;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Getter
@Setter
@Table(
        name = "people_contacts",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "people_contacts_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "people_id", "(coalesce(contact_type_id,0))","contact_id"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class PeopleContact extends BaseBasicEntity<PeopleContact> {

    @Column(name = "people_id", nullable = false)
    private Long peopleId;

    @Column(name = "contact_type_id")
    private Long contactTypeId;

    @Column(name = "contact_id", nullable = false)
    private Long contactId;

    @Column(name = "numeric_order")
    private Integer numericOrder;

    @Column(name = "notes")
    private String notes;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "people_id", insertable = false, updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private People people;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contact_type_id", insertable = false, updatable = false)
    private ContactType contactType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contact_id", insertable = false, updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Contact contact;

    protected static final long TABLE_ID = 2015;
    public static long getTableId() {
        return TABLE_ID;
    }


}