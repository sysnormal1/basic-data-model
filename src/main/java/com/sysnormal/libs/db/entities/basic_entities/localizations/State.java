package com.sysnormal.libs.db.entities.basic_entities.localizations;

import com.sysnormal.libs.db.entities.basic_entities.BaseBasicEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(
        name = "states",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "states_u1",
                        columnNames = {
                                "(coalesce(parent_id, 0))","status_reg_id","data_origin_id","(coalesce(table_origin_id, 0))","(coalesce(id_at_origin, 0))",
                                "country_id", "name"
                        }
                )
        }
)
public class State extends BaseBasicEntity {

    @Column(name = "country_id", nullable = false)
    private Long countryId;

    @Column(name = "name", nullable = false, length = 127)
    private String name;

    @Column(name = "sigla", length = 10)
    private String sigla;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", updatable = false, insertable = false)
    private Country country;

    protected static final long TABLE_ID = 2002L;
    public static long getTableId() {
        return TABLE_ID;
    }
}
