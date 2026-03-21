package com.sysnormal.data.basic_data_model.entities.measures.packaging;

import com.sysnormal.data.basic_data_model.entities.BaseBasicEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Entity class
 */
@Getter
@Setter
@Entity
@Table(
        name = "packagings",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "packagings_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "name","sigla"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Packaging extends BaseBasicEntity<Packaging> {

    @Column(name = "name", nullable = false, length = 127)
    private String name;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @Column(name = "sigla", length = 10)
    private String sigla;

    public static final long BULK_ID = 1; // GRANEL
    public static final long BOX_ID = 2; //CAIXA
    public static final long PACK_ID = 3; //PACOTE
    public static final long BUCKET_ID = 4; //BALDE
    public static final long BAG_ID = 5; //SACO
    public static final long BALE_ID = 6; //FARDO
    public static final long CUP_ID = 7; //COPO
    public static final long CAN_ID = 8; //LATA
    public static final long TUBE_ID = 9; //TUBO
    public static final long ROLL_ID = 10; //ROLO
    public static final long REAM_ID = 11; //RESMA

    //translates to pt-br
    public static final long UN_ID = 1; // GRANEL
    public static final long CX_ID = 2; //CAIXA
    public static final long PCT_ID = 3; //PACOTE
    public static final long BD_ID = 4; //BALDE
    public static final long SC_ID = 5; //SACO
    public static final long FD_ID = 6; //FARDO
    public static final long CP_ID = 7; //COPO
    public static final long LT_ID = 8; //LATA
    public static final long TB_ID = 9; //TUBO
    public static final long RL_ID = 10; //ROLO
    public static final long RS_ID = 11; //RESMA


    public static final Packaging BULK = new Packaging(){{
        setId(BULK_ID);
        setIsSysRec((byte) 1);
        setName("BULK");
        setSigla("BK");
    }};
    public static final Packaging BOX = new Packaging(){{
        setId(BOX_ID);
        setIsSysRec((byte) 1);
        setName("BOX");
        setSigla("BX");
    }};
    public static final Packaging PACK = new Packaging(){{
        setId(PACK_ID);
        setIsSysRec((byte) 1);
        setName("PACK");
        setSigla("PK");
    }};
    public static final Packaging BUCKET = new Packaging(){{
        setId(BUCKET_ID);
        setIsSysRec((byte) 1);
        setName("BUCKET");
        setSigla("BC");
    }};
    public static final Packaging BAG = new Packaging(){{
        setId(BAG_ID);
        setIsSysRec((byte) 1);
        setName("BAG");
        setSigla("BG");
    }};
    public static final Packaging BALE = new Packaging(){{
        setId(BALE_ID);
        setIsSysRec((byte) 1);
        setName("BALE");
        setSigla("BL");
    }};
    public static final Packaging CUP = new Packaging(){{
        setId(CUP_ID);
        setIsSysRec((byte) 1);
        setName("CUP");
        setSigla("CP");
    }};
    public static final Packaging CAN = new Packaging(){{
        setId(CAN_ID);
        setIsSysRec((byte) 1);
        setName("CAN");
        setSigla("CN");
    }};
    public static final Packaging TUBE = new Packaging(){{
        setId(TUBE_ID);
        setIsSysRec((byte) 1);
        setName("TUBE");
        setSigla("TB");
    }};
    public static final Packaging ROLL = new Packaging(){{
        setId(ROLL_ID);
        setIsSysRec((byte) 1);
        setName("ROLL");
        setSigla("RL");
    }};
    public static final Packaging REAM = new Packaging(){{
        setId(REAM_ID);
        setIsSysRec((byte) 1);
        setName("REAM");
        setSigla("RM");
    }};
}
