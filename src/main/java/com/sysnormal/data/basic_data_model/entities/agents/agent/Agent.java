package com.sysnormal.data.basic_data_model.entities.agents.agent;

import com.sysnormal.data.basic_data_model.entities.BaseBasicEntity;
import com.sysnormal.data.basic_data_model.entities.commons.identifierType.IdentifierType;
import com.sysnormal.data.basic_data_model.entities.people.collaborators.collaborator.Collaborator;
import com.sysnormal.data.basic_data_model.entities.people.people.People;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

/**
 * Entity class
 */
@Entity
@Table(
        name = "agents",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "agents_u1",
                        columnNames = {
                               /*
                            people only is differenced by identifier doc type and document, not by origin
                            "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                             */
                                "identifier_type_id", "identifier"
                        }
                )
        }
)
@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Agent extends BaseBasicEntity<Agent> {

    @Column(name = "identifier_type_id", nullable = false)
    @ColumnDefault(IdentifierType.EMAIL_ID + "")
    private Long identifierTypeId = IdentifierType.EMAIL_ID;

    @Column(name = "identifier", nullable = false)
    private String identifier;

    @Column(name = "email",length = 512)
    private String email;

    @Column(name = "access_profile_id")
    private Long accessProfileId;

    @Column(name = "people_id")
    private Long peopleId;

    @Column(name = "collaborator_id")
    private Long collaboratorId;

    @Column(name = "alias")
    private String alias;

    @Column(name = "notes", length = Integer.MAX_VALUE)
    private String notes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "identifier_type_id", nullable = false, updatable = false, insertable = false)
    private IdentifierType identifierType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "people_id", updatable = false, insertable = false)
    private People people;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "collaborator_id", updatable = false, insertable = false)
    private Collaborator collaborator;

    // Constantes equivalentes
    public static final long SYSTEM_ID = 0;
}