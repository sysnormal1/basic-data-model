package com.sysnormal.libs.db.entities.basic_entities.database;

import com.sysnormal.libs.db.entities.basic_entities.BaseBasicEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(
        name = "connections",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "connections_u1",
                        columnNames = {
                                "(coalesce(parent_id, 0))","status_reg_id","data_origin_id","(coalesce(table_origin_id, 0))","(coalesce(id_at_origin, 0))",
                                "name"
                        }
                )
        }
)
public class Connection extends BaseBasicEntity {

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
