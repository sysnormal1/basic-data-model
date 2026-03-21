package com.sysnormal.data.basic_data_model.entities.localizations.continent;

import com.sysnormal.data.basic_data_model.entities.BaseBasicEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Entity class
 */
@Getter
@Setter
@Entity
@Table(
        name = "continents",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "continents_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "name"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Continent extends BaseBasicEntity<Continent> {

    @Column(name = "name", nullable = false, length = 127)
    private String name;

    @Column(name = "sigla", length = 10)
    private String sigla;

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
