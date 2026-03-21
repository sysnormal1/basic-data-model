package com.sysnormal.data.basic_data_model.entities.movements.conferenceType;

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
        name = "conference_types",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "conference_types_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "name"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class ConferenceType extends BaseBasicEntity<ConferenceType> {

    @Column(name = "name", nullable = false, length = 127)
    private String name;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @Column(name = "cega", nullable = false)
    @ColumnDefault("0")
    @Check(constraints = "cega in (0,1)")
    private byte cega = 0;

    @Column(name = "semicega", nullable = false)
    @ColumnDefault("0")
    @Check(constraints = "semicega in (0,1)")
    private byte semicega = 0;

    @Column(name = "normal", nullable = false)
    @ColumnDefault("0")
    @Check(constraints = "normal in (0,1)")
    private byte normal = 0;

    public static final long NORMAL_ID = 1;
    public static final long CEGA_ID = 2;
    public static final long SEMICEGA_ID = 3;
    public static final long XML_WITH_LOT_ID = 4;
    public static final long XML_WITHOUT_LOT_ID = 5;

    // Constantes equivalentes
    public static final ConferenceType NORMAL = new ConferenceType(){{
        setId(NORMAL_ID);
        setIsSysRec((byte) 1);
        setName("NORMAL");
        setNormal((byte)1);
    }};
    public static final ConferenceType CEGA = new ConferenceType(){{
        setId(CEGA_ID);
        setIsSysRec((byte) 1);
        setName("CEGA");
        setCega((byte)1);
    }};
    public static final ConferenceType SEMICEGA = new ConferenceType(){{
        setId(SEMICEGA_ID);
        setIsSysRec((byte) 1);
        setName("SEMICEGA");
        setSemicega((byte)1);
    }};
    public static final ConferenceType XML_WITH_LOT = new ConferenceType(){{
        setId(XML_WITH_LOT_ID);
        setIsSysRec((byte) 1);
        setName("XML_WITH_LOT");
        setNormal((byte)1);
    }};
    public static final ConferenceType XML_WITHOUT_LOT = new ConferenceType(){{
        setId(XML_WITHOUT_LOT_ID);
        setIsSysRec((byte) 1);
        setName("XML_WITHOUT_LOT");
        setSemicega((byte)1);
    }};

}