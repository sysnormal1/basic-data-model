package com.sysnormal.libs.db.entities.basic_entities.conditions.comparator;

import com.sysnormal.libs.db.entities.basic_entities.BaseBasicEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(
        name = "comparators",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "comparators_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "name"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Comparator extends BaseBasicEntity<Comparator> {

    @Column(name = "name", nullable = false, length = 127)
    private String name;

    protected static final long TABLE_ID = 1005;
    public static long getTableId() {
        return TABLE_ID;
    }

    public static final long EQUAL_ID = 1;
    public static final long DIFFERENT_ID = 2;
    public static final long IN_ID = 3;
    public static final long NOT_IN_ID = 4;
    public static final long LIKE_ID = 5;
    public static final long NOT_LIKE_ID = 6;
    public static final long GREATER_ID = 7;
    public static final long GREATER_EQUAL_ID = 8;
    public static final long SMALLER_ID = 9;
    public static final long SMALLER_EQUAL_ID = 10;

    public static final Comparator EQUAL = new Comparator(){{
        setId(EQUAL_ID);
        setIsSysRec((byte) 1);
        setName("EQUAL");
    }};
    public static final Comparator DIFFERENT = new Comparator(){{
        setId(DIFFERENT_ID);
        setIsSysRec((byte) 1);
        setName("DIFFERENT");
    }};
    public static final Comparator IN = new Comparator(){{
        setId(IN_ID);
        setIsSysRec((byte) 1);
        setName("IN");
    }};
    public static final Comparator NOT_IN = new Comparator(){{
        setId(NOT_IN_ID);
        setIsSysRec((byte) 1);
        setName("NOT_IN");
    }};
    public static final Comparator LIKE = new Comparator(){{
        setId(LIKE_ID);
        setIsSysRec((byte) 1);
        setName("LIKE");
    }};
    public static final Comparator NOT_LIKE = new Comparator(){{
        setId(NOT_LIKE_ID);
        setIsSysRec((byte) 1);
        setName("NOT_LIKE");
    }};
    public static final Comparator GREATER = new Comparator(){{
        setId(GREATER_ID);
        setIsSysRec((byte) 1);
        setName("GREATER");
    }};
    public static final Comparator GREATER_EQUAL = new Comparator(){{
        setId(GREATER_EQUAL_ID);
        setIsSysRec((byte) 1);
        setName("GREATER_EQUAL");
    }};
    public static final Comparator SMALLER = new Comparator(){{
        setId(SMALLER_ID);
        setIsSysRec((byte) 1);
        setName("SMALLER");
    }};
    public static final Comparator SMALLER_EQUAL = new Comparator(){{
        setId(SMALLER_EQUAL_ID);
        setIsSysRec((byte) 1);
        setName("SMALLER_EQUAL");
    }};
}


