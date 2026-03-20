package com.sysnormal.data.basic_data_model.entities.database.connection;

import com.sysnormal.data.basic_data_model.entities.BaseBasicEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.ColumnDefault;

/**
 * Entity class
 */
@Getter
@Setter
@Entity
@Table(
        name = "connections",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "connections_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "name"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Connection extends BaseBasicEntity<Connection> {

    @Column(name = "name", nullable = false, length = 127)
    private String name;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @Column(name = "default_env_identifier", length = Integer.MAX_VALUE)
    private String defaultEnvIdentifier;

    @Column(name = "is_default", nullable = false, length = 1)
    @ColumnDefault("0")
    @Check(constraints = "is_default in (0,1)")
    private byte isDefault = 0;

    protected static final long TABLE_ID = 11;
    public static long getTableId() {
        return TABLE_ID;
    }




}
