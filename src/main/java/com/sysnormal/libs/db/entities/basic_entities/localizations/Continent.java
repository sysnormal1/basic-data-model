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
        name = "continents",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "continents_u1",
                        columnNames = {
                                "(coalesce(parent_id, 0))","status_reg_id","data_origin_id","(coalesce(table_origin_id, 0))","(coalesce(id_at_origin, 0))",
                                "name"
                        }
                )
        }
)
public class Continent extends BaseBasicEntity {

    @Column(name = "name", nullable = false, length = 127)
    private String name;

    @Column(name = "sigla", length = 10)
    private String sigla;

    protected static final long TABLE_ID = 2000L;
    public static long getTableId() {
        return TABLE_ID;
    }

    public static final long SYSTEM_ID = 0;
    public static final long AMERICA_ID = 1;
    public static final long SOUTH_AMERICA_ID = 2;

    public static final Continent SYSTEM = new Continent(){{
        setId(SYSTEM_ID);
        setIsSysRec((byte) 1);
        setName("SYSTEM");
        setSigla("SY");
    }};
    public static final Continent AMERICA = new Continent(){{
        setId(AMERICA_ID);
        setIsSysRec((byte) 1);
        setName("AMERICA");
        setSigla("AM");
    }};
    public static final Continent SOUTH_AMERICA = new Continent(){{
        setId(SOUTH_AMERICA_ID);
        setIsSysRec((byte) 1);
        setParentId(AMERICA_ID);
        setName("SOUTH AMERICA");
        setSigla("AL");
    }};
}
