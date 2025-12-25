package com.sysnormal.libs.db.entities.basic_entities.commons;

import com.sysnormal.libs.db.entities.basic_entities.BaseBasicEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(
        name = "resources",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "resources_u1",
                        columnNames = {
                                "(coalesce(parent_id, 0))","status_reg_id","data_origin_id","(coalesce(table_origin_id, 0))","(coalesce(id_at_origin, 0))",
                                "resource_type_id",
                                "name"
                        }
                )
        }
)
public class Resource extends BaseBasicEntity<Resource> {

    @Column(name = "resource_type_id", nullable = false)
    private Long resourceTypeId;

    @Column(name = "name", nullable = false, length = 127)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "resource_path", nullable = false, length = Integer.MAX_VALUE)
    private String resourcePath;

    @Column(name = "notes")
    private String notes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resource_type_id", insertable = false, updatable = false)
    private ResourceType resourceType;

    protected static final long TABLE_ID = 202;
    public static long getTableId() {
        return TABLE_ID;
    }

}
