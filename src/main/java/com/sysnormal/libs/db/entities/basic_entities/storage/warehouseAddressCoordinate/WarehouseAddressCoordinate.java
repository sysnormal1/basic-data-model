package com.sysnormal.libs.db.entities.basic_entities.storage.warehouseAddressCoordinate;

import com.sysnormal.libs.db.entities.basic_entities.BaseBasicEntity;
import com.sysnormal.libs.db.entities.basic_entities.storage.warehouseAddress.WarehouseAddress;
import com.sysnormal.libs.db.entities.basic_entities.storage.warehouseAddressType.WarehouseAddressType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Getter
@Setter
@Table(
        name = "warehouse_address_coordinates",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "warehouse_address_coordinates_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "warehouse_address_id",
                                "coordinate_type_id"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class WarehouseAddressCoordinate extends BaseBasicEntity<WarehouseAddressCoordinate> {

    @Column(name = "warehouse_address_id", nullable = false)
    private Long warehouseAddressId;

    @Column(name = "coordinate_type_id", nullable = false)
    private Long coordinateTypeId;

    @Column(name = "value", nullable = false, length = 127)
    private String value;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "warehouse_address_id", insertable = false, updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private WarehouseAddress warehouseAddress;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coordinate_type_id", insertable = false, updatable = false)
    private WarehouseAddressType coordinateType;

    protected static final long TABLE_ID = 3005;
    public static long getTableId() {
        return TABLE_ID;
    }


}