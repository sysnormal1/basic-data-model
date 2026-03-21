package com.sysnormal.data.basic_data_model.entities.commons.text;

import com.sysnormal.data.basic_data_model.entities.BaseBasicEntity;
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
        name = "texts",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "texts_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "language_id",
                                "text"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Text extends BaseBasicEntity<Text> {

    @Column(name = "language_id", nullable = false)
    private Long languageId;

    @Column(name = "text", nullable = false, length = 512)
    private String text;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "language_id", insertable = false, updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Language language;

}
