package com.sysnormal.data.basic_data_model.entities.projectManagement.projectTask;

import com.sysnormal.data.basic_data_model.entities.BaseBasicEntity;
import com.sysnormal.data.basic_data_model.entities.projectManagement.projectItem.ProjectItem;
import com.sysnormal.data.basic_data_model.entities.projectManagement.projectTaskType.ProjectTaskType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;

/**
 * Entity class
 */
@Getter
@Setter
@Entity
@Table(
        name = "project_tasks",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "project_tasks_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "project_item_id"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class ProjectTask extends BaseBasicEntity<ProjectTask> {

    @Column(name = "project_item_id", nullable = false)
    private Long projectItemId;

    @Column(name = "task_type_id",nullable = false)
    @ColumnDefault(ProjectTaskType.TASK_ID + "")
    private Long taskTypeId = ProjectTaskType.TASK_ID;

    @Column(name = "forecast_start_moment")
    private LocalDateTime forecastStartMoment;

    @Column(name = "forecast_end_moment")
    private LocalDateTime forecastEndMoment;

    @Column(name = "start_at")
    private LocalDateTime startAt;

    @Column(name = "end_at")
    private LocalDateTime endAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_item_id", insertable = false, updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ProjectItem projectIitem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_type_id", insertable = false, updatable = false)
    private ProjectTaskType taskType;

}
