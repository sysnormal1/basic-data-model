package com.sysnormal.data.basic_data_model.entities.parameters.parameterValue;

import com.sysnormal.data.basic_data_model.entities.BaseBasicEntity;
import com.sysnormal.data.basic_data_model.entities.database.tables.Tables;
import com.sysnormal.data.basic_data_model.entities.parameters.parameter.Parameter;
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
        name = "parameter_values",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "parameter_values_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "parameter_id",
                                "(COALESCE(table_id,0))",
                                "(COALESCE(register_id,0))",
                                "(COALESCE(value,'NULL'))"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class ParameterValue extends BaseBasicEntity<ParameterValue> {

    @Column(name = "parameter_id", nullable = false)
    private Long parameterId;

    @Column(name = "table_id")
    private Long tableId;

    @Column(name = "register_id")
    private Long registerId;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @Column(name = "value", length = 127)
    private String value;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parameter_id", insertable = false, updatable = false)
    private Parameter parameter;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "table_id", insertable = false, updatable = false)
    private Tables table;



}