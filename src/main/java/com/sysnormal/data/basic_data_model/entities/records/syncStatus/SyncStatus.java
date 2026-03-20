package com.sysnormal.data.basic_data_model.entities.records.syncStatus;

import com.sysnormal.data.basic_data_model.entities.BaseBasicEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.ColumnDefault;

/**
 * Entity class
 */
@Entity
@Getter
@Setter
@Table(
        name = "sync_status",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "sync_status_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "name"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
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