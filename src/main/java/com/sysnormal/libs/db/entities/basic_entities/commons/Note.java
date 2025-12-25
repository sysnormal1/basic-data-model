package com.sysnormal.libs.db.entities.basic_entities.commons;

import com.sysnormal.libs.db.entities.basic_entities.BaseBasicEntity;
import com.sysnormal.libs.db.entities.basic_entities.database.Tables;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(
        name = "notes",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "notes_u1",
                        columnNames = {
                                "(coalesce(parent_id, 0))","status_reg_id","data_origin_id","(coalesce(table_origin_id, 0))","(coalesce(id_at_origin, 0))",
                                "table_id",
                                "record_id",
                                "notes_type",
                                "(coalesce(reference_start_at,'1000-01-01'))",
                                "(coalesce(reference_end_at,'1000-01-01'))"
                        }
                )
        }
)
public class Note extends BaseBasicEntity {

    @Column(name = "table_id", nullable = false)
    private Long tableId;

    @Column(name = "record_id", nullable = false)
    private Long recordId;

    @Column(name = "notes_type", nullable = false, length = 127)
    private String notesType = "notes";

    @Column(name = "notes", nullable = false, length = 2000)
    private String notes;

    @Column(name = "reference_start_at")
    private LocalDateTime referenceStartAt;

    @Column(name = "reference_end_at")
    private LocalDateTime referenceEndAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "table_id", insertable = false, updatable = false)
    private Tables table;

    protected static final long TABLE_ID = 256;
    public static long getTableId() {
        return TABLE_ID;
    }


}