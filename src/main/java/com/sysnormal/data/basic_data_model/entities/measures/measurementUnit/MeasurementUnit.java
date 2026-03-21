package com.sysnormal.data.basic_data_model.entities.measures.measurementUnit;

import com.sysnormal.data.basic_data_model.entities.BaseBasicEntity;
import com.sysnormal.data.basic_data_model.entities.measures.greatness.Greatness;
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
        name = "measurement_units",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "measurement_units_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "name", "sigla"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class MeasurementUnit extends BaseBasicEntity<MeasurementUnit> {

    @Column(name = "greatness_id", nullable = false)
    private Long greatnessId;

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



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "greatness_id", insertable = false, updatable = false)
    private Greatness greatness;

    // Constantes equivalentes
    public static final long UN_ID = 1L;
    public static final long WT_ID = 2L; //WEIGHT
    public static final long VL_ID = 3L; //VALUE
    public static final long DT_ID = 4L; //DISTINCT ITEMS
    public static final long PC_ID = 5L; //PIECE
    public static final long L_ID = 6L;
    public static final long PKG_ID = 10L; //PACKAGE
    public static final long BOX_ID = 11L;
    public static final long BCK_ID = 12L; //BUCKET (BALDE)
    public static final long CAN_ID = 13L; //LATA
    public static final long BAG_ID = 14L; //SACA
    public static final long PCT_ID = 10L; //PACKAGE
    public static final long CX_ID = 11L;
    public static final long BD_ID = 12L; //BUCKET (BALDE)
    public static final long LT_ID = 13L; //LATA
    public static final long SC_ID = 14L; //SACA

    public static final MeasurementUnit UN = new MeasurementUnit(){{
        setId(UN_ID);
        setIsSysRec((byte) 1);
        setGreatnessId(Greatness.QUANTITY_ID);
        setName("UNIT");
        setSigla("UN");
        setIsScalar((byte) 1);
    }};
    public static final MeasurementUnit WT = new MeasurementUnit(){{
        setId(WT_ID);
        setIsSysRec((byte) 1);
        setGreatnessId(Greatness.MASS_ID);
        setName("WEIGHT");
        setSigla("WT");
        setIsScalar((byte) 1);
    }};
    public static final MeasurementUnit VL = new MeasurementUnit(){{
        setId(VL_ID);
        setIsSysRec((byte) 1);
        setGreatnessId(Greatness.VOLUM_ID);
        setName("VALUE");
        setSigla("VL");
        setIsScalar((byte) 1);
    }};
    public static final MeasurementUnit DT = new MeasurementUnit(){{
        setId(DT_ID);
        setIsSysRec((byte) 1);
        setGreatnessId(Greatness.QUANTITY_ID);
        setName("DISTINCT ITEM");
        setSigla("DT");
        setIsScalar((byte) 1);
    }};
    public static final MeasurementUnit PC = new MeasurementUnit(){{
        setId(PC_ID);
        setIsSysRec((byte) 1);
        setGreatnessId(Greatness.QUANTITY_ID);
        setName("PIECE");
        setSigla("PC");
        setIsScalar((byte) 1);
    }};
    public static final MeasurementUnit L = new MeasurementUnit(){{
        setId(L_ID);
        setIsSysRec((byte) 1);
        setGreatnessId(Greatness.VOLUM_ID);
        setName("LITER");
        setSigla("L");
        setIsScalar((byte) 1);
    }};
    public static final MeasurementUnit PKG = new MeasurementUnit(){{
        setId(PKG_ID);
        setIsSysRec((byte) 1);
        setGreatnessId(Greatness.QUANTITY_ID);
        setName("PACKAGE");
        setSigla("PKG");
        setIsScalar((byte) 1);
    }};
    public static final MeasurementUnit BOX = new MeasurementUnit(){{
        setId(BOX_ID);
        setIsSysRec((byte) 1);
        setGreatnessId(Greatness.QUANTITY_ID);
        setName("BOX");
        setSigla("BX");
        setIsScalar((byte) 1);
    }};
    public static final MeasurementUnit BCK = new MeasurementUnit(){{
        setId(BCK_ID);
        setIsSysRec((byte) 1);
        setGreatnessId(Greatness.QUANTITY_ID);
        setName("BUCKET");
        setSigla("BCK");
        setIsScalar((byte) 1);
    }};
    public static final MeasurementUnit CAN = new MeasurementUnit(){{
        setId(CAN_ID);
        setIsSysRec((byte) 1);
        setGreatnessId(Greatness.QUANTITY_ID);
        setName("CAN");
        setSigla("CN");
        setIsScalar((byte) 1);
    }};
    public static final MeasurementUnit BAG = new MeasurementUnit(){{
        setId(BAG_ID);
        setIsSysRec((byte) 1);
        setGreatnessId(Greatness.QUANTITY_ID);
        setName("BAG");
        setSigla("BG");
        setIsScalar((byte) 1);
    }};

}