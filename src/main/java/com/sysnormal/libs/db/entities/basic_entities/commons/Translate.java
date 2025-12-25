package com.sysnormal.libs.db.entities.basic_entities.commons;

import com.sysnormal.libs.db.entities.basic_entities.BaseBasicEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Table(
        name = "translates",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "translates_u1",
                        columnNames = {
                                "(coalesce(parent_id, 0))","status_reg_id","data_origin_id","(coalesce(table_origin_id, 0))","(coalesce(id_at_origin, 0))",
                                "language_id",
                                "text_id"
                        }
                )
        }
)
public class Translate extends BaseBasicEntity {

    @Column(name = "language_id", nullable = false)
    private Long languageId;

    @Column(name = "text_id", nullable = false)
    private Long textId;

    @Column(name = "translated", nullable = false, length = 2000)
    private String translated;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "language_id", insertable = false, updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Language language;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "text_id", insertable = false, updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Text text;

    protected static final long TABLE_ID = 250;
    public static long getTableId() {
        return TABLE_ID;
    }

}
