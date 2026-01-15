package com.sysnormal.libs.db.entities.basic_entities.localizations.city;

import com.sysnormal.libs.db.entities.basic_entities.BaseBasicEntity;
import com.sysnormal.libs.db.entities.basic_entities.localizations.state.State;
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
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "state_id", "name"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class City extends BaseBasicEntity<City> {

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
