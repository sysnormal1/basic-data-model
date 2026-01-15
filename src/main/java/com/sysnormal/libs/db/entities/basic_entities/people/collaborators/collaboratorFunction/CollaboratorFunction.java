package com.sysnormal.libs.db.entities.basic_entities.people.collaborators.collaboratorFunction;

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
        name = "collaborator_functions",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "collaborator_functions_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "name"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class CollaboratorFunction extends BaseBasicEntity<CollaboratorFunction> {

    @Column(name = "name", nullable = false, length = 127)
    private String name;

    @Column(name = "is_trust", nullable = false)
    @ColumnDefault("1")
    @Check(constraints = "is_trust in (0,1)")
    private Integer isTrust = 0;

    @Column(name = "is_time_controlled", nullable = false)
    @ColumnDefault("1")
    @Check(constraints = "is_time_controlled in (0,1)")
    private Integer isTimeControlled = 0;

    @Column(name = "notes")
    private String notes;

    protected static final long TABLE_ID = 6001L;
    public static long getTableId() {
        return TABLE_ID;
    }

    public static final long ADMINISTRATOR_ID = 1L;
    public static final long SUPERVISOR_ID = 2L;
    public static final long SELLER_ID = 3L;

    public static final CollaboratorFunction ADMINISTRATOR = new CollaboratorFunction(){{
        setId(ADMINISTRATOR_ID);
        setIsSysRec((byte) 1);
        setName("ADMINISTRATOR");
    }};
    public static final CollaboratorFunction SUPERVISOR = new CollaboratorFunction(){{
        setId(SUPERVISOR_ID);
        setIsSysRec((byte) 1);
        setName("SUPERVISOR");
    }};
    public static final CollaboratorFunction SELLER = new CollaboratorFunction(){{
        setId(SELLER_ID);
        setIsSysRec((byte) 1);
        setName("SELLER");
    }};
}