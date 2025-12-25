package com.sysnormal.libs.db.entities.basic_entities.commons;

import com.sysnormal.libs.db.entities.basic_entities.BaseBasicEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Getter
@Setter
@Table(
        name = "record_status",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "record_status_u1",
                        columnNames = {
                                "(coalesce(parent_id, 0))","status_reg_id","data_origin_id","(coalesce(table_origin_id, 0))","(coalesce(id_at_origin, 0))",
                                "name"
                        }
                )
        }
)
public class RecordStatus extends BaseBasicEntity {

    @Column(name = "name", nullable = false, length = 127)
    private String name;

    @Column(name = "description", length = 1000)
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