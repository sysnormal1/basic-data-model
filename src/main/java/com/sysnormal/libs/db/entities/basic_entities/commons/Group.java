package com.sysnormal.libs.db.entities.basic_entities.commons;

import com.sysnormal.libs.db.entities.basic_entities.BaseBasicEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(
        name = "groups",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "groups_u1",
                        columnNames = {
                                "(coalesce(parent_id, 0))","status_reg_id","data_origin_id","(coalesce(table_origin_id, 0))","(coalesce(id_at_origin, 0))",
                                "sigla"
                        }
                )
        }
)
public class Group extends BaseBasicEntity<Group> {

    @Column(name = "entity_type_id", nullable = false)
    private Long entityTypeId;

    @Column(name = "sigla", nullable = false,length = 127)
    private String sigla;

    @Column(name = "name", nullable = false,length = 127)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "sql_condiction", length = Integer.MAX_VALUE)
    private String sqlCondiction;

    @Column(name = "notes")
    private String notes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "entity_type_id", insertable = false, updatable = false)
    private EntityType entityType;

    protected static final long TABLE_ID = 7006;

    public static long getTableId() {
        return TABLE_ID;
    }
}