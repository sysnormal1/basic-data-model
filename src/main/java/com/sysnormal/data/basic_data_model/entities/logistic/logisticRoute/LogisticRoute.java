package com.sysnormal.data.basic_data_model.entities.logistic.logisticRoute;

import com.sysnormal.data.basic_data_model.entities.BaseBasicEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Entity class
 */
@Getter
@Setter
@Entity
@Table(
        name = "logistic_routes",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "logistic_routes_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "name"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class LogisticRoute extends BaseBasicEntity<LogisticRoute> {

    @Column(name = "name", nullable = false, length = 127)
    private String name;

    protected static final long TABLE_ID = 2020L;
    public static long getTableId() {
        return TABLE_ID;
    }
}
