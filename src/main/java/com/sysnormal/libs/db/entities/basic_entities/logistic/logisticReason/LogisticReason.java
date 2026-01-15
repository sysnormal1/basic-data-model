package com.sysnormal.libs.db.entities.basic_entities.logistic.logisticReason;

import com.sysnormal.libs.db.entities.basic_entities.BaseBasicEntity;
import jakarta.persistence.*;
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
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "name", "(coalesce(mov_type_sigla,' '))"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
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