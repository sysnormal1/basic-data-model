package com.sysnormal.data.basic_data_model.entities.relationships.relationshipValue;

import com.sysnormal.data.basic_data_model.entities.BaseBasicEntity;
import com.sysnormal.data.basic_data_model.entities.commons.context.Context;
import com.sysnormal.data.basic_data_model.entities.commons.identifierType.IdentifierType;
import com.sysnormal.data.basic_data_model.entities.records.dataType.DataType;
import com.sysnormal.data.basic_data_model.entities.relationships.relationship.Relationship;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigInteger;
import java.time.LocalDateTime;

/**
 * Entity class
 */
@Getter
@Setter
@Entity
@Table(
        name = "relationship_values",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "relationship_values_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "data_relationship_id",
                                "(COALESCE(context_id,0))",
                                "identifier_type_id",
                                "data_type_id",
                                "(COALESCE(value,'NULL'))",
                                "(COALESCE(numeric_order,0))",
                                "(COALESCE(start_at,'1900-01-01'))"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class RelationshipValue extends BaseBasicEntity<RelationshipValue> {

    @Column(name = "data_relationship_id", nullable = false)
    private Long dataRelationshipId;

    @Column(name = "context_id")
    private Long contextId;

    @Column(name = "identifier_type_id", nullable = false)
    private Long identifierTypeId;

    @Column(name = "data_type_id", nullable = false)
    private Long dataTypeId;

    @Column(name = "value", length = 127)
    private String value;

    @Column(name = "numeric_order")
    private BigInteger numericOrder;

    @Column(name = "start_at")
    private LocalDateTime startAt;

    @Column(name = "end_at")
    private LocalDateTime endAt;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "data_relationship_id", insertable = false, updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Relationship dataRelationship;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "context_id", insertable = false, updatable = false)
    private Context context;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "identifier_type_id", insertable = false, updatable = false)
    private IdentifierType identifierType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "data_type_id", insertable = false, updatable = false)
    private DataType dataType;

    protected static final long TABLE_ID = 1003;
    public static long getTableId() {
        return TABLE_ID;
    }

}
