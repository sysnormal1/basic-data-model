package com.sysnormal.data.basic_data_model.entities.storage.containerTypeDimesion;

import com.sysnormal.data.basic_data_model.entities.BaseBasicEntity;
import com.sysnormal.data.basic_data_model.entities.commons.identifierType.IdentifierType;
import com.sysnormal.data.basic_data_model.entities.measures.measurementUnit.MeasurementUnit;
import com.sysnormal.data.basic_data_model.entities.storage.containerType.ContainerType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;

/**
 * Entity class
 */
@Getter
@Setter
@Entity
@Table(
        name = "container_type_dimensions",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "container_type_dimensions_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "container_type_id", "dimension_type_id"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class ContainerTypeDimesion extends BaseBasicEntity<ContainerTypeDimesion> {

    @Column(name = "container_type_id", nullable = false)
    private Long containerTypeId;

    @Column(name = "dimension_type_id", nullable = false)
    private Long dimensionTypeId;

    @Column(name = "measurement_unit_id", nullable = false)
    private Long measurementUnitId;

    @Column(name = "value", precision = 38, scale = 10, nullable = false)
    @ColumnDefault("0")
    private BigDecimal value = BigDecimal.ZERO;

    @Column(name = "notes", length = Integer.MAX_VALUE)
    private String notes;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "container_type_id", updatable = false, insertable = false)
    private ContainerType containerType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dimension_type_id", updatable = false, insertable = false)
    private IdentifierType dimensionType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "measurement_unit_id", updatable = false, insertable = false)
    private MeasurementUnit measurementUnit;

    protected static final long TABLE_ID = 8003;
    public static long getTableId() {
        return TABLE_ID;
    }
}
