package com.sysnormal.data.basic_data_model.entities.database.sqlObject;

import com.sysnormal.data.basic_data_model.entities.BaseBasicEntity;
import com.sysnormal.data.basic_data_model.entities.database.sqlObjectType.SqlObjectType;
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
        name = "sql_objects",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "sql_objects_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "sql_object_type_id",
                                "name"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class SqlObject extends BaseBasicEntity<SqlObject> {

    @Column(name = "sql_object_type_id", nullable = false)
    private Long sqlObjectTypeId;

    @Column(name = "name", nullable = false, length = 127)
    private String name;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sql_object_type_id", insertable = false, updatable = false)
    private SqlObjectType sqlObjectType;


}