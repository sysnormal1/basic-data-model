package com.sysnormal.libs.db.entities.basic_entities.people.collaborators;

import com.sysnormal.libs.db.entities.basic_entities.BaseBasicEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(
        name = "contract_types",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "contract_types_u1",
                        columnNames = {
                                "(coalesce(parent_id, 0))","status_reg_id","data_origin_id","(coalesce(table_origin_id, 0))","(coalesce(id_at_origin, 0))",
                                "name"
                        }
                )
        }
)
public class ContractType extends BaseBasicEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "notes")
    private String notes;

    protected static final long TABLE_ID = 1020L;
    public static long getTableId() {
        return TABLE_ID;
    }


    public static long REGISTERED_ID = 1;
    public static long CONTRACTED_ID = 1;

    public static final ContractType REGISTERED = new ContractType(){{
        setId(REGISTERED_ID);
        setIsSysRec((byte) 1);
        setName("REGISTERED");
    }};
    public static final ContractType CONTRACTED = new ContractType(){{
        setId(CONTRACTED_ID);
        setIsSysRec((byte) 1);
        setName("CONTRACTED");
    }};
}