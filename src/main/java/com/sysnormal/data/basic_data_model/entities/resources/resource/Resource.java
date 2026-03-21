package com.sysnormal.data.basic_data_model.entities.resources.resource;

import com.sysnormal.data.basic_data_model.entities.BaseBasicEntity;
import com.sysnormal.data.basic_data_model.entities.resources.resourceType.ResourceType;
import com.sysnormal.data.basic_data_model.entities.systems.system.System;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 * Entity class
 */
@Getter
@Setter
@Entity
@Table(
        name = "resources",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "resources_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "system_id",
                                "resource_type_id",
                                "name"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Resource extends BaseBasicEntity<Resource> {

    @Column(name = "system_id", nullable = false)
    private Long systemId;

    @Column(name = "resource_type_id", nullable = false)
    private Long resourceTypeId;

    @Column(name = "name", nullable = false, length = 127)
    private String name;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @Column(name = "path", length = Integer.MAX_VALUE)
    private String resourcePath;

    @Column(name = "icon", length = Integer.MAX_VALUE)
    private String icon;

    @Column(name = "numeric_order", nullable = false)
    @ColumnDefault("0")
    private Integer numericOrder = 0;

    @Column(name = "show_in_menu", nullable = false)
    @ColumnDefault("1")
    @Check(constraints = "show_in_menu in (0,1)")
    private byte showInMenu = 1;

    @Column(name = "notes", length = Integer.MAX_VALUE)
    private String notes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "system_id", insertable = false, updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private System system;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resource_type_id", insertable = false, updatable = false)
    private ResourceType resourceType;

}
