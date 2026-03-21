package com.sysnormal.data.basic_data_model.entities.storage.warehouseAddressDimension;

import com.sysnormal.data.basic_data_model.entities.BaseBasicEntity;
import com.sysnormal.data.basic_data_model.entities.commons.identifierType.IdentifierType;
import com.sysnormal.data.basic_data_model.entities.measures.measurementUnit.MeasurementUnit;
import com.sysnormal.data.basic_data_model.entities.storage.warehouseAddress.WarehouseAddress;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;

/**
 * Entity class
 */
@Entity
@Getter
@Setter
@Table(
        name = "warehouse_address_dimensions",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "warehouse_address_dimensions_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "warehouse_address_id",
                                "dimension_type_id"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class WarehouseAddressDimension extends BaseBasicEntity<WarehouseAddressDimension> {

    @Column(name = "warehouse_address_id", nullable = false)
    private Long warehouseAddressId;

    @Column(name = "dimension_type_id", nullable = false)
    private Long dimensionTypeId;

    @Column(name = "measurement_unit_id", nullable = false)
    private Long measurementUnitId;

    @Column(name = "value", nullable = false, precision = 38,scale = 10)
    @ColumnDefault("0")
    private BigDecimal value = BigDecimal.ZERO;

    @Column(name = "notes", length = Integer.MAX_VALUE)
    private String notes;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "warehouse_address_id", insertable = false, updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private WarehouseAddress warehouseAddress;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dimension_type_id", insertable = false, updatable = false)
    private IdentifierType dimensionType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "measurement_unit_id", insertable = false, updatable = false)
    private MeasurementUnit measurementUnit;


}