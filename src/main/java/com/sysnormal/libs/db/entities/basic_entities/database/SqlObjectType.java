package com.sysnormal.libs.db.entities.basic_entities.database;

import com.sysnormal.libs.db.entities.basic_entities.BaseBasicEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(
        name = "sql_object_types",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "sql_object_types_u1",
                        columnNames = {
                                "(coalesce(parent_id, 0))","status_reg_id","data_origin_id","(coalesce(table_origin_id, 0))","(coalesce(id_at_origin, 0))",
                                "name"
                        }
                )
        }
)
public class SqlObjectType extends BaseBasicEntity<SqlObjectType> {

    @Column(name = "name", nullable = false, length = 127)
    private String name;

    @Column(name = "description")
    private String description;


    protected static final long TABLE_ID = 10000;
    public static long getTableId() {
        return TABLE_ID;
    }

    public static final long DATABASE_ID = 1;
    public static final long USER_ID = 100;
    public static final long SCHEMA_ID = 200;
    public static final long TABLE_OBJECT_ID = 300;
    public static final long FIELD_ID = 400;
    public static final long SELECT_ID = 1000;
    public static final long FROM_ID = 1100;
    public static final long JOIN_ID = 1150;
    public static final long ON_ID = 1155;
    public static final long WHERE_ID = 1200;
    public static final long GROUP_BY_ID = 1300;
    public static final long HAVING_ID = 1400;
    public static final long ORDER_BY_ID = 1500;
    public static final long PIVOT_ID = 1600;
    public static final long FOR_ID = 1650;
    public static final long IN_ID = 1655;
    public static final long TEXT_ID = 10000;

    public static final SqlObjectType DATABASE = new SqlObjectType(){{
        setId(DATABASE_ID);
        setIsSysRec((byte) 1);
        setName("DATABASE");
    }};
    public static final SqlObjectType USER = new SqlObjectType(){{
        setId(USER_ID);
        setIsSysRec((byte) 1);
        setParentId(DATABASE_ID);
        setName("USER");
    }};
    public static final SqlObjectType SCHEMA = new SqlObjectType(){{
        setId(SCHEMA_ID);
        setIsSysRec((byte) 1);
        setParentId(DATABASE_ID);
        setName("SCHEMA");
    }};
    public static final SqlObjectType TABLE = new SqlObjectType(){{
        setId(TABLE_OBJECT_ID);
        setIsSysRec((byte) 1);
        setParentId(SCHEMA_ID);
        setName("TABLE");
    }};
    public static final SqlObjectType FIELD = new SqlObjectType(){{
        setId(FIELD_ID);
        setIsSysRec((byte) 1);
        setParentId(TABLE_OBJECT_ID);
        setName("FIELD");
    }};
    public static final SqlObjectType SELECT = new SqlObjectType(){{
        setId(SELECT_ID);
        setIsSysRec((byte) 1);
        setName("SELECT");
    }};
    public static final SqlObjectType FROM = new SqlObjectType(){{
        setId(FROM_ID);
        setIsSysRec((byte) 1);
        setParentId(SELECT_ID);
        setName("FROM");
    }};
    public static final SqlObjectType JOIN = new SqlObjectType(){{
        setId(JOIN_ID);
        setIsSysRec((byte) 1);
        setParentId(FROM_ID);
        setName("JOIN");
    }};
    public static final SqlObjectType ON = new SqlObjectType(){{
        setId(ON_ID);
        setIsSysRec((byte) 1);
        setParentId(JOIN_ID);
        setName("ON");
    }};
    public static final SqlObjectType WHERE = new SqlObjectType(){{
        setId(WHERE_ID);
        setIsSysRec((byte) 1);
        setParentId(SELECT_ID);
        setName("WHERE");
    }};
    public static final SqlObjectType GROUP_BY = new SqlObjectType(){{
        setId(GROUP_BY_ID);
        setIsSysRec((byte) 1);
        setParentId(SELECT_ID);
        setName("GROUP BY");
    }};
    public static final SqlObjectType HAVING = new SqlObjectType(){{
        setId(HAVING_ID);
        setIsSysRec((byte) 1);
        setParentId(SELECT_ID);
        setName("HAVING");
    }};
    public static final SqlObjectType ORDER_BY = new SqlObjectType(){{
        setId(ORDER_BY_ID);
        setIsSysRec((byte) 1);
        setParentId(SELECT_ID);
        setName("ORDER BY");
    }};
    public static final SqlObjectType PIVOT = new SqlObjectType(){{
        setId(PIVOT_ID);
        setIsSysRec((byte) 1);
        setParentId(SELECT_ID);
        setName("PIVOT");
    }};
    public static final SqlObjectType FOR = new SqlObjectType(){{
        setId(FOR_ID);
        setIsSysRec((byte) 1);
        setParentId(PIVOT_ID);
        setName("FOR");
    }};
    public static final SqlObjectType IN = new SqlObjectType(){{
        setId(IN_ID);
        setIsSysRec((byte) 1);
        setParentId(PIVOT_ID);
        setName("IN");
    }};
    public static final SqlObjectType TEXT = new SqlObjectType(){{
        setId(TEXT_ID);
        setIsSysRec((byte) 1);
        setName("TEXT");
    }};

}