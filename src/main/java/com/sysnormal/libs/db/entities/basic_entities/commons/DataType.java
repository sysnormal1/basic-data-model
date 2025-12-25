package com.sysnormal.libs.db.entities.basic_entities.commons;

import com.sysnormal.libs.db.entities.basic_entities.BaseBasicEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Getter
@Setter
@Table(
        name = "data_types",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "data_types_u1",
                        columnNames = {
                                "(coalesce(parent_id, 0))","status_reg_id","data_origin_id","(coalesce(table_origin_id, 0))","(coalesce(id_at_origin, 0))",
                                "name"
                        }
                )
        }
)
public class DataType extends BaseBasicEntity<DataType> {

    @Column(name = "name", nullable = false, length = 127)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "is_bool", nullable = false)
    @ColumnDefault("0")
    @Check(constraints = "is_bool in (0,1)")
    private byte isBool = 0;

    @Column(name = "is_text", nullable = false)
    @ColumnDefault("0")
    @Check(constraints = "is_text in (0,1)")
    private byte isText = 0;

    @Column(name = "is_number", nullable = false)
    @ColumnDefault("0")
    @Check(constraints = "is_number in (0,1)")
    private byte isNumber = 0;

    @Column(name = "is_array", nullable = false)
    @ColumnDefault("0")
    @Check(constraints = "is_array in (0,1)")
    private byte isArray = 0;

    @Column(name = "is_object", nullable = false)
    @ColumnDefault("0")
    @Check(constraints = "is_object in (0,1)")
    private byte isObject = 0;

    @Column(name = "is_decimal", nullable = false)
    @ColumnDefault("0")
    @Check(constraints = "is_decimal in (0,1)")
    private byte isDecimal = 0;

    @Column(name = "is_date", nullable = false)
    @ColumnDefault("0")
    @Check(constraints = "is_date in (0,1)")
    private byte isDate = 0;

    @Column(name = "is_time", nullable = false)
    @ColumnDefault("0")
    @Check(constraints = "is_time in (0,1)")
    private byte isTime = 0;

    @Column(name = "is_other", nullable = false)
    @ColumnDefault("0")
    @Check(constraints = "is_other in (0,1)")
    private byte isOther = 0;

    protected static final long TABLE_ID = 50;
    public static long getTableId() {
        return TABLE_ID;
    }

    // Constantes equivalentes
    public static final long ANY_ID = 1;
    public static final long STRING_ID = 2;
    public static final long INTEGER_ID = 3;
    public static final long BOOLEAN_ID = 4;
    public static final long ARRAY_ID = 5;
    public static final long OBJECT_ID = 6;
    public static final long NUMBER_ID = 7;
    public static final long DATE_ID = 8;
    public static final long TIME_ID = 9;
    public static final long DATETIME_ID = 10;

    public static final DataType ANY = new DataType(){{
        setId(ANY_ID);
        setIsSysRec((byte) 1);
        setName("ANY");
        setIsOther((byte) 1);
    }};
    public static final DataType STRING = new DataType(){{
        setId(STRING_ID);
        setIsSysRec((byte) 1);
        setName("STRING");
        setIsText((byte) 1);
    }};
    public static final DataType INTEGER = new DataType(){{
        setId(INTEGER_ID);
        setIsSysRec((byte) 1);
        setName("INTEGER");
        setIsNumber((byte) 1);
    }};
    public static final DataType BOOLEAN = new DataType(){{
        setId(BOOLEAN_ID);
        setIsSysRec((byte) 1);
        setName("BOOLEAN");
        setIsBool((byte) 1);
    }};
    public static final DataType ARRAY = new DataType(){{
        setId(ARRAY_ID);
        setIsSysRec((byte) 1);
        setName("ARRAY");
        setIsArray((byte) 1);
    }};
    public static final DataType OBJECT = new DataType(){{
        setId(OBJECT_ID);
        setIsSysRec((byte) 1);
        setName("OBJECT");
        setIsObject((byte) 1);
    }};
    public static final DataType NUMBER = new DataType(){{
        setId(NUMBER_ID);
        setIsSysRec((byte) 1);
        setName("NUMBER");
        setIsNumber((byte) 1);
    }};
    public static final DataType DATE = new DataType(){{
        setId(DATE_ID);
        setIsSysRec((byte) 1);
        setName("DATE");
        setIsDate((byte) 1);
    }};
    public static final DataType TIME = new DataType(){{
        setId(TIME_ID);
        setIsSysRec((byte) 1);
        setName("TIME");
        setIsTime((byte) 1);
    }};
    public static final DataType DATETIME = new DataType(){{
        setId(DATETIME_ID);
        setIsSysRec((byte) 1);
        setName("DATETIME");
        setIsTime((byte) 1);
    }};

}