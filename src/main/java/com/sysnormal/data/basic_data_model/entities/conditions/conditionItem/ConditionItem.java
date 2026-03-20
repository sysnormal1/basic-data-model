package com.sysnormal.data.basic_data_model.entities.conditions.conditionItem;

import com.sysnormal.data.basic_data_model.entities.BaseBasicEntity;
import com.sysnormal.data.basic_data_model.entities.conditions.condition.Condition;
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
        name = "condition_items"
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class ConditionItem extends BaseBasicEntity<ConditionItem> {

    @Column(name = "condition_id", nullable = false)
    private Long conditionId;

    @Column(name = "value", length = Integer.MAX_VALUE)
    private String value;

    @Column(name = "expression", length = Integer.MAX_VALUE)
    private String expression;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "condition_id", updatable = false, insertable = false)
    private Condition condition;

    protected static final long TABLE_ID = 7005;
    public static long getTableId() {
        return TABLE_ID;
    }
}
