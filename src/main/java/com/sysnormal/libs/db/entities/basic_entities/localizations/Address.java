package com.sysnormal.libs.db.entities.basic_entities.localizations;

import com.sysnormal.libs.db.entities.basic_entities.BaseBasicEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(
        name = "addresses",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "addresses_u1",
                        columnNames = {
                            "(coalesce(parent_id, 0))","status_reg_id","data_origin_id","(coalesce(table_origin_id, 0))","(coalesce(id_at_origin, 0))",
                            "address_type_id",
                            "(COALESCE(neighborhood_id,0))",
                            "(COALESCE(street_id,0))",
                            "(COALESCE(postal_code_id,0))",
                            "(COALESCE(latitude,0))",
                            "(COALESCE(longitude,0))",
                            "(COALESCE(number,'NULL'))",
                            "(COALESCE(CAST(complement AS CHAR(255)), 'NULL'))"
                        }
                )
        }
)
public class Address extends BaseBasicEntity {

    @Column(name = "address_type_id", nullable = false)
    private Long addressTypeId;

    @Column(name = "neighborhood_id")
    private Long neighborhoodId;

    @Column(name = "street_id")
    private Long streetId;

    @Column(name = "postal_code_id")
    private Long postalCodeId;

    @Column(name = "latitude", precision = 18, scale = 10)
    private BigDecimal latitude;

    @Column(name = "longitude", precision = 18, scale = 10)
    private BigDecimal longitude;

    @Column(name = "number")
    private String number;

    @Column(name = "complement")
    private String complement;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_type_id", updatable = false, insertable = false)
    private AddressType addressType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "neighborhood_id", updatable = false, insertable = false)
    private Neighborhood neighborhood;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "street_id", updatable = false, insertable = false)
    private Street street;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "postal_code_id", updatable = false, insertable = false)
    private PostalCode postalCode;

    protected static final long TABLE_ID = 2011L;
    public static long getTableId() {
        return TABLE_ID;
    }
}
