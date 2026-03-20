package com.sysnormal.data.basic_data_model.entities.projectManagement.projectItemOriginType;

import com.sysnormal.data.basic_data_model.entities.BaseBasicEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.ColumnDefault;

/**
 * Entity class
 */
@Entity
@Getter
@Setter
@Table(
        name = "project_item_origin_types",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "project_item_origin_types_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "name"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class ProjectItemOriginType extends BaseBasicEntity<ProjectItemOriginType> {

    @Column(name = "name", nullable = false, length = 127)
    private String name;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @Column(name = "is_system", nullable = false)
    @ColumnDefault("0")
    @Check(constraints = "is_system in (0,1)")
    private byte isSystem = 0;

    @Column(name = "notes", length = Integer.MAX_VALUE)
    private String notes;

    protected static final long TABLE_ID = 15005;
    public static long getTableId() {
        return TABLE_ID;
    }

    public static final long SYSTEM_ID = 0;
    public static final long AGENT_ID = 1;

    public static final ProjectItemOriginType SYSTEM = new ProjectItemOriginType(){{
        setId(SYSTEM_ID);
        setIsSysRec((byte) 1);
        setName("SYSTEM");
        setIsSystem((byte) 1);
    }};

    public static final ProjectItemOriginType AGENT = new ProjectItemOriginType(){{
        setId(AGENT_ID);
        setIsSysRec((byte) 1);
        setName("AGENT");
        setIsSystem((byte) 0);
    }};



}