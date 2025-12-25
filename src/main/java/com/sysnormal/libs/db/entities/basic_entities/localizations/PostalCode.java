package com.sysnormal.libs.db.entities.basic_entities.localizations;

import com.sysnormal.libs.db.entities.basic_entities.BaseBasicEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(
        name = "postal_codes",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "postal_codes_u1",
                        columnNames = {
                                "(coalesce(parent_id, 0))","status_reg_id","data_origin_id","(coalesce(table_origin_id, 0))","(coalesce(id_at_origin, 0))",
                                "postal_code", "address_type_id", "city_id"
                        }
                )
        }
)
public class PostalCode extends BaseBasicEntity {

    @Column(name = "postal_code", nullable = false, length = 127)
    private String postalCode;

    @Column(name = "address_type_id", nullable = false)
    private Long addressTypeId;

    @Column(name = "city_id", nullable = false)
    private Long cityId;

    @Column(name = "complement")
    private String complement;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_type_id", updatable = false, insertable = false)
    private AddressType addressType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id", updatable = false, insertable = false)
    private City city;

    protected static final long TABLE_ID = 2008L;
    public static long getTableId() {
        return TABLE_ID;
    }
}
