package com.sysnormal.data.basic_data_model.entities.projectManagement.projectItem;

import com.sysnormal.data.basic_data_model.entities.BaseBasicEntity;
import com.sysnormal.data.basic_data_model.entities.projectManagement.projectItemOriginType.ProjectItemOriginType;
import com.sysnormal.data.basic_data_model.entities.projectManagement.projectItemType.ProjectItemType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

/**
 * Entity class
 */
@Getter
@Setter
@Entity
@Table(
        name = "projects_items",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "projects_items_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "project_item_type_id","identifier"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class ProjectItem extends BaseBasicEntity<ProjectItem> {

    @Column(name = "project_item_type_id", nullable = false)
    @ColumnDefault(ProjectItemType.REQUIREMENTS_ID + "")
    private Long projectItemTypeId = ProjectItemType.REQUIREMENTS_ID;

    @Column(name = "project_item_origin_id",nullable = false)
    @ColumnDefault(ProjectItemOriginType.AGENT_ID + "")
    private Long projectItemOriginId = ProjectItemOriginType.AGENT_ID;

    @Column(name = "identifier", nullable = false, length = 127)
    private String identifier;

    @Column(name = "name", nullable = false, length = 127)
    private String name;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @Column(name = "notes", length = Integer.MAX_VALUE)
    private String notes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_item_type_id", insertable = false, updatable = false)
    private ProjectItemType projectItemType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_item_origin_id", insertable = false, updatable = false)
    private ProjectItemOriginType projectItemOrigin;

    protected static final long TABLE_ID = 15010;
    public static long getTableId() {
        return TABLE_ID;
    }

}
