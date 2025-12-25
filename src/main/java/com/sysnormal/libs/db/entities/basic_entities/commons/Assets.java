package com.sysnormal.libs.db.entities.basic_entities.commons;

import com.sysnormal.libs.db.entities.basic_entities.BaseBasicEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.ColumnDefault;

@Getter @Setter
@Entity
@Table(
        name = "assets",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "assets_u1",
                        columnNames = {
                                "(coalesce(parent_id, 0))","status_reg_id","data_origin_id","(coalesce(table_origin_id, 0))","(coalesce(id_at_origin, 0))",
                                "asset_type_id","identifier_type_id","identifier"
                        }
                )
        }
)
public class Assets extends BaseBasicEntity {

    @Column(name = "asset_type_id", nullable = false)
    private Long assetTypeId;

    @Column(name = "identifier_type_id", nullable = false)
    private Long identifierTypeId;

    @Column(name = "identifier", nullable = false, length = 127)
    private String identifier;

    @Column(name = "name", nullable = false, length = 127)
    private String name;

    @Column(name = "description")
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


    protected static final long TABLE_ID = 1110L;
    public static long getTableId() {
        return TABLE_ID;
    }

}