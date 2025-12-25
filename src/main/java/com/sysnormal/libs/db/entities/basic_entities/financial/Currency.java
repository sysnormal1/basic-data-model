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

@Getter
@Setter
@Entity
@Table(
        name = "currencies",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "currencies_u1",
                        columnNames = {
                                "(coalesce(parent_id, 0))","status_reg_id","data_origin_id","(coalesce(table_origin_id, 0))","(coalesce(id_at_origin, 0))",
                                "name"
                        }
                )
        }
)
public class Currency extends BaseBasicEntity<Currency> {

    @Column(name = "name", nullable = false, length = 127)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "symbol", length = 10)
    private String symbol;

    @Column(name = "is_physical", nullable = false, length = 1)
    @ColumnDefault("1")
    @Check(constraints = "is_physical in (0,1)")
    private byte isPhysical = 1;

    protected static final long TABLE_ID = 1030;
    public static long getTableId() {
        return TABLE_ID;
    }

    public static final long DOLAR_ID = 1;
    public static final long BRL_ID = 2;

    public static final Currency DOLAR = new Currency(){{
        setId(DOLAR_ID);
        setIsSysRec((byte) 1);
        setName("DOLAR");
        setSymbol("$");
        setIsSysRec((byte) 1);
    }};
    public static final Currency BRL = new Currency(){{
        setId(BRL_ID);
        setIsSysRec((byte) 1);
        setName("BRAZILIAN REAL");
        setSymbol("R$");
        setIsSysRec((byte) 1);
    }};
}
