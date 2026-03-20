package com.sysnormal.data.basic_data_model.entities.tasks.task;

import com.sysnormal.data.basic_data_model.entities.BaseBasicEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Entity class
 */
@Getter
@Setter
@Entity
@Table(
        name = "tasks"
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Task extends BaseBasicEntity<Task> {

    @Column(name = "name", nullable = false, length = 127)
    private String name;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @Column(name = "forecast_start_moment")
    private LocalDateTime forecastStartMoment;

    @Column(name = "forecast_end_moment")
    private LocalDateTime forecastEndMoment;

    @Column(name = "start_at")
    private LocalDateTime startAt;

    @Column(name = "end_at")
    private LocalDateTime endAt;

    @Column(name = "notes", length = Integer.MAX_VALUE)
    private String notes;

    protected static final long TABLE_ID = 15101;
    public static long getTableId() {
        return TABLE_ID;
    }

}
