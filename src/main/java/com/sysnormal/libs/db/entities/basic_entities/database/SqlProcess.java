package com.sysnormal.libs.db.entities.basic_entities.database;

import com.sysnormal.libs.db.entities.basic_entities.BaseBasicEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(
        name = "sql_processes",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "sql_processes_u1",
                        columnNames = {
                                "(coalesce(parent_id, 0))","status_reg_id","data_origin_id","(coalesce(table_origin_id, 0))","(coalesce(id_at_origin, 0))",
                                "sql_object_type_id",
                                "name"
                        }
                )
        }
)
public class SqlProcess extends BaseBasicEntity {

    @Column(name = "sql_object_type_id", nullable = false)
    private Long sqlObjectTypeId;

    @Column(name = "name", nullable = false, length = 127)
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sql_object_type_id", insertable = false, updatable = false)
    private SqlObjectType sqlObjectType;

    protected static final long TABLE_ID = 10001;
    public static long getTableId() {
        return TABLE_ID;
    }


    public static final long REPORT_SALES_COST_AND_PROFIT_ID = 1;

    public static final SqlProcess REPORT_SALES_COST_AND_PROFIT = new SqlProcess(){{
        setId(REPORT_SALES_COST_AND_PROFIT_ID);
        setIsSysRec((byte) 1);
        setSqlObjectTypeId(SqlObjectType.SELECT_ID);
        setName("REPORT SALES COST AND PROFIT");
    }};

}