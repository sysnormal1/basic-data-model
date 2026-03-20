package com.sysnormal.data.basic_data_model.entities.measures.formType;

import com.sysnormal.data.basic_data_model.entities.BaseBasicEntity;
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
        name = "form_types",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "form_types_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "name"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class FormType extends BaseBasicEntity<FormType> {

    @Column(name = "name", nullable = false, length = 127)
    private String name;

    @Column(name = "path", length = Integer.MAX_VALUE)
    private String path;

    protected static final long TABLE_ID = 1031;
    public static long getTableId() {
        return TABLE_ID;
    }
}