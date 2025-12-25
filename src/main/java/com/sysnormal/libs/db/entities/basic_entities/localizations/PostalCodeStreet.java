package com.sysnormal.libs.db.entities.basic_entities.localizations;

import com.sysnormal.libs.db.entities.basic_entities.BaseBasicEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Table(
        name = "postal_codes_streets",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "postal_codes_streets_u1",
                        columnNames = {
                                "(coalesce(parent_id, 0))","status_reg_id","data_origin_id","(coalesce(table_origin_id, 0))","(coalesce(id_at_origin, 0))",
                                "postal_code_id",
                                "neighborhood_id",
                                "street_id"
                        }
                )
        }
)
public class PostalCodeStreet extends BaseBasicEntity<PostalCodeStreet> {

    @Column(name = "postal_code_id", nullable = false)
    private Long postalCodeId;

    @Column(name = "neighborhood_id",nullable = false)
    private Long neighborhoodId;

    @Column(name = "street_id",nullable = false)
    private Long streetId;

    @Column(name = "notes")
    private String notes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "postal_code_id", insertable = false, updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private PostalCode postalCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "neighborhood_id", insertable = false, updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Neighborhood neighborhood;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "street_id", insertable = false, updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Street street;

    protected static final long TABLE_ID = 2009;
    public static long getTableId() {
        return TABLE_ID;
    }

}
