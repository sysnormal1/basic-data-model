package com.sysnormal.libs.db.entities.basic_entities.items.itemMeasPackIdentif;

import com.sysnormal.libs.db.entities.basic_entities.BaseBasicEntity;
import com.sysnormal.libs.db.entities.basic_entities.commons.identifierType.IdentifierType;
import com.sysnormal.libs.db.entities.basic_entities.items.item.Item;
import com.sysnormal.libs.db.entities.basic_entities.measures.measurementUnit.MeasurementUnit;
import com.sysnormal.libs.db.entities.basic_entities.measures.packaging.Packaging;
import com.sysnormal.libs.db.entities.basic_entities.storage.itemStock.ItemStock;
import com.sysnormal.libs.db.entities.basic_entities.storage.stockEntity.StockEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(
        name = "item_meas_pack_identif",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "item_meas_pack_identif_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "item_id",
                                "packaging_id",
                                "(COALESCE(measurement_unit_id,0))",
                                "(COALESCE(identifier_type_id,0))",
                                "(COALESCE(identifier,'NULL'))",
                                "multiplier",
                                "(COALESCE(stock_item_id,0))",
                                "(COALESCE(stock_entity_id,0))"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class ItemMeasPackIdentif extends BaseBasicEntity<ItemMeasPackIdentif> {

    @Column(name = "item_id", nullable = false)
    private Long itemId;

    @Column(name = "packaging_id", nullable = false)
    private Long packagingId;

    @Column(name = "measurement_unit_id", nullable = false)
    private Long measurementUnitId;

    @Column(name = "unit_weight", precision = 38, scale = 10)
    private BigDecimal unitWeight;

    @Column(name = "package_weight", precision = 38, scale = 10)
    private BigDecimal packageWeight;

    @Column(name = "unit_volume", precision = 38, scale = 10)
    private BigDecimal unitVolume;

    @Column(name = "package_volume", precision = 38, scale = 10)
    private BigDecimal packageVolume;

    @Column(name = "identifier_type_id")
    private Long identifierTypeId;

    @Column(name = "identifier",length = 127)
    private String identifier;

    @Column(name = "multiplier", nullable = false, precision = 38, scale = 10)
    @ColumnDefault("1")
    private BigDecimal multiplier = BigDecimal.ONE;

    @Column(name = "stock_item_id")
    private Long stockItemId;

    @Column(name = "stock_entity_id")
    private Long stockEntityId;

    @Column(name = "numeric_order", nullable = false)
    @ColumnDefault("1")
    private Long numericOrder = 1L;

    @Column(name = "notes", length = Integer.MAX_VALUE)
    private String notes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id", insertable = false, updatable = false)
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "packaging_id", insertable = false, updatable = false)
    private Packaging packaging;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "measurement_unit_id", insertable = false, updatable = false)
    private MeasurementUnit measurementUnit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "identifier_type_id", insertable = false, updatable = false)
    private IdentifierType identifierType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stock_item_id", insertable = false, updatable = false)
    private ItemStock itemStock;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stock_entity_id", insertable = false, updatable = false)
    private StockEntity stockEntity;

    protected static final long TABLE_ID = 8032;

    public static long getTableId() {
        return TABLE_ID;
    }
}