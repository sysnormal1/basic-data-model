package com.sysnormal.data.basic_data_model.entities.projectManagement.requirementType;

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
        name = "requirements_types",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "requirements_types_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "name"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class RequirementType extends BaseBasicEntity<RequirementType> {

    @Column(name = "name", nullable = false, length = 127)
    private String name;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @Column(name = "notes", length = Integer.MAX_VALUE)
    private String notes;

    @Column(name = "is_functional", nullable = false)
    @ColumnDefault("1")
    @Check(constraints = "is_functional in (0,1)")
    private byte isFunctional = 1;

    public static final long FUNCTIONAL_ID = 1;
    public static final long NO_FUNCTIONAL_ID = 2;

    public static final RequirementType FUNCTIONAL = new RequirementType(){{
        setId(FUNCTIONAL_ID);
        setIsSysRec((byte) 1);
        setName("FUNCTIONAL");
        setIsFunctional((byte) 1);
    }};
    public static final RequirementType NO_FUNCTIONAL = new RequirementType(){{
        setId(NO_FUNCTIONAL_ID);
        setIsSysRec((byte) 1);
        setName("NO FUNCTIONAL");
        setIsFunctional((byte) 0);
    }};

}