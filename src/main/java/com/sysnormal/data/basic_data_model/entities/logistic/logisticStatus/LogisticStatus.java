package com.sysnormal.data.basic_data_model.entities.logistic.logisticStatus;

import com.sysnormal.data.basic_data_model.entities.BaseBasicEntity;
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
        name = "logistic_status",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "logistic_status_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "name"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class LogisticStatus extends BaseBasicEntity<LogisticStatus> {

    @Column(name = "name", nullable = false, length = 127)
    private String name;

    @Column(name = "description", length = Integer.MAX_VALUE)
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