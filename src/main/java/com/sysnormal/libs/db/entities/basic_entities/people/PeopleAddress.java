package com.sysnormal.libs.db.entities.basic_entities.people;

import com.sysnormal.libs.db.entities.basic_entities.BaseBasicEntity;
import com.sysnormal.libs.db.entities.basic_entities.localizations.Address;
import com.sysnormal.libs.db.entities.basic_entities.localizations.AddressType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Getter
@Setter
@Table(
        name = "people_addresses",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "people_addresses_u1",
                        columnNames = {
                                "(coalesce(parent_id, 0))","status_reg_id","data_origin_id","(coalesce(table_origin_id, 0))","(coalesce(id_at_origin, 0))",
                                "people_id", "(COALESCE(address_type_id,0))","address_id"
                        }
                )
        }
)
public class PeopleAddress extends BaseBasicEntity {

    @Column(name = "people_id", nullable = false)
    private Long peopleId;

    @Column(name = "address_type_id")
    private Long addressTypeId;

    @Column(name = "address_id", nullable = false)
    private Long addressU;

    @Column(name = "numeric_order")
    private Integer numericOrder;

    @Column(name = "notes")
    private String notes;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "people_id", insertable = false, updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private People people;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_type_id", insertable = false, updatable = false)
    private AddressType addressType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id", insertable = false, updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Address address;

    protected static final long TABLE_ID = 2014;
    public static long getTableId() {
        return TABLE_ID;
    }


}