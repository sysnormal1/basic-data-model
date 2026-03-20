package com.sysnormal.data.basic_data_model.entities.conditions.condition;

import com.sysnormal.data.basic_data_model.entities.BaseBasicEntity;
import com.sysnormal.data.basic_data_model.entities.commons.entityType.EntityType;
import com.sysnormal.data.basic_data_model.entities.conditions.comparator.Comparator;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Entity class
 */
@Getter
@Setter
@Entity
@Table(
        name = "conditions",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "conditions_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "entity_type_id",
                                "entity_id",
                                "(COALESCE(record_id,0))",
                                "(COALESCE(comparation_id,0))",
                                "(COALESCE(start_at,'1900-01-01'))"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Condition extends BaseBasicEntity<Condition> {

    @Column(name = "entity_type_id", nullable = false)
    private Long entityTypeId;

    @Column(name = "entity_id", nullable = false)
    private Long entityId;

    @Column(name = "record_id")
    private Long recordId;

    @Column(name = "comparation_id")
    private Long comparationId;

    @Column(name = "expression", length = Integer.MAX_VALUE)
    private String expression;

    @Column(name = "start_at")
    private LocalDateTime startAt;

    @Column(name = "end_at")
    private LocalDateTime endAt;

    @Column(name = "notes", length = Integer.MAX_VALUE)
    private String notes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "entity_type_id", updatable = false, insertable = false)
    private EntityType entityType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comparation_id", updatable = false, insertable = false)
    private Comparator comparation;

    protected static final long TABLE_ID = 7004;
    public static long getTableId() {
        return TABLE_ID;
    }
}
