package com.sysnormal.libs.db.entities.basic_entities.logistic.logisticOrderMov;

import com.sysnormal.libs.db.entities.basic_entities.BaseBasicEntity;
import com.sysnormal.libs.db.entities.basic_entities.commons.actionStatus.ActionStatus;
import com.sysnormal.libs.db.entities.basic_entities.logistic.logisticOrder.LogisticOrder;
import com.sysnormal.libs.db.entities.basic_entities.logistic.logisticReason.LogisticReason;
import com.sysnormal.libs.db.entities.basic_entities.logistic.logisticStatus.LogisticStatus;
import com.sysnormal.libs.db.entities.basic_entities.movements.movement.Movement;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(
        name = "logistic_orders_movs",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "logistic_orders_movs_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "logistic_order_id",
                                "mov_id"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class LogisticOrderMov extends BaseBasicEntity<LogisticOrderMov> {

    @Column(name = "logistic_order_id", nullable = false)
    private Long logisticorderid;

    @Column(name = "mov_id", nullable = false)
    private Long movId;

    @Column(name = "action_status_id", nullable = false)
    @ColumnDefault(ActionStatus.NOT_STARTED_ID + "")
    private Long actionStatusId = ActionStatus.NOT_STARTED_ID;

    @Column(name = "logistic_status_id", nullable = false)
    @ColumnDefault(LogisticStatus.TO_DELIVERY_ID + "")
    private Long logisticStatusId = LogisticStatus.TO_DELIVERY_ID;

    @Column(name = "unmoved_reason_id")
    private Long unmovedReasonId;

    @Column(name = "collected_reason_id")
    private Long collectedReasonId;

    @Column(name = "unmoved_qty_notes")
    private String unmovedQtyNotes;

    @Column(name = "collected_qty_notes")
    private String collectedQtyNotes;

    @Column(name = "mov_started_at")
    private LocalDateTime movStartedAt;

    @Column(name = "mov_ended_at")
    private LocalDateTime movEndedAt;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "logistic_order_id", insertable = false, updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private LogisticOrder logisticOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mov_id", insertable = false, updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Movement mov;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "action_status_id", insertable = false, updatable = false)
    private ActionStatus actionStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "logistic_status_id", insertable = false, updatable = false)
    private LogisticStatus logisticStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "unmoved_reason_id", insertable = false, updatable = false)
    private LogisticReason unmovedReason;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "collected_reason_id", insertable = false, updatable = false)
    private LogisticReason collectedReason;

    protected static final long TABLE_ID = 12004;

    public static long getTableId() {
        return TABLE_ID;
    }
}