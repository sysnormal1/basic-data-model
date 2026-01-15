package com.sysnormal.libs.db.entities.basic_entities.relationships.relationship;

import com.sysnormal.libs.db.entities.basic_entities.BaseBasicEntity;
import com.sysnormal.libs.db.entities.basic_entities.commons.context.Context;
import com.sysnormal.libs.db.entities.basic_entities.database.tables.Tables;
import com.sysnormal.libs.db.entities.basic_entities.relationships.relationshipType.RelationshipType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(
        name = "relationships",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "relationships_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "relationship_type_id",
                                "table_1_id",
                                "table_2_id",
                                "(COALESCE(record_1_column,'id'))",
                                "(COALESCE(record_2_column,'id'))",
                                "(COALESCE(record_1_id,0))",
                                "(COALESCE(record_2_id,0))",
                                "(COALESCE(context_id,0))",
                                "(COALESCE(numeric_order,0))",
                                "(COALESCE(start_at,'1900-01-01'))"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Relationship extends BaseBasicEntity<Relationship> {

    @Column(name = "relationship_type_id", nullable = false)
    private Long relationshipTypeId;

    @Column(name = "table_1_id", nullable = false)
    private Long table1Id;

    @Column(name = "record_1_column", length = 127)
    private String record1Column;

    @Column(name = "record_1_id")
    private Long record1Id;

    @Column(name = "record_1_conditions", length = Integer.MAX_VALUE)
    private String record1Conditions;

    @Column(name = "table_2_id", nullable = false)
    private Long table2Id;

    @Column(name = "record_2_column", length = 227)
    private String record2Column;

    @Column(name = "record_2_id")
    private Long record2Id;

    @Column(name = "record_2_conditions", length = Integer.MAX_VALUE)
    private String record2Conditions;

    @Column(name = "context_id")
    private Long contextId;

    @Column(name = "value", length = 127)
    private String value;

    @Column(name = "numeric_order")
    private BigInteger numericOrder;

    @Column(name = "start_at")
    private LocalDateTime startAt;

    @Column(name = "end_at")
    private LocalDateTime endAt;

    @Column(name = "description")
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

    @Column(name = "notes")
    private String notes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "relationship_type_id", insertable = false, updatable = false)
    private RelationshipType relationshipType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "table_1_id", insertable = false, updatable = false)
    private Tables table1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "table_2_id", insertable = false, updatable = false)
    private Tables table2;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "context_id", insertable = false, updatable = false)
    private Context context;

    protected static final long TABLE_ID = 1001;
    public static long getTableId() {
        return TABLE_ID;
    }

}