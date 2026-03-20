package com.sysnormal.data.basic_data_model.entities.commons.listName;

import com.sysnormal.data.basic_data_model.entities.BaseBasicEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

/**
 * Entity class
 */
@Entity
@Getter
@Setter
@Table(
        name = "lists_names",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "lists_names_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "name"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class ListName extends BaseBasicEntity<ListName> {

    @Column(name = "name", nullable = false, length = 127)
    private String name;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @Column(name = "integer_value_1")
    private Integer integerValue1;

    @Column(name = "integer_value_2")
    private Integer integerValue2;

    @Column(name = "integer_value_3")
    private Integer integerValue3;

    @Column(name = "bigint_value_1")
    private BigInteger bigintValue1;

    @Column(name = "bigint_value_2")
    private BigInteger bigintValue2;

    @Column(name = "bigint_value_3")
    private BigInteger bigintValue3;

    @Column(name = "decimal_value_1", precision = 38, scale = 10)
    private BigDecimal decimalValue1;

    @Column(name = "decimal_value_2", precision = 38, scale = 10)
    private BigDecimal decimalValue2;

    @Column(name = "decimal_value_3", precision = 38, scale = 10)
    private BigDecimal decimalValue3;

    @Column(name = "string_value_1", length = 4000)
    private String stringValue1;

    @Column(name = "string_value_2", length = 4000)
    private String stringValue2;

    @Column(name = "string_value_3", length = 4000)
    private String stringValue3;

    @Column(name = "text_value_1", length = Integer.MAX_VALUE)
    private String textValue1;

    @Column(name = "text_value_2", length = Integer.MAX_VALUE)
    private String textValue2;

    @Column(name = "text_value_3", length = Integer.MAX_VALUE)
    private String textValue3;

    @Column(name = "boolean_value_1")
    private Boolean booleanValue1;

    @Column(name = "boolean_value_2")
    private Boolean booleanValue2;

    @Column(name = "boolean_value_3")
    private Boolean booleanValue3;

    @Column(name = "date_value_1")
    private LocalDateTime dateValue1;

    @Column(name = "date_value_2")
    private LocalDateTime dateValue2;

    @Column(name = "date_value_3")
    private LocalDateTime dateValue3;

    @Column(name = "notes", length = Integer.MAX_VALUE)
    private String notes;

    protected static final long TABLE_ID = 1004;
    public static long getTableId() {
        return TABLE_ID;
    }

    public static final long CATEGORIES_ITEMS_NAMES_X_NCM_ID = 1;

    public static final ListName CATEGORIES_ITEMS_NAMES_X_NCM = new ListName(){{
        setId(CATEGORIES_ITEMS_NAMES_X_NCM_ID);
        setIsSysRec((byte) 1);
        setName("CATEGORIES_ITEMS_NAMES_X_NCM");
    }};
}