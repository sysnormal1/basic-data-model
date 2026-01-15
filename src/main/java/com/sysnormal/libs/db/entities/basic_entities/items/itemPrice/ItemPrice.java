package com.sysnormal.libs.db.entities.basic_entities.items.itemPrice;

import com.sysnormal.libs.db.entities.basic_entities.BaseBasicEntity;
import com.sysnormal.libs.db.entities.basic_entities.items.item.Item;
import com.sysnormal.libs.db.entities.basic_entities.movements.movementType.MovementType;
import com.sysnormal.libs.db.entities.basic_entities.people.suppliers.supplier.Supplier;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(
        name = "item_prices",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "item_prices_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "item_id",
                                "(coalesce(supplier_id,0))",
                                "mov_type_id",
                                "(coalesce(start_at,'1000-01-01'))",
                                "(coalesce(end_at,'1000-01-01'))",
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class ItemPrice extends BaseBasicEntity<ItemPrice> {

    @Column(name = "item_id", nullable = false)
    private Long itemId;

    @Column(name = "supplier_id")
    private Long supplierId;

    @Column(name = "mov_type_id", nullable = false)
    private Long movTypeId;

    @Column(name = "price", precision = 38, scale = 10)
    private BigDecimal price;

    @Column(name = "start_at")
    private LocalDateTime startAt;

    @Column(name = "end_at")
    private LocalDateTime endAt;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id", insertable = false, updatable = false)
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id", insertable = false, updatable = false)
    private Supplier supplier;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mov_type_id", insertable = false, updatable = false)
    private MovementType movType;

    protected static final long TABLE_ID = 8040;

    public static long getTableId() {
        return TABLE_ID;
    }
}