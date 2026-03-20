package com.sysnormal.data.basic_data_model.entities.commons.entityType;

import com.sysnormal.data.basic_data_model.entities.BaseBasicEntity;
import com.sysnormal.data.basic_data_model.entities.database.tables.Tables;
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
        name = "entities_types",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "entities_types_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "name"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class EntityType extends BaseBasicEntity<EntityType> {

    @Column(name = "name", nullable = false, length = 127)
    private String name;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @Column(name = "table_id")
    private Long tableId;

    @Column(name = "identifier_column", nullable = false, length = 127)
    private String identifierColumn;

    @Column(name = "name_column", nullable = false, length = 127)
    private String nameColumn;

    @Column(name = "columns", length = Integer.MAX_VALUE)
    private String columns;

    @Column(name = "where_clause", length = Integer.MAX_VALUE)
    private String whereClause;

    @Column(name = "order_by", length = 127)
    private String orderBy;

    @Column(name = "query", length = Integer.MAX_VALUE)
    private String query;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "table_id", updatable = false, insertable = false)
    private Tables tables;

    protected static final long TABLE_ID = 30;
    public static long getTableId() {
        return TABLE_ID;
    }


    public static final long DATABASE_ID = 1L;
    public static final long CONNECTION_ID = 2L;
    public static final long USER_ID = 3L;
    public static final long SCHEMA_ID = 4L;
    public static final long TABLE_ENTITY_ID = 5L;
    public static final long QUERY_ID = 10L;

    public static final EntityType DATABASE = new EntityType(){{
        setId(DATABASE_ID);
        setIsSysRec((byte) 1);
        setName("DATABASE");
    }};
    public static final EntityType CONNECTION = new EntityType(){{
        setId(CONNECTION_ID);
        setIsSysRec((byte) 1);
        setName("CONNECTION");
    }};
    public static final EntityType USER = new EntityType(){{
        setId(USER_ID);
        setIsSysRec((byte) 1);
        setName("USER");
    }};
    public static final EntityType SCHEMA = new EntityType(){{
        setId(SCHEMA_ID);
        setIsSysRec((byte) 1);
        setName("SCHEMA");
    }};
    public static final EntityType TABLE = new EntityType(){{
        setId(TABLE_ENTITY_ID);
        setIsSysRec((byte) 1);
        setName("TABLE");
    }};
    public static final EntityType QUERY = new EntityType(){{
        setId(QUERY_ID);
        setIsSysRec((byte) 1);
        setName("QUERY");
    }};
}
