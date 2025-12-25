package com.sysnormal.libs.db.entities.basic_entities.commons;

import com.sysnormal.libs.db.entities.basic_entities.BaseBasicEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(
        name = "relationship_values",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "relationship_values_u1",
                        columnNames = {
                                "(coalesce(parent_id, 0))","status_reg_id","data_origin_id","(coalesce(table_origin_id, 0))","(coalesce(id_at_origin, 0))",
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
public class RelationshipValue extends BaseBasicEntity {

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
