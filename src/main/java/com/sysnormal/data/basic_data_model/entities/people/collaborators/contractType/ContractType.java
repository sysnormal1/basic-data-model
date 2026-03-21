package com.sysnormal.data.basic_data_model.entities.people.collaborators.contractType;

import com.sysnormal.data.basic_data_model.entities.BaseBasicEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Entity class
 */
@Entity
@Getter
@Setter
@Table(
        name = "contract_types",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "contract_types_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "name"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class ContractType extends BaseBasicEntity<ContractType> {

    @Column(name = "name")
    private String name;

    @Column(name = "notes", length = Integer.MAX_VALUE)
    private String notes;


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