package com.sysnormal.data.basic_data_model.entities.logistic.logisticSquare;

import com.sysnormal.data.basic_data_model.entities.BaseBasicEntity;
import com.sysnormal.data.basic_data_model.entities.logistic.logisticRoute.LogisticRoute;
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
        name = "logistic_squares",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "logistic_squares_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "logistic_route_id", "name"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class LogisticSquare extends BaseBasicEntity<LogisticSquare> {

    @Column(name = "logistic_route_id", nullable = false)
    private Long logisticRouteId;

    @Column(name = "name", nullable = false, length = 127)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "logistic_route_id", updatable = false, insertable = false)
    private LogisticRoute logisticRoute;
}
