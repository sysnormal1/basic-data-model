package com.sysnormal.data.basic_data_model.entities.database.tables;

import com.sysnormal.data.basic_data_model.entities.BaseBasicEntity;
import com.sysnormal.data.basic_data_model.entities.database.connection.Connection;
import com.sysnormal.data.basic_data_model.entities.database.schema.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Entity class
 */
@Getter
@Setter
@Entity
@Table(
        name = "tables",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "tables_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "data_connection_id",
                                "schema_id",
                                "name"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Tables extends BaseBasicEntity<Tables> {

    @Column(name = "data_connection_id", nullable = false)
    private Long dataConnectionId;

    @Column(name = "schema_id", nullable = false)
    private Long schemaId;

    @Column(name = "name", nullable = false, length = 127)
    private String name;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "data_connection_id", updatable = false, insertable = false)
    private Connection connection;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schema_id", updatable = false, insertable = false)
    private Schema schema;
}
