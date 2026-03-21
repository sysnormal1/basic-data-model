package com.sysnormal.data.basic_data_model.entities.records.dataOrigin;

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
        name = "data_origins",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "data_origins_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "name"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class DataOrigin extends BaseBasicEntity<DataOrigin> {

    @Column(name = "name", nullable = false, length = 127)
    private String name;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @Column(name = "sigla", length = 10)
    private String sigla;


    public static final long DEFAULT_ORIGINDATA_ID = 1;
    public static final long WINTHOR_ID = 2;
    public static final long AURORA_ID = 3;
    public static final long EP_ID = 4;
    public static final long CONSULTA_ID = 5;
    public static final long SALES_FORCE_APP_ID = 100L;
    public static final long WEB_ID = 101L;
    public static final long BUSINESS_COUNTER_ID = 102L;//BALCAO
    public static final long TELEMARKET_ID = 103L;
    public static final long BUSINESS_RESERVE_COUNTER_ID = 104L;//BALCAO
    public static final long APP_COLLECTOR_ID = 1001;
    public static final long APP_DELIVERY_ID = 1002;


    public static final DataOrigin DEFAULT_ORIGINDATA = new DataOrigin(){{
        setId(DEFAULT_ORIGINDATA_ID);
        setIsSysRec((byte) 1);
        setName("DEFAULT_ORIGINDATA");
    }};
    public static final DataOrigin WINTHOR = new DataOrigin(){{
        setId(WINTHOR_ID);
        setIsSysRec((byte) 1);
        setName("WINTHOR");
    }};
    public static final DataOrigin AURORA = new DataOrigin(){{
        setId(AURORA_ID);
        setIsSysRec((byte) 1);
        setName("AURORA");
    }};
    public static final DataOrigin EP = new DataOrigin(){{
        setId(EP_ID);
        setIsSysRec((byte) 1);
        setName("EP");
    }};
    public static final DataOrigin CONSULTA = new DataOrigin(){{
        setId(CONSULTA_ID);
        setIsSysRec((byte) 1);
        setName("CONSULTA");
    }};
    public static final DataOrigin SALES_FORCE_APP = new DataOrigin(){{
        setId(SALES_FORCE_APP_ID);
        setIsSysRec((byte) 1);
        setDataOriginId(DataOrigin.WINTHOR_ID);
        setTableOriginId(30216L);
        setIdAtOrigin("F");
        setName("SALES_FORCE_APP");
        setSigla("F");
    }};
    public static final DataOrigin WEB = new DataOrigin(){{
        setId(WEB_ID);
        setIsSysRec((byte) 1);
        setDataOriginId(DataOrigin.WINTHOR_ID);
        setTableOriginId(30216L);
        setIdAtOrigin("W");
        setName("WEB");
        setSigla("W");
    }};
    public static final DataOrigin BUSINESS_COUNTER = new DataOrigin(){{
        setId(BUSINESS_COUNTER_ID);
        setIsSysRec((byte) 1);
        setDataOriginId(DataOrigin.WINTHOR_ID);
        setTableOriginId(30216L);
        setIdAtOrigin("B");
        setName("BUSINESS_COUNTER");
        setSigla("B");
    }};
    public static final DataOrigin TELEMARKET = new DataOrigin(){{
        setId(TELEMARKET_ID);
        setIsSysRec((byte) 1);
        setDataOriginId(DataOrigin.WINTHOR_ID);
        setTableOriginId(30216L);
        setIdAtOrigin("T");
        setName("TELEMARKET");
        setSigla("T");
    }};
    public static final DataOrigin BUSINESS_RESERVE_COUNTER = new DataOrigin(){{
        setId(BUSINESS_RESERVE_COUNTER_ID);
        setIsSysRec((byte) 1);
        setDataOriginId(DataOrigin.WINTHOR_ID);
        setTableOriginId(30216L);
        setIdAtOrigin("R");
        setName("BUSINESS_RESERVE_COUNTER");
        setSigla("R");
    }};
    public static final DataOrigin APP_COLLECTOR = new DataOrigin(){{
        setId(APP_COLLECTOR_ID);
        setIsSysRec((byte) 1);
        setName("APP_COLLECTOR");
    }};
    public static final DataOrigin APP_DELIVERY = new DataOrigin(){{
        setId(APP_DELIVERY_ID);
        setIsSysRec((byte) 1);
        setName("APP_DELIVERY");
    }};
}
