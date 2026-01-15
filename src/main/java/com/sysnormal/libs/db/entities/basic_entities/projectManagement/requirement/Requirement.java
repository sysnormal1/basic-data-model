package com.sysnormal.libs.db.entities.basic_entities.projectManagement.requirement;

import com.sysnormal.libs.db.entities.basic_entities.BaseBasicEntity;
import com.sysnormal.libs.db.entities.basic_entities.projectManagement.projectItem.ProjectItem;
import com.sysnormal.libs.db.entities.basic_entities.projectManagement.requirementType.RequirementType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Getter
@Setter
@Table(
        name = "requirements",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "requirements_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "project_item_id"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Requirement extends BaseBasicEntity<Requirement> {

    @Column(name = "project_item_id", nullable = false)
    private Long projectItemId;

    @Column(name = "requirement_type_id", nullable = false)
    @ColumnDefault(RequirementType.FUNCTIONAL_ID + "")
    private Long requirementTypeId = RequirementType.FUNCTIONAL_ID;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_item_id", insertable = false, updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ProjectItem projectItem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "requirement_type_id", insertable = false, updatable = false)
    private RequirementType requirementType;

    protected static final long TABLE_ID = 15020;
    public static long getTableId() {
        return TABLE_ID;
    }

}