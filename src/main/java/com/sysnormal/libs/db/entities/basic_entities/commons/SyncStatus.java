package com.sysnormal.libs.db.entities.basic_entities.commons;

import com.sysnormal.libs.db.entities.basic_entities.BaseBasicEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Getter
@Setter
@Table(
        name = "sync_status",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "sync_status_u1",
                        columnNames = {
                                "(coalesce(parent_id, 0))","status_reg_id","data_origin_id","(coalesce(table_origin_id, 0))","(coalesce(id_at_origin, 0))",
                                "name"
                        }
                )
        }
)
public class SyncStatus extends BaseBasicEntity<SyncStatus> {

    @Column(name = "name", nullable = false, length = 127)
    private String name;

    @Column(name = "synchronized", nullable = false)
    @ColumnDefault("1")
    @Check(constraints = "synchronized in (0,1)")
    private byte _synchronized = 1;

    protected static final long TABLE_ID = 66;
    public static long getTableId() {
        return TABLE_ID;
    }



}