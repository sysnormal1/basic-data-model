package com.sysnormal.libs.db.entities.basic_entities.tasks.tasksStatusAgentsLog;

import com.sysnormal.libs.db.entities.basic_entities.BaseBasicEntity;
import com.sysnormal.libs.db.entities.basic_entities.tasks.taskStatus.TaskStatus;
import com.sysnormal.libs.db.entities.basic_entities.tasks.taskStatusAgents.TaskStatusAgents;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Table(
        name = "tasks_status_agents_logs"
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class TasksStatusAgentsLog extends BaseBasicEntity<TasksStatusAgentsLog> {

    @Column(name = "task_status_agent_id", nullable = false)
    private Long taskStatusAgentId;

    @Column(name = "operation", nullable = false, length = 50)
    private String operation;

    @Column(name = "old_status_id")
    private Long oldStatusId;

    @Column(name = "new_status_id")
    private Long newStatusId;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_status_agent_id", updatable = false, insertable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private TaskStatusAgents taskStatusAgent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "old_status_id", updatable = false, insertable = false)
    private TaskStatus oldStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "new_status_id", updatable = false, insertable = false)
    private TaskStatus newStatus;

    protected static final long TABLE_ID = 15151;
    public static long getTableId() {
        return TABLE_ID;
    }
}
