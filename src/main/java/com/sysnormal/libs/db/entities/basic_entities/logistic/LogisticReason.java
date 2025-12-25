package com.sysnormal.libs.db.entities.basic_entities.logistic;

import com.sysnormal.libs.db.entities.basic_entities.BaseBasicEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(
        name = "logistic_reasons",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "logistic_reasons_u1",
                        columnNames = {
                                "(coalesce(parent_id, 0))","status_reg_id","data_origin_id","(coalesce(table_origin_id, 0))","(coalesce(id_at_origin, 0))",
                                "name", "(coalesce(mov_type_sigla,' '))"
                        }
                )
        }
)
public class LogisticReason extends BaseBasicEntity<LogisticReason> {

    @Column(name = "name", nullable = false, length = 127)
    private String name;

    @Column(name = "mov_type_sigla", length = 2)
    private String movTypeSigla;

    protected static final long TABLE_ID = 9002L;
    public static long getTableId() {
        return TABLE_ID;
    }

}