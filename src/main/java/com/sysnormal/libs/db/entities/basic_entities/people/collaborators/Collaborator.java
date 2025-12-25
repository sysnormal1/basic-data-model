package com.sysnormal.libs.db.entities.basic_entities.people.collaborators;

import com.sysnormal.libs.db.entities.basic_entities.people.BasePeopleEntity;
import com.sysnormal.libs.db.entities.basic_entities.people.People;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(
        name = "collaborators",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "collaborators_u1",
                        columnNames = {
                                "(coalesce(parent_id, 0))","status_reg_id","data_origin_id","(coalesce(table_origin_id, 0))","(coalesce(id_at_origin, 0))",
                                "people_id"
                        }
                )
        }
)
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