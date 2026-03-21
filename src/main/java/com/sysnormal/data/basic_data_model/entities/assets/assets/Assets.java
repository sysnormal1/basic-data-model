package com.sysnormal.data.basic_data_model.entities.assets.assets;

import com.sysnormal.data.basic_data_model.entities.BaseBasicEntity;
import com.sysnormal.data.basic_data_model.entities.assets.assetType.AssetType;
import com.sysnormal.data.basic_data_model.entities.commons.identifierType.IdentifierType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.ColumnDefault;

/**
 * Entity class
 */
@Getter @Setter
@Entity
@Table(
        name = "assets",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "assets_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "asset_type_id","identifier_type_id","identifier"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Assets extends BaseBasicEntity<Assets> {

    @Column(name = "asset_type_id", nullable = false)
    private Long assetTypeId;

    @Column(name = "identifier_type_id", nullable = false)
    private Long identifierTypeId;

    @Column(name = "identifier", nullable = false, length = 127)
    private String identifier;

    @Column(name = "name", nullable = false, length = 127)
    private String name;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @Column(name = "is_own", nullable = false)
    @ColumnDefault("1")
    @Check(constraints = "is_own in (0,1)")
    private byte isOwn = 1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "asset_type_id", updatable = false, insertable = false)
    private AssetType assetType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "identifier_type_id", updatable = false, insertable = false)
    private IdentifierType identifierType;

}