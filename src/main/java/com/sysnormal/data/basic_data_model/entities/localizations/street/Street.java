package com.sysnormal.data.basic_data_model.entities.localizations.street;

import com.sysnormal.data.basic_data_model.entities.BaseBasicEntity;
import com.sysnormal.data.basic_data_model.entities.localizations.city.City;
import com.sysnormal.data.basic_data_model.entities.localizations.streetType.StreetType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

/**
 * Entity class
 */
@Getter
@Setter
@Entity
@Table(
        name = "streets",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "streets_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "street_type_id", "city_id", "name"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Street extends BaseBasicEntity<Street> {

    @Column(name = "street_type_id", nullable = false)
    @ColumnDefault(StreetType.STREET_ID+"")
    private Long streetTypeId = StreetType.STREET_ID;

    @Column(name = "city_id", nullable = false)
    private Long cityId;

    @Column(name = "name", nullable = false, length = 127)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "street_type_id", updatable = false, insertable = false)
    private StreetType streetType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id", updatable = false, insertable = false)
    private City city;

    protected static final long TABLE_ID = 2006L;
    public static long getTableId() {
        return TABLE_ID;
    }
}
