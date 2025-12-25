package com.sysnormal.libs.db.entities.basic_entities.commons;

import com.sysnormal.libs.db.entities.basic_entities.BaseBasicEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Getter
@Setter
@Table(
        name = "action_status",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "action_status_u1",
                        columnNames = {
                                "(coalesce(parent_id, 0))","status_reg_id","data_origin_id","(coalesce(table_origin_id, 0))","(coalesce(id_at_origin, 0))",
                                "name"
                        }
                )
        }
)
public class ActionStatus extends BaseBasicEntity {

    @Column(name = "name", nullable = false, length = 127)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "is_started", nullable = false)
    @ColumnDefault("0")
    @Check(constraints = "is_started in (0,1)")
    private byte isStarted = 0;

    @ColumnDefault("0")
    @Check(constraints = "is_running in (0,1)")
    @Column(name = "is_running", nullable = false)
    private byte isRunning = 0;

    @ColumnDefault("0")
    @Check(constraints = "is_stopped in (0,1)")
    @Column(name = "is_stopped", nullable = false)
    private byte isStoped = 0;

    @ColumnDefault("0")
    @Check(constraints = "is_canceled in (0,1)")
    @Column(name = "is_canceled", nullable = false)
    private byte isCanceled = 0;

    @ColumnDefault("0")
    @Check(constraints = "is_concluded in (0,1)")
    @Column(name = "is_concluded", nullable = false)
    private byte isConcluded = 0;

    protected static final long TABLE_ID = 51L;
    public static long getTableId() {
        return TABLE_ID;
    }

    // Constantes equivalentes
    public static final long NOT_STARTED_ID = 1L;
    public static final long RUNNING_ID = 2L;
    public static final long STOPPED_ID = 3L;
    public static final long CANCELED_ID = 4L;
    public static final long CONCLUDED_ID = 5L;

    public static final ActionStatus NOT_STARTED = new ActionStatus(){{
        setId(NOT_STARTED_ID);
        setIsSysRec((byte) 1);
        setName("NOT STARTED");
    }};
    public static final ActionStatus RUNNING = new ActionStatus(){{
        setId(RUNNING_ID);
        setIsSysRec((byte) 1);
        setName("RUNNING");
        setIsStarted((byte) 1);
        setIsRunning((byte) 1);
    }};
    public static final ActionStatus STOPPED = new ActionStatus(){{
        setId(STOPPED_ID);
        setIsSysRec((byte) 1);
        setName("STOPPED");
        setIsStarted((byte) 1);
        setIsStoped((byte) 1);
    }};
    public static final ActionStatus CANCELED = new ActionStatus(){{
        setId(CANCELED_ID);
        setIsSysRec((byte) 1);
        setName("CANCELED");
        setIsCanceled((byte) 1);
    }};
    public static final ActionStatus CONCLUDED = new ActionStatus(){{
        setId(CONCLUDED_ID);
        setIsSysRec((byte) 1);
        setName("CONCLUDED");
        setIsConcluded((byte) 1);
    }};
}