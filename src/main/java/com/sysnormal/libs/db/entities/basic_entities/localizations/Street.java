package com.sysnormal.libs.db.entities.basic_entities.localizations;

import com.sysnormal.libs.db.entities.basic_entities.BaseBasicEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(
        name = "streets",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "streets_u1",
                        columnNames = {
                                "(coalesce(parent_id, 0))","status_reg_id","data_origin_id","(coalesce(table_origin_id, 0))","(coalesce(id_at_origin, 0))",
                                "street_type_id", "city_id", "name"
                        }
                )
        }
)
public class Street extends BaseBasicEntity {

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
