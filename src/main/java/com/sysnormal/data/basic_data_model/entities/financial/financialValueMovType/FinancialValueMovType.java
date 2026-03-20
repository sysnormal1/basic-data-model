package com.sysnormal.data.basic_data_model.entities.financial.financialValueMovType;

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
        name = "financial_value_mov_types",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "financial_value_mov_types_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "name"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class FinancialValueMovType extends BaseBasicEntity<FinancialValueMovType> {

    @Column(name = "name", nullable = false, length = 127)
    private String name;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @Column(name = "is_physical", nullable = false)
    @ColumnDefault("0")
    @Check(constraints = "is_physical in (0,1)")
    private byte isPhysical = 0;

    @Column(name = "is_eletronic", nullable = false)
    @ColumnDefault("0")
    @Check(constraints = "is_eletronic in (0,1)")
    private byte isEletronic = 0;

    protected static final long TABLE_ID = 1034;
    public static long getTableId() {
        return TABLE_ID;
    }

    public static final long TRANSFERENCE_ID = 1;
    public static final long DEPOSIT_ID = 2;
    public static final long POUCH_ID = 3; // MALOTE

    public static final FinancialValueMovType TRANSFERENCE = new FinancialValueMovType(){{
        setId(TRANSFERENCE_ID);
        setIsSysRec((byte) 1);
        setName("TRANSFERENCE");
        setIsEletronic((byte) 1);
    }};
    public static final FinancialValueMovType DEPOSIT = new FinancialValueMovType(){{
        setId(DEPOSIT_ID);
        setIsSysRec((byte) 1);
        setName("DEPOSIT");
    }};
    public static final FinancialValueMovType POUCH = new FinancialValueMovType(){{
        setId(POUCH_ID);
        setIsSysRec((byte) 1);
        setName("POUCH");
        setIsPhysical((byte) 1);
    }};

}