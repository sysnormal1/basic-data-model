package com.sysnormal.data.basic_data_model.entities.groups.group;

import com.sysnormal.data.basic_data_model.entities.BaseBasicEntity;
import com.sysnormal.data.basic_data_model.entities.commons.entityType.EntityType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Entity class
 */
@Entity
@Getter
@Setter
@Table(
        name = "groups",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "groups_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "sigla"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Group extends BaseBasicEntity<Group> {

    @Column(name = "entity_type_id", nullable = false)
    private Long entityTypeId;

    @Column(name = "sigla", nullable = false,length = 127)
    private String sigla;

    @Column(name = "name", nullable = false,length = 127)
    private String name;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @Column(name = "sql_condiction", length = Integer.MAX_VALUE)
    private String sqlCondiction;

    @Column(name = "notes", length = Integer.MAX_VALUE)
    private String notes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "entity_type_id", insertable = false, updatable = false)
    private EntityType entityType;
}