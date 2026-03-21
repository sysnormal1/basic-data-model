package com.sysnormal.data.basic_data_model.entities.items.itemLotContainer;

import com.sysnormal.data.basic_data_model.entities.BaseBasicEntity;
import com.sysnormal.data.basic_data_model.entities.items.item.Item;
import com.sysnormal.data.basic_data_model.entities.storage.container.Container;
import com.sysnormal.data.basic_data_model.entities.storage.lot.Lot;
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
        name = "items_lots_containers",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "items_lots_containers_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "item_id",
                                "lot_id",
                                "container_id"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class ItemLotContainer extends BaseBasicEntity<ItemLotContainer> {

    @Column(name = "item_id", nullable = false)
    private Long itemId;

    @Column(name = "lot_id", nullable = false)
    private Long lotId;

    @Column(name = "container_id")
    private Long containerId;

    @Column(name = "notes", length = Integer.MAX_VALUE)
    private String notes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id", insertable = false, updatable = false)
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lot_id", insertable = false, updatable = false)
    private Lot lot;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "container_id", insertable = false, updatable = false)
    private Container container;
}