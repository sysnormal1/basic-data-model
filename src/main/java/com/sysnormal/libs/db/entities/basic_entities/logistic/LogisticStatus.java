package com.sysnormal.libs.db.entities.basic_entities.logistic;

import com.sysnormal.libs.db.entities.basic_entities.BaseBasicEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Getter
@Setter
@Table(
        name = "logistic_status",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "logistic_status_u1",
                        columnNames = {
                                "(coalesce(parent_id, 0))","status_reg_id","data_origin_id","(coalesce(table_origin_id, 0))","(coalesce(id_at_origin, 0))",
                                "name"
                        }
                )
        }
)
public class LogisticStatus extends BaseBasicEntity {

    @Column(name = "name", nullable = false, length = 127)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "is_to_delivery", nullable = false)
    @ColumnDefault("0")
    @Check(constraints = "is_to_delivery in (0,1)")
    private byte isToDelivery = 0;

    @Column(name = "is_delivering", nullable = false)
    @ColumnDefault("0")
    @Check(constraints = "is_delivering in (0,1)")
    private byte isDelivering = 0;

    @Column(name = "id_delivered", nullable = false)
    @ColumnDefault("0")
    @Check(constraints = "id_delivered in (0,1)")
    private byte idDelivered = 0;

    @Column(name = "is_partial_returned", nullable = false)
    @ColumnDefault("0")
    @Check(constraints = "is_partial_returned in (0,1)")
    private byte isPartialReturned = 0;

    @Column(name = "is_total_returned", nullable = false)
    @ColumnDefault("0")
    @Check(constraints = "is_total_returned in (0,1)")
    private byte isTotalReturned = 0;



    protected static final long TABLE_ID = 9003L;
    public static long getTableId() {
        return TABLE_ID;
    }

    // Constantes equivalentes
    public static final long TO_DELIVERY_ID = 1;
    public static final long DELIVERING_ID = 2;
    public static final long DELIVERED_ID = 3;
    public static final long PARTIAL_RETURNED_ID = 4;
    public static final long TOTAL_RETURNED_ID = 5;

    public static final LogisticStatus TO_DELIVERY = new LogisticStatus(){{
        setId(TO_DELIVERY_ID);
        setIsSysRec((byte) 1);
        setName("TO DELIVERY");
        setIsToDelivery((byte) 1);
    }};
    public static final LogisticStatus DELIVERING = new LogisticStatus(){{
        setId(DELIVERING_ID);
        setIsSysRec((byte) 1);
        setName("DELIVERING");
        setIsDelivering((byte) 1);
    }};
    public static final LogisticStatus DELIVERED = new LogisticStatus(){{
        setId(DELIVERED_ID);
        setIsSysRec((byte) 1);
        setName("DELIVERED");
        setIdDelivered((byte) 1);
    }};
    public static final LogisticStatus PARTIAL_RETURNED = new LogisticStatus(){{
        setId(PARTIAL_RETURNED_ID);
        setIsSysRec((byte) 1);
        setName("PARTIAL RETURNED");
        setIsPartialReturned((byte) 1);
    }};
    public static final LogisticStatus TOTAL_RETURNED = new LogisticStatus(){{
        setId(TOTAL_RETURNED_ID);
        setIsSysRec((byte) 1);
        setName("TOTAL RETURNED");
        setIsTotalReturned((byte) 1);
    }};
}