package com.sysnormal.libs.db.entities.basic_entities.storage.lot;

import com.sysnormal.libs.db.entities.basic_entities.BaseBasicEntity;
import com.sysnormal.libs.db.entities.basic_entities.commons.identifierType.IdentifierType;
import com.sysnormal.libs.db.entities.basic_entities.people.suppliers.supplier.Supplier;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(
        name = "lots",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "lots_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "(coalesce(supplier_id,0))",
                                "identifier_type_id",
                                "identifier"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Lot extends BaseBasicEntity<Lot> {

    @Column(name = "supplier_id")
    private Long supplierId;

    @Column(name = "identifier_type_id", nullable = false)
    private Long identifierTypeId;

    @Column(name = "identifier",nullable = false, length = 127)
    private String identifier;

    @Column(name = "production_date")
    private LocalDateTime productionDate;

    @Column(name = "expiration_date")
    private LocalDateTime expirationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id", insertable = false, updatable = false)
    private Supplier supplier;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "identifier_type_id", insertable = false, updatable = false)
    private IdentifierType identifierType;

    protected static final long TABLE_ID = 8014;

    public static long getTableId() {
        return TABLE_ID;
    }

    public static final long WITHOUT_LOT_ID = 1;

    public static final Lot WITHOUT_LOT = new Lot(){{
        setId(WITHOUT_LOT_ID);
        setIsSysRec((byte) 1);
        setIdentifierTypeId(IdentifierType.IDENTIFIER_ID);
        setIdentifier(WITHOUT_LOT+"");
    }};

}