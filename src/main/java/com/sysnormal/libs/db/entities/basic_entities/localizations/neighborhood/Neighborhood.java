package com.sysnormal.libs.db.entities.basic_entities.localizations.neighborhood;

import com.sysnormal.libs.db.entities.basic_entities.BaseBasicEntity;
import com.sysnormal.libs.db.entities.basic_entities.localizations.city.City;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(
        name = "neighborhoods",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "neighborhoods_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "city_id", "name"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Neighborhood extends BaseBasicEntity<Neighborhood> {

    @Column(name = "city_id", nullable = false)
    private Long cityId;

    @Column(name = "name", nullable = false, length = 127)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id", updatable = false, insertable = false)
    private City city;

    protected static final long TABLE_ID = 2004L;
    public static long getTableId() {
        return TABLE_ID;
    }
}
