package com.sysnormal.data.basic_data_model.entities.movements.movItemStock;

import com.sysnormal.data.basic_data_model.entities.BaseBasicEntity;
import com.sysnormal.data.basic_data_model.entities.commons.actionStatus.ActionStatus;
import com.sysnormal.data.basic_data_model.entities.movements.movement.Movement;
import com.sysnormal.data.basic_data_model.entities.movements.movementType.MovementType;
import com.sysnormal.data.basic_data_model.entities.storage.itemStock.ItemStock;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;

/**
 * Entity class
 */
@Entity
@Getter
@Setter
@Table(
        name = "movs_items_stocks",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "movs_items_stocks_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "mov_id",
                                "type_mov_id",
                                "stock_item_id"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class MovItemStock extends BaseBasicEntity<MovItemStock> {

    @Column(name = "mov_id", nullable = false)
    private Long movId;

    @Column(name = "type_mov_id", nullable = false)
    private Long typeMovId;

    @Column(name = "stock_item_id", nullable = false)
    private Long stockItemId;

    @Column(name = "status_mov_id", nullable = false)
    @ColumnDefault(ActionStatus.NOT_STARTED_ID + "")
    private Long statusMovId = ActionStatus.NOT_STARTED_ID;

    @Column(name = "mov_started_at")
    private LocalDateTime movStartedAt;

    @Column(name = "mov_ended_at")
    private LocalDateTime movEndedAt;

    @Column(name = "numeric_order", nullable = false)
    @ColumnDefault("0")
    private Long numericOrder = 0L;

    @Column(name = "precedence", nullable = false)
    @ColumnDefault("0")
    private Long precedence = 0L;

    @Column(name = "notes", length = Integer.MAX_VALUE)
    private String notes;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mov_id", insertable = false, updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Movement mov;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_mov_id", insertable = false, updatable = false)
    private MovementType typeMov;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stock_item_id", insertable = false, updatable = false)
    private ItemStock stockItem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_mov_id", insertable = false, updatable = false)
    private ActionStatus statusMov;
}