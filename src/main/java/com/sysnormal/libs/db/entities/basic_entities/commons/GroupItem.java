package com.sysnormal.libs.db.entities.basic_entities.commons;

import com.sysnormal.libs.db.entities.basic_entities.BaseBasicEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Getter
@Setter
@Table(
        name = "groups_items",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "groups_items_u1",
                        columnNames = {
                                "(coalesce(parent_id, 0))","status_reg_id","data_origin_id","(coalesce(table_origin_id, 0))","(coalesce(id_at_origin, 0))",
                                "group_id", "item_id"
                        }
                )
        }
)
public class GroupItem extends BaseBasicEntity<GroupItem> {

    @Column(name = "group_id", nullable = false)
    private Long groupId;

    @Column(name = "item_id", nullable = false)
    private Long itemId;

    @Column(name = "is_manual_included", nullable = false)
    @ColumnDefault("0")
    @Check(constraints = "is_manual_included in (0,1)")
    private byte isManualIncluded = 0;

    @Column(name = "notes")
    private String notes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id", insertable = false, updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Group group;

    protected static final long TABLE_ID = 7007;

    public static long getTableId() {
        return TABLE_ID;
    }
}