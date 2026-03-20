package com.sysnormal.data.basic_data_model.entities.people.collaborators.collaborator;

import com.sysnormal.data.basic_data_model.entities.people.BasePeopleEntity;
import com.sysnormal.data.basic_data_model.entities.people.people.People;
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
        name = "collaborators",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "collaborators_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "people_id"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Collaborator extends BasePeopleEntity<Collaborator> {

    protected static final long TABLE_ID = 110L;
    public static long getTableId() {
        return TABLE_ID;
    }

    public static final long SYSTEM_ID = 0;

    public static final Collaborator SYSTEM = new Collaborator(){{
        setId(SYSTEM_ID);
        setIsSysRec((byte) 1);
        setPeopleId(People.SYSTEM_ID);
    }};

}