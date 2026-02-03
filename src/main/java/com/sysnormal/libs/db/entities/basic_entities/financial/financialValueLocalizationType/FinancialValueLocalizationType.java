package com.sysnormal.libs.db.entities.basic_entities.financial.financialValueLocalizationType;

import com.sysnormal.libs.db.entities.basic_entities.BaseBasicEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Getter
@Setter
@Table(
        name = "financial_value_localization_types",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "financial_value_localization_types_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "name"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class FinancialValueLocalizationType extends BaseBasicEntity<FinancialValueLocalizationType> {

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

    protected static final long TABLE_ID = 1033;
    public static long getTableId() {
        return TABLE_ID;
    }

    public static final long  UNKNOWN_ID = 1; //DESCONHECIDO
    public static final long  ACCOUNT_ID = 2;
    public static final long  POUCH_ID = 3; // MALOTE

    public static final FinancialValueLocalizationType UNKNOWN = new FinancialValueLocalizationType(){{
        setId(UNKNOWN_ID);
        setIsSysRec((byte) 1);
        setName("UNKNOWN");
    }};
    public static final FinancialValueLocalizationType ACCOUNT = new FinancialValueLocalizationType(){{
        setId(ACCOUNT_ID);
        setIsSysRec((byte) 1);
        setName("ACCOUNT");
    }};
    public static final FinancialValueLocalizationType POUCH = new FinancialValueLocalizationType(){{
        setId(POUCH_ID);
        setIsSysRec((byte) 1);
        setName("POUCH");
        setIsPhysical((byte) 1);
    }};

}