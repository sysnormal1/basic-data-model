package com.sysnormal.libs.db.entities.basic_entities.localizations;

import com.sysnormal.libs.db.entities.basic_entities.BaseBasicEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(
        name = "street_types",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "street_types_u1",
                        columnNames = {
                                "(coalesce(parent_id, 0))","status_reg_id","data_origin_id","(coalesce(table_origin_id, 0))","(coalesce(id_at_origin, 0))",
                                "name"
                        }
                )
        }
)
public class StreetType extends BaseBasicEntity<StreetType> {

    @Column(name = "name", nullable = false, length = 127)
    private String name;

    protected static final long TABLE_ID = 2005L;
    public static long getTableId() {
        return TABLE_ID;
    }

    public static final long STREET_ID = 1L;
    public static final long AVENUE_ID = 2L;

    public static final StreetType STREET = new StreetType(){{
        setId(STREET_ID);
        setIsSysRec((byte) 1);
        setName("STREET");
    }};
    public static final StreetType AVENUE = new StreetType(){{
        setId(AVENUE_ID);
        setIsSysRec((byte) 1);
        setName("AVENUE");
    }};
}
