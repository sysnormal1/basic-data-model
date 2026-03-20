package com.sysnormal.data.basic_data_model.entities.reports.reportDataFount;

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
        name = "report_data_founts",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "report_data_founts_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "name"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class ReportDataFount extends BaseBasicEntity<ReportDataFount> {

    @Column(name = "name", nullable = false, length = 127)
    private String name;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @Column(name = "start_at")
    private LocalDateTime startAt;

    @Column(name = "end_at")
    private LocalDateTime endAt;

    @Column(name = "conditions", length = Integer.MAX_VALUE)
    private String conditions;

    @Column(name = "type_get_expected_data_from", length = 127)
    private String typeGetExpectedDataFrom;

    @Column(name = "origin_get_expected_data_from", length = 127)
    private String originGetExpectedDataFrom;

    @Column(name = "get_expected_data_from", length = Integer.MAX_VALUE)
    private String getExpectedDataFrom;

    @Column(name = "type_get_value_from", length = 127)
    private String typeGetValueFrom;

    @Column(name = "origin_get_value_from", length = 127)
    private String originGetValueFrom;

    @Column(name = "get_value_from", length = Integer.MAX_VALUE)
    private String getValueFrom;

    protected static final long TABLE_ID = 10006;
    public static long getTableId() {
        return TABLE_ID;
    }

}
