package com.sysnormal.libs.db.entities.basic_entities.localizations;

import com.sysnormal.libs.db.entities.basic_entities.BaseBasicEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(
        name = "postal_codes_paths",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "postal_codes_paths_u1",
                        columnNames = {
                                "(coalesce(parent_id, 0))","status_reg_id","data_origin_id","(coalesce(table_origin_id, 0))","(coalesce(id_at_origin, 0))",
                                "postal_code_id",
                                "(COALESCE(postal_code_street_id,0))",
                                "(COALESCE(latitude,0))",
                                "(COALESCE(longitude,0))",
                                "(COALESCE(start_number,'NULL'))",
                                "(COALESCE(end_number,'NULL'))",
                        }
                )
        }
)
public class PostalCodePath extends BaseBasicEntity {

    @Column(name = "postal_code_id", nullable = false)
    private Long postalCodeId;

    @Column(name = "postal_code_street_id")
    private Long postalCodeStreetId;

    @Column(name = "latitude", precision = 32, scale = 10)
    private BigDecimal latitude;

    @Column(name = "longitude", precision = 32, scale = 10)
    private BigDecimal longitude;

    @Column(name = "start_number", length = 127)
    private String startNumber;

    @Column(name = "end_number", length = 127)
    private String endNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "postal_code_id", insertable = false, updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private PostalCode postalCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "postal_code_street_id", insertable = false, updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private PostalCodeStreet postalCodeStreet;

    protected static final long TABLE_ID = 2010;
    public static long getTableId() {
        return TABLE_ID;
    }

}
