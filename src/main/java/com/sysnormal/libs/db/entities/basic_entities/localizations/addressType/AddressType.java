package com.sysnormal.libs.db.entities.basic_entities.localizations.addressType;

import com.sysnormal.libs.db.entities.basic_entities.BaseBasicEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(
        name = "address_types",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "address_types_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "name"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class AddressType extends BaseBasicEntity<AddressType> {

    @Column(name = "name", nullable = false, length = 127)
    private String name;

    protected static final long TABLE_ID = 2007L;
    public static long getTableId() {
        return TABLE_ID;
    }

    public static final long RESIDENTIAL_ID = 1L;
    public static final long BUSINESS_ID = 2L;

    public static final AddressType RESIDENTIAL = new AddressType(){{
        setId(RESIDENTIAL_ID);
        setIsSysRec((byte) 1);
        setName("RESIDENTIAL");
    }};
    public static final AddressType BUSINESS = new AddressType(){{
        setId(BUSINESS_ID);
        setIsSysRec((byte) 1);
        setName("BUSINESS");
    }};
}
