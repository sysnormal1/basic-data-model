package com.sysnormal.data.basic_data_model.entities.languages.translate;

import com.sysnormal.data.basic_data_model.entities.BaseBasicEntity;
import com.sysnormal.data.basic_data_model.entities.commons.text.Text;
import com.sysnormal.data.basic_data_model.entities.languages.language.Language;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 * Entity class
 */
@Getter
@Setter
@Entity
@Table(
        name = "translates",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "translates_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "language_id",
                                "text_id"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Translate extends BaseBasicEntity<Translate> {

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
