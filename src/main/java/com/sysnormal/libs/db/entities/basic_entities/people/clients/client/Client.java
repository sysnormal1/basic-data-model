package com.sysnormal.libs.db.entities.basic_entities.people.clients.client;

import com.sysnormal.libs.db.entities.basic_entities.people.BasePeopleEntity;
import com.sysnormal.libs.db.entities.basic_entities.people.businesses.businessUnits.businessUnit.BusinessUnit;
import com.sysnormal.libs.db.entities.basic_entities.people.collaborators.collaborator.Collaborator;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(
        name = "clients",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "clients_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "people_id"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Client extends BasePeopleEntity<Client> {

    @Column(name = "business_unit_id")
    private Long businessUnitId;

    @Column(name = "administrator_id")
    private Long administratorId;

    @Column(name = "seller_id")
    private Long sellerId;

    @Column(name = "last_buy_at")
    private LocalDateTime lastBuyAt;

    @Column(name = "credit_limit", precision = 38, scale = 12)
    private BigDecimal creditLimit;

    @Column(name = "is_bloqued", nullable = false)
    @ColumnDefault("0")
    @Check(constraints = "is_bloqued in (0,1)")
    private byte isBloqued = 0;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "business_unit_id", updatable = false, insertable = false)
    private BusinessUnit businessUnit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "administrator_id", updatable = false, insertable = false)
    private Collaborator administrator;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id", updatable = false, insertable = false)
    private Collaborator seller;

    protected static final long TABLE_ID = 4000L;
    public static long getTableId() {
        return TABLE_ID;
    }

}