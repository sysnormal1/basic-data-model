package com.sysnormal.data.basic_data_model.entities.records.recordStatus;

import com.sysnormal.data.basic_data_model.entities.BaseBasicEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

/**
 * Entity class
 */
@Entity
@Getter
@Setter
@Table(
        name = "record_status",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "record_status_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "name"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class RecordStatus extends BaseBasicEntity<RecordStatus> {

    @Column(name = "name", nullable = false, length = 127)
    private String name;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @Column(name = "is_active", nullable = false)
    @ColumnDefault("1")
    private byte isActive = 1;


    protected static final long TABLE_ID = 65L;

    public static long getTableId() {
        return TABLE_ID;
    }

    // Constantes equivalentes
    public static final long ACTIVE_ID = 1;
    public static final long INACTIVE_ID = 2;

    public static final RecordStatus ACTIVE = new RecordStatus(){{
        setId(ACTIVE_ID);
        setIsSysRec((byte) 1);
        setName("ACTIVE");
        setIsActive((byte) 1);
    }};
    public static final RecordStatus INACTIVE = new RecordStatus(){{
        setId(INACTIVE_ID);
        setIsSysRec((byte) 1);
        setName("INACTIVE");
        setIsActive((byte) 0);
    }};
}