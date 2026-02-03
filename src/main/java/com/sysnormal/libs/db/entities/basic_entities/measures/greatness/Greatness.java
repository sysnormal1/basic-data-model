package com.sysnormal.libs.db.entities.basic_entities.measures.greatness;

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
        name = "greatnesses",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "greatnesses_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "name", "sigla"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Greatness extends BaseBasicEntity<Greatness> {

    @Column(name = "name", nullable = false, length = 127)
    private String name;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @Column(name = "sigla", nullable = false, length = 10)
    private String sigla;

    @Column(name = "is_scalar", nullable = false)
    @ColumnDefault("0")
    @Check(constraints = "is_scalar in (0,1)")
    private byte isScalar = 0;

    @Column(name = "is_vetorial", nullable = false)
    @ColumnDefault("0")
    @Check(constraints = "is_vetorial in (0,1)")
    private byte isVetorial = 0;


    protected static final long TABLE_ID = 79L;
    public static long getTableId() {
        return TABLE_ID;
    }

    // Constantes equivalentes
    public static final long QUANTITY_ID = 1L;
    public static final long MASS_ID = 2L;
    public static final long VOLUM_ID = 3L;
    public static final long LENGTH_ID = 4L;

    public static final Greatness QUANTITY = new Greatness(){{
        setId(QUANTITY_ID);
        setIsSysRec((byte) 1);
        setName("QUANTITY");
        setSigla("QT");
        setIsScalar((byte) 1);
    }};
    public static final Greatness MASS = new Greatness(){{
        setId(MASS_ID);
        setIsSysRec((byte) 1);
        setName("MASS");
        setSigla("M");
        setIsScalar((byte) 1);
    }};
    public static final Greatness VOLUM = new Greatness(){{
        setId(VOLUM_ID);
        setIsSysRec((byte) 1);
        setName("VOLUM");
        setSigla("V");
        setIsScalar((byte) 1);
    }};
    public static final Greatness LENGTH = new Greatness(){{
        setId(LENGTH_ID);
        setIsSysRec((byte) 1);
        setName("LENGTH");
        setSigla("L");
        setIsScalar((byte) 1);
    }};
}