package com.sysnormal.libs.db.entities.basic_entities.items.gtinType;

import com.sysnormal.libs.db.entities.basic_entities.BaseBasicEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(
        name = "gtin_types",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "gtin_types_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "name",
                                "(coalesce(characters,0))"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class GtinType extends BaseBasicEntity<GtinType> {

    @Column(name = "name", nullable = false,length = 127)
    private String name;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @Column(name = "characters")
    private Long characters;


    protected static final long TABLE_ID = 8007;

    public static long getTableId() {
        return TABLE_ID;
    }


    public static final long UNDEFINED_ID = 1;
    public static final long GTIN8_ID = 8;
    public static final long GTIN12_ID = 12;
    public static final long GTIN13_ID = 13;
    public static final long GTIN14_ID = 14;

    public static final GtinType UNDEFINED = new GtinType(){{
        setId(UNDEFINED_ID);
        setIsSysRec((byte) 1);
        setName("UNDEFINED");
    }};

    public static final GtinType GTIN8 = new GtinType(){{
        setId(GTIN8_ID);
        setIsSysRec((byte) 1);
        setName("GTIN8");
        setCharacters(GTIN8_ID);
    }};
    public static final GtinType GTIN12 = new GtinType(){{
        setId(GTIN12_ID);
        setIsSysRec((byte) 1);
        setName("GTIN12");
        setCharacters(GTIN12_ID);
    }};
    public static final GtinType GTIN13 = new GtinType(){{
        setId(GTIN13_ID);
        setIsSysRec((byte) 1);
        setName("GTIN13");
        setCharacters(GTIN13_ID);
    }};
    public static final GtinType GTIN14 = new GtinType(){{
        setId(GTIN14_ID);
        setIsSysRec((byte) 1);
        setName("GTIN14");
        setCharacters(GTIN14_ID);
    }};

}