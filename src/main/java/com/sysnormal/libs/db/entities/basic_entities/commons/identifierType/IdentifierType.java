package com.sysnormal.libs.db.entities.basic_entities.commons.identifierType;

import com.sysnormal.libs.db.entities.basic_entities.BaseBasicEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(
        name = "identifier_types",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "identifier_types_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "name"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class IdentifierType extends BaseBasicEntity<IdentifierType> {
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", length = 1000)
    private String description;

    @Column(name = "process_to_validate", length = 1000)
    private String processToValidate;

    protected static final long TABLE_ID = 70L;
    public static long getTableId() {
        return TABLE_ID;
    }


    public static final long IDENTIFIER_ID = 1;
    public static final long CODE_ID = 2;
    public static final long CNPJ_ID = 3;
    public static final long CPF_ID = 4;
    public static final long CHAVENFE_ID = 5;
    public static final long EMAIL_ID = 6;
    public static final long GTIN_ID = 10;
    public static final long GTINTYPE_ID = 11;
    public static final long PLATE_ID = 12;
    public static final long PACKAGING_ID = 8001;
    public static final long SUPPLIER_ID = 5000;
    public static final long VALUE_ID = 20;
    public static final long WINTHORCODE_ID = 30;
    public static final long WINTHORCODEFAB_ID = 31;

    public static final IdentifierType IDENTIFIER = new IdentifierType(){{
        setId(IDENTIFIER_ID);
        setIsSysRec((byte) 1);
        setName("IDENTIFIER");
    }};
    public static final IdentifierType CODE = new IdentifierType(){{
        setId(CODE_ID);
        setIsSysRec((byte) 1);
        setName("CODE");
    }};
    public static final IdentifierType CNPJ = new IdentifierType(){{
        setId(CNPJ_ID);
        setIsSysRec((byte) 1);
        setName("CNPJ");
    }};
    public static final IdentifierType CPF = new IdentifierType(){{
        setId(CPF_ID);
        setIsSysRec((byte) 1);
        setName("CPF");
    }};
    public static final IdentifierType CHAVENFE = new IdentifierType(){{
        setId(CHAVENFE_ID);
        setIsSysRec((byte) 1);
        setName("CHAVENFE");
    }};
    public static final IdentifierType EMAIL = new IdentifierType(){{
        setId(EMAIL_ID);
        setIsSysRec((byte) 1);
        setName("EMAIL");
    }};
    public static final IdentifierType GTIN = new IdentifierType(){{
        setId(GTIN_ID);
        setIsSysRec((byte) 1);
        setName("GTIN");
    }};
    public static final IdentifierType GTINTYPE = new IdentifierType(){{
        setId(GTINTYPE_ID);
        setIsSysRec((byte) 1);
        setName("GTINTYPE");
    }};
    public static final IdentifierType PLATE = new IdentifierType(){{
        setId(PLATE_ID);
        setIsSysRec((byte) 1);
        setName("PLATE");
    }};
    public static final IdentifierType PACKAGING = new IdentifierType(){{
        setId(PACKAGING_ID);
        setIsSysRec((byte) 1);
        setName("PACKAGING");
    }};
    public static final IdentifierType SUPPLIER = new IdentifierType(){{
        setId(SUPPLIER_ID);
        setIsSysRec((byte) 1);
        setName("SUPPLIER");
    }};
    public static final IdentifierType VALUE = new IdentifierType(){{
        setId(VALUE_ID);
        setIsSysRec((byte) 1);
        setName("VALUE");
    }};
    public static final IdentifierType WINTHORCODE = new IdentifierType(){{
        setId(WINTHORCODE_ID);
        setIsSysRec((byte) 1);
        setName("WINTHORCODE");
    }};
    public static final IdentifierType WINTHORCODEFAB = new IdentifierType(){{
        setId(WINTHORCODEFAB_ID);
        setIsSysRec((byte) 1);
        setName("WINTHORCODEFAB");
    }};

}


