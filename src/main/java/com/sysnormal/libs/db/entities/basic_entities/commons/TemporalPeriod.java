package com.sysnormal.libs.db.entities.basic_entities.commons;

import com.sysnormal.libs.db.entities.basic_entities.BaseBasicEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Check;

@Getter
@Setter
@Entity
@Table(
        name = "temporal_periods",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "temporal_periods_u1",
                        columnNames = {
                                "(coalesce(parent_id, 0))","status_reg_id","data_origin_id","(coalesce(table_origin_id, 0))","(coalesce(id_at_origin, 0))",
                                "name"
                        }
                )
        }
)
public class TemporalPeriod extends BaseBasicEntity<TemporalPeriod> {

    @Column(name = "name", nullable = false, length = 127)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "system_temporal_period_name", length = 127)
    @Check(constraints = "system_temporal_period_name in ('milisecond','second', 'minute', 'hour', 'day', 'week', 'month', 'year', 'custom')")
    private String systemTemporalPeriodName;

    protected static final long TABLE_ID = 61;
    public static long getTableId() {
        return TABLE_ID;
    }

    public static final long MILISECOND_ID = 1;
    public static final long SECOND_ID = 2;
    public static final long MINUTE_ID = 3;
    public static final long HOUR_ID = 4;
    public static final long DAY_ID = 5;
    public static final long WEEK_ID = 6;
    public static final long MONTH_ID = 7;
    public static final long YEAR_ID = 8;
    public static final long CUSTOM_ID = 9;

    public static final TemporalPeriod MILISECOND = new TemporalPeriod(){{
        setId(MILISECOND_ID);
        setIsSysRec((byte) 1);
        setName("milisecond");
        setSystemTemporalPeriodName("milisecond");
    }};
    public static final TemporalPeriod SECOND = new TemporalPeriod(){{
        setId(SECOND_ID);
        setIsSysRec((byte) 1);
        setName("second");
        setSystemTemporalPeriodName("second");
    }};
    public static final TemporalPeriod MINUTE = new TemporalPeriod(){{
        setId(MINUTE_ID);
        setIsSysRec((byte) 1);
        setName("minute");
        setSystemTemporalPeriodName("minute");
    }};
    public static final TemporalPeriod HOUR = new TemporalPeriod(){{
        setId(HOUR_ID);
        setIsSysRec((byte) 1);
        setName("hour");
        setSystemTemporalPeriodName("hour");
    }};
    public static final TemporalPeriod DAY = new TemporalPeriod(){{
        setId(DAY_ID);
        setIsSysRec((byte) 1);
        setName("day");
        setSystemTemporalPeriodName("day");
    }};
    public static final TemporalPeriod WEEK = new TemporalPeriod(){{
        setId(WEEK_ID);
        setIsSysRec((byte) 1);
        setName("week");
        setSystemTemporalPeriodName("week");
    }};
    public static final TemporalPeriod MONTH = new TemporalPeriod(){{
        setId(MONTH_ID);
        setIsSysRec((byte) 1);
        setName("month");
        setSystemTemporalPeriodName("month");
    }};
    public static final TemporalPeriod YEAR = new TemporalPeriod(){{
        setId(YEAR_ID);
        setIsSysRec((byte) 1);
        setName("year");
        setSystemTemporalPeriodName("year");
    }};
    public static final TemporalPeriod CUSTOM = new TemporalPeriod(){{
        setId(CUSTOM_ID);
        setIsSysRec((byte) 1);
        setName("custom");
        setSystemTemporalPeriodName("custom");
    }};
}
