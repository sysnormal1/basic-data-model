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
        name = "cities",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "cities_u1",
                        columnNames = {
                                "(coalesce(parent_id, 0))","status_reg_id","data_origin_id","(coalesce(table_origin_id, 0))","(coalesce(id_at_origin, 0))",
                                "state_id", "name"
                        }
                )
        }
)
public class City extends BaseBasicEntity {

    @Column(name = "state_id", nullable = false)
    private Long stateId;

    @Column(name = "name", nullable = false, length = 127)
    private String name;

    @Column(name = "sigla", length = 10)
    private String sigla;

    @Column(name = "population")
    private Long population;

    @Column(name = "latitude", precision = 18, scale = 10)
    private BigDecimal latitude;

    @Column(name = "longitude", precision = 18, scale = 10)
    private BigDecimal longitude;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "state_id", updatable = false, insertable = false)
    private State state;

    protected static final long TABLE_ID = 2003L;
    public static long getTableId() {
        return TABLE_ID;
    }
}
