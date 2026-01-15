package com.sysnormal.libs.db.entities.basic_entities.movements.itemMovXmlImportIdConversion;

import com.sysnormal.libs.db.entities.basic_entities.BaseBasicEntity;
import com.sysnormal.libs.db.entities.basic_entities.items.item.Item;
import com.sysnormal.libs.db.entities.basic_entities.measures.measurementUnit.MeasurementUnit;
import com.sysnormal.libs.db.entities.basic_entities.measures.packaging.Packaging;
import com.sysnormal.libs.db.entities.basic_entities.people.clients.client.Client;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(
        name = "item_mov_xml_import_id_conversions",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "item_mov_xml_import_id_conversions_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "owner_client_id",
                                "emitent_doc",
                                "origin_item_id",
                                "xml_quantity_field_name"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class ItemMovXmlImportIdConversion extends BaseBasicEntity<ItemMovXmlImportIdConversion> {

    @Column(name = "owner_client_id", nullable = false)
    private Long ownerClientId;

    @Column(name = "emitent_doc", nullable = false, length = 127)
    private String emitentDoc;

    @Column(name = "origin_item_id", nullable = false, length = 127)
    private String originItemId;

    @Column(name = "xml_quantity_field_name", nullable = false, length = 127)
    private String xmlQuantityFieldName;

    @Column(name = "item_id", nullable = false)
    private Long itemId;

    @Column(name = "packaging_id", nullable = false)
    private Long packagingId;

    @Column(name = "measurement_unit_id", nullable = false)
    private Long measurementUnitId;

    @Column(name = "multiplier", nullable = false, precision = 38, scale = 10)
    @ColumnDefault("1")
    private BigDecimal unitWeight = BigDecimal.ONE;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_client_id", insertable = false, updatable = false)
    private Client ownerClient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id", insertable = false, updatable = false)
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "packaging_id", insertable = false, updatable = false)
    private Packaging packaging;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "measurement_unit_id", insertable = false, updatable = false)
    private MeasurementUnit measurementUnit;

    protected static final long TABLE_ID = 9038;

    public static long getTableId() {
        return TABLE_ID;
    }
}