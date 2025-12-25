package com.sysnormal.libs.db.entities.basic_entities.database;

import com.sysnormal.libs.db.entities.basic_entities.BaseBasicEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(
        name = "tables",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "tables_u1",
                        columnNames = {
                                "(coalesce(parent_id, 0))","status_reg_id","data_origin_id","(coalesce(table_origin_id, 0))","(coalesce(id_at_origin, 0))",
                                "data_connection_id",
                                "schema_id",
                                "name"
                        }
                )
        }
)
public class Tables extends BaseBasicEntity {

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

    protected static final long TABLE_ID = 10;
    public static long getTableId() {
        return TABLE_ID;
    }
}
