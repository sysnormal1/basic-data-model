package com.sysnormal.data.basic_data_model.entities.storage.warehouseAddress;

import com.sysnormal.data.basic_data_model.entities.BaseBasicEntity;
import com.sysnormal.data.basic_data_model.entities.commons.identifierType.IdentifierType;
import com.sysnormal.data.basic_data_model.entities.measures.formType.FormType;
import com.sysnormal.data.basic_data_model.entities.people.businesses.warehouses.warehouse.Warehouse;
import com.sysnormal.data.basic_data_model.entities.storage.warehouseAddressType.WarehouseAddressType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.ColumnDefault;

/**
 * Entity class
 */
@Entity
@Getter
@Setter
@Table(
        name = "warehouse_addresses",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "warehouse_addresses_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "warehouse_id", "identifier"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class WarehouseAddress extends BaseBasicEntity<WarehouseAddress> {

    @Column(name = "warehouse_id", nullable = false)
    private Long warehouseId;

    @Column(name = "warehouse_address_type_id", nullable = false)
    private Long warehouseAddressTypeId;

    @Column(name = "identifier_type_id", nullable = false)
    private Long identifierTypeId;

    @Column(name = "identifier", nullable = false, length = 127)
    private String identifier;

    @Column(name = "form_type_id", nullable = false)
    private Long formTypeId;

    @Column(name = "is_storable", nullable = false)
    @ColumnDefault("1")
    @Check(constraints = "is_storable in (0,1)")
    private byte isStorable = 1;

    @Column(name = "is_passable", nullable = false)
    @ColumnDefault("0")
    @Check(constraints = "is_passable in (0,1)")
    private byte isPassable = 0;

    @Column(name = "is_disponible", nullable = false)
    @ColumnDefault("1")
    @Check(constraints = "is_disponible in (0,1)")
    private byte isDisponible = 1;

    @Column(name = "notes", length = Integer.MAX_VALUE)
    private String notes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "warehouse_id", insertable = false, updatable = false)
    private Warehouse warehouse;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "warehouse_address_type_id", insertable = false, updatable = false)
    private WarehouseAddressType warehouseAddressType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "identifier_type_id", insertable = false, updatable = false)
    private IdentifierType identifierType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "form_type_id", insertable = false, updatable = false)
    private FormType formType;

    protected static final long TABLE_ID = 3004;
    public static long getTableId() {
        return TABLE_ID;
    }

}