package com.sysnormal.libs.db.entities.basic_entities.commons;

import com.sysnormal.libs.db.entities.basic_entities.BaseBasicEntity;
import com.sysnormal.libs.db.entities.basic_entities.database.Tables;
import jakarta.persistence.*;
import jakarta.persistence.Parameter;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(
        name = "parameter_values",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "parameter_values_u1",
                        columnNames = {
                                "(coalesce(parent_id, 0))","status_reg_id","data_origin_id","(coalesce(table_origin_id, 0))","(coalesce(id_at_origin, 0))",
                                "parameter_id",
                                "(COALESCE(table_id,0))",
                                "(COALESCE(register_id,0))",
                                "(COALESCE(value,'NULL'))"
                        }
                )
        }
)
public class ParameterValue extends BaseBasicEntity {

    @Column(name = "parameter_id", nullable = false)
    private Long parameterId;

    @Column(name = "table_id")
    private Long tableId;

    @Column(name = "register_id")
    private Long registerId;

    @Column(name = "description")
    private String description;

    @Column(name = "value", length = 127)
    private String value;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parameter_id", insertable = false, updatable = false)
    private Parameter parameter;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "table_id", insertable = false, updatable = false)
    private Tables table;

    protected static final long TABLE_ID = 56;
    public static long getTableId() {
        return TABLE_ID;
    }



}