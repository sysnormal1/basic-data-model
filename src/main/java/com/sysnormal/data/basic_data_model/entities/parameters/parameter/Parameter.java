package com.sysnormal.data.basic_data_model.entities.parameters.parameter;

import com.sysnormal.data.basic_data_model.entities.BaseBasicEntity;
import com.sysnormal.data.basic_data_model.entities.records.dataType.DataType;
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
        name = "parameters",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "parameters_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "name"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Parameter extends BaseBasicEntity<Parameter> {

    @Column(name = "data_type_id", nullable = false)
    private Long dataTypeId;

    @Column(name = "name", length = 127, nullable = false)
    private String name;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @Column(name = "default_value", length = 127)
    private String defaultValue;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "data_type_id", insertable = false, updatable = false)
    private DataType dataType;

    protected static final long TABLE_ID = 55;
    public static long getTableId() {
        return TABLE_ID;
    }


    public static final long HAS_WINTHOR_INTEGRATION_ID = 1;
    public static final long HAS_EP_INTEGRATION_ID = 40000;
    public static final long LOGISTIC_INTEGRATE_AUTOMATIC_CLOSE_BOX_DRIVER_ID = 2;
    public static final long WMS_OUTPUT_INTEGRATION_CHECK_RCA_ID = 3;
    public static final long APPS_DELIVERY_MUST_CAPTURE_SIGNATURE_ID	= 4;
    public static final long APPS_DELIVERY_MUST_CAPTURE_SIGNATURE_BY_INVOICE_ID	= 5;
    public static final long APPS_DELIVERY_ONLY_ONE_DELIVERY_RUNNING_ID = 6;
    public static final long WINTHOR_INTEGRATION_NCM_CONSIDER_EXCEPTION_NULL_IF_NOT_EXISTS_ID = 10;
    public static final long LOOP_RECURSION_LIMIT_ID = 1000;
    public static final long LOOP_RECURSION_INTERVAL_ID = 1001;
    public static final long COMMISSION_MIN_VAL_ID = 9050;
    public static final long WINTHOR_CUSTOMIZED_GIRO_STOCK_DAYS_ID = 30101;


}