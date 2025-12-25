package com.sysnormal.libs.db.entities.basic_entities.people.contacts;

import com.sysnormal.libs.db.entities.basic_entities.BaseBasicEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(
        name = "contacts",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "contacts_u1",
                        columnNames = {
                                "(coalesce(parent_id, 0))","status_reg_id","data_origin_id","(coalesce(table_origin_id, 0))","(coalesce(id_at_origin, 0))",
                                "contact_type_id", "name"
                        }
                )
        }
)
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
