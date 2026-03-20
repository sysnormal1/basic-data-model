package com.sysnormal.data.basic_data_model.entities.assets.assetType;

import com.sysnormal.data.basic_data_model.entities.BaseBasicEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Entity class
 */
@Getter
@Setter
@Entity
@Table(
        name = "asset_types",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "asset_types_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "name"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class AssetType extends BaseBasicEntity<AssetType> {

    @Column(name = "name", nullable = false, length = 127)
    private String name;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    protected static final long TABLE_ID = 1100L;
    public static long getTableId() {
        return TABLE_ID;
    }

    public static final Long VEHICLE_ID = 1L;

    public static final AssetType VEHICLE = new AssetType(){{
        setId(VEHICLE_ID);
        setIsSysRec((byte) 1);
        setName("VEHICLE");
    }};
}
