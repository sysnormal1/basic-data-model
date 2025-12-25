package com.sysnormal.libs.db.entities.basic_entities.financial;

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
        name = "financial_value_forms",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "financial_value_forms_u1",
                        columnNames = {
                                "(coalesce(parent_id, 0))","status_reg_id","data_origin_id","(coalesce(table_origin_id, 0))","(coalesce(id_at_origin, 0))",
                                "name"
                        }
                )
        }
)
public class FinancialValueForm extends BaseBasicEntity {

    @Column(name = "name", nullable = false, length = 127)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "is_physical", nullable = false)
    @ColumnDefault("0")
    @Check(constraints = "is_physical in (0,1)")
    private byte isPhysical = 0;

    @Column(name = "is_card", nullable = false)
    @ColumnDefault("0")
    @Check(constraints = "is_card in (0,1)")
    private byte isCard = 0;

    @Column(name = "is_eletronic", nullable = false)
    @ColumnDefault("0")
    @Check(constraints = "is_eletronic in (0,1)")
    private byte isEletronic = 0;

    @Column(name = "is_check", nullable = false)
    @ColumnDefault("0")
    @Check(constraints = "is_check in (0,1)")
    private byte isCheck = 0;

    @Column(name = "is_deposit", nullable = false)
    @ColumnDefault("0")
    @Check(constraints = "is_deposit in (0,1)")
    private byte isDeposit = 0;

    @Column(name = "is_bolet", nullable = false)
    @ColumnDefault("0")
    @Check(constraints = "is_bolet in (0,1)")
    private byte isBolet = 0;


    protected static final long TABLE_ID = 1032L;
    public static long getTableId() {
        return TABLE_ID;
    }

    // Constantes equivalentes
    public static final long NONE_ID = 1;
    public static final long MONEY_ID = 2;
    public static final long BOLET_ID = 3;
    public static final long CHECK_ID = 4;
    public static final long PIX_ID = 5;
    public static final long CARD_ID = 6;
    public static final long DEPOSIT_ID = 7;

    public static final FinancialValueForm NONE = new FinancialValueForm(){{
        setId(NONE_ID);
        setIsSysRec((byte) 1);
        setName("NONE");
    }};
    public static final FinancialValueForm MONEY = new FinancialValueForm(){{
        setId(MONEY_ID);
        setIsSysRec((byte) 1);
        setName("MONEY");
        setIsPhysical((byte) 1);
    }};
    public static final FinancialValueForm BOLET = new FinancialValueForm(){{
        setId(BOLET_ID);
        setIsSysRec((byte) 1);
        setName("BOLET");
        setIsEletronic((byte) 1);
        setIsBolet((byte) 1);
    }};
    public static final FinancialValueForm CHECK = new FinancialValueForm(){{
        setId(CHECK_ID);
        setIsSysRec((byte) 1);
        setName("CHECK");
        setIsEletronic((byte) 1);
    }};
    public static final FinancialValueForm PIX = new FinancialValueForm(){{
        setId(PIX_ID);
        setIsSysRec((byte) 1);
        setName("PIX");
        setIsEletronic((byte) 1);
    }};
    public static final FinancialValueForm CARD = new FinancialValueForm(){{
        setId(CARD_ID);
        setIsSysRec((byte) 1);
        setName("CARD");
        setIsEletronic((byte) 1);
        setIsCard((byte) 1);
    }};
    public static final FinancialValueForm DEPOSIT = new FinancialValueForm(){{
        setId(DEPOSIT_ID);
        setIsSysRec((byte) 1);
        setName("DEPOSIT");
        setIsEletronic((byte) 1);
    }};
}