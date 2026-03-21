package com.sysnormal.data.basic_data_model.entities.localizations.postalCode;

import com.sysnormal.data.basic_data_model.entities.BaseBasicEntity;
import com.sysnormal.data.basic_data_model.entities.localizations.addressType.AddressType;
import com.sysnormal.data.basic_data_model.entities.localizations.city.City;
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
        name = "postal_codes",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "postal_codes_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "postal_code", "address_type_id", "city_id"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class PostalCode extends BaseBasicEntity<PostalCode> {

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
}
