package com.sysnormal.data.basic_data_model.entities.storage.measXMeasOrigin;

import com.sysnormal.data.basic_data_model.entities.BaseBasicEntity;
import com.sysnormal.data.basic_data_model.entities.measures.measurementUnit.MeasurementUnit;
import com.sysnormal.data.basic_data_model.entities.people.suppliers.supplier.Supplier;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Entity class
 */
@Entity
@Getter
@Setter
@Table(
        name = "meas_x_meas_origins",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "meas_x_meas_origins_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "(coalesce(supplier_id,0))", "origin_measurement_unit"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class MeasXMeasOrigin extends BaseBasicEntity<MeasXMeasOrigin> {

    @Column(name = "supplier_id")
    private Long supplierId;

    @Column(name = "origin_measurement_unit", nullable = false, length = 127)
    private String originMeasurementUnit;

    @Column(name = "measurement_unit_id", nullable = false)
    private Long measurementUnitId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id", insertable = false, updatable = false)
    private Supplier supplier;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "measurement_unit_id", insertable = false, updatable = false)
    private MeasurementUnit measurementUnit;

}