package com.sysnormal.libs.db.entities.basic_entities.commons;

import com.sysnormal.libs.db.entities.basic_entities.BaseBasicEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(
        name = "condition_items"
)
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
