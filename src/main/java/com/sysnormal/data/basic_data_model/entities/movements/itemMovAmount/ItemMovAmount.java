package com.sysnormal.data.basic_data_model.entities.movements.itemMovAmount;

import com.sysnormal.data.basic_data_model.entities.BaseBasicEntity;
import com.sysnormal.data.basic_data_model.entities.commons.actionStatus.ActionStatus;
import com.sysnormal.data.basic_data_model.entities.measures.measurementUnit.MeasurementUnit;
import com.sysnormal.data.basic_data_model.entities.measures.packaging.Packaging;
import com.sysnormal.data.basic_data_model.entities.movements.movItemStock.MovItemStock;
import com.sysnormal.data.basic_data_model.entities.movements.movementType.MovementType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Entity class
 */
@Entity
@Getter
@Setter
@Table(
        name = "item_mov_amounts",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "item_mov_amounts_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "mov_item_stock_id",
                                "type_mov_id",
                                "measurement_unit_id",
                                "packaging_id"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class ItemMovAmount extends BaseBasicEntity<ItemMovAmount> {

    @Column(name = "mov_item_stock_id", nullable = false)
    private Long movItemStockId;

    @Column(name = "type_mov_id", nullable = false)
    private Long typeMovId;

    @Column(name = "measurement_unit_id", nullable = false)
    private Long measurementUnitId;

    @Column(name = "packaging_id", nullable = false)
    private Long packagingId;

    @Column(name = "unit_weight", precision = 38, scale = 10)
    private BigDecimal unitWeight;

    @Column(name = "package_weight", precision = 38, scale = 10)
    private BigDecimal packageWeight;

    @Column(name = "unit_volume", precision = 38, scale = 10)
    private BigDecimal unitVolume;

    @Column(name = "package_volume", precision = 38, scale = 10)
    private BigDecimal packageVolume;

    @Column(name = "unit_value", precision = 38, scale = 10)
    private BigDecimal unitValue;

    @Column(name = "status_mov_id", nullable = false)
    @ColumnDefault(ActionStatus.NOT_STARTED_ID + "")
    private Long statusMovId = ActionStatus.NOT_STARTED_ID;

    @Column(name = "mov_started_at")
    private LocalDateTime movStartedAt;

    @Column(name = "mov_ended_at")
    private LocalDateTime movEndedAt;

    @Column(name = "expected_amt", nullable = false, precision = 38, scale = 10)
    @ColumnDefault("0")
    private BigDecimal expectedAmt = BigDecimal.ZERO;

    @Column(name = "moved_amt", nullable = false, precision = 38, scale = 10)
    @ColumnDefault("0")
    private BigDecimal movedAmt = BigDecimal.ZERO;

    @Column(name = "notes", length = Integer.MAX_VALUE)
    private String notes;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mov_item_stock_id", insertable = false, updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private MovItemStock movItemStock;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_mov_id", insertable = false, updatable = false)
    private MovementType typeMov;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "measurement_unit_id", insertable = false, updatable = false)
    private MeasurementUnit measurementUnit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "packaging_id", insertable = false, updatable = false)
    private Packaging packaging;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_mov_id", insertable = false, updatable = false)
    private ActionStatus statusMov;
}