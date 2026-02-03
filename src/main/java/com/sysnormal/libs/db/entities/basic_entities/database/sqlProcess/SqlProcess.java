package com.sysnormal.libs.db.entities.basic_entities.database.sqlProcess;

import com.sysnormal.libs.db.entities.basic_entities.BaseBasicEntity;
import com.sysnormal.libs.db.entities.basic_entities.database.sqlObjectType.SqlObjectType;
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
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "sql_object_type_id",
                                "name"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class SqlProcess extends BaseBasicEntity<SqlProcess> {

    @Column(name = "sql_object_type_id", nullable = false)
    private Long sqlObjectTypeId;

    @Column(name = "name", nullable = false, length = 127)
    private String name;

    @Column(name = "description", length = Integer.MAX_VALUE)
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