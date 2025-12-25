package com.sysnormal.libs.db.entities.basic_entities.localizations;

import com.sysnormal.libs.db.entities.basic_entities.BaseBasicEntity;
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
                                "(coalesce(parent_id, 0))","status_reg_id","data_origin_id","(coalesce(table_origin_id, 0))","(coalesce(id_at_origin, 0))",
                                "city_id", "name"
                        }
                )
        }
)
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
