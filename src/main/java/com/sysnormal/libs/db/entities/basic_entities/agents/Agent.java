package com.sysnormal.libs.db.entities.basic_entities.agents;

import com.sysnormal.libs.db.entities.basic_entities.BaseBasicEntity;
import com.sysnormal.libs.db.entities.basic_entities.agents.access.AccessProfile;
import com.sysnormal.libs.db.entities.basic_entities.commons.IdentifierType;
import com.sysnormal.libs.db.entities.basic_entities.people.People;
import com.sysnormal.libs.db.entities.basic_entities.people.collaborators.Collaborator;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Getter
@Setter
@Table(
        name = "agents",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "agents_u1",
                        columnNames = {
                               /*
                            people only is differenced by identifier doc type and document, not by origin
                            "(coalesce(parent_id, 0))","status_reg_id","data_origin_id","(coalesce(table_origin_id, 0))","(coalesce(id_at_origin, 0))",
                             */
                            "identifier_type_id", "identitier"
                        }
                )
        }
)
public class Agent extends BaseBasicEntity {

    @Column(name = "identifier_type_id", nullable = false)
    private Long identifierTypeId;

    @Column(name = "identitier", nullable = false)
    private String identitier;

    @Column(name = "people_id")
    private Long peopleId;

    @Column(name = "collaborator_id")
    private Long collaboratorId;

    @Column(name = "access_profile_id", nullable = false)
    @ColumnDefault(AccessProfile.DEFAULT_ID+"")
    private Long accessProfileId = AccessProfile.DEFAULT_ID;

    @Column(name = "email")
    private String email;

    @Deprecated(forRemoval = true, since = "migrated to sso, will removed when apps completed migrations to new logic")
    @Column(name = "password")
    private String password;

    @Column(name = "last_token")
    private String lastToken;

    @Column(name = "last_timezone_offset")
    private String lastTimezoneOffset;

    @Column(name = "sso_agent_id")
    private Long ssoAgentId;

    @Column(name = "notes", length = 1000)
    private String notes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "identifier_type_id", nullable = false, updatable = false, insertable = false)
    private IdentifierType identifierType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "people_id", insertable = false, updatable = false)
    private People people;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "collaborator_id", insertable = false, updatable = false)
    private Collaborator collaborator;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "access_profile_id", insertable = false, updatable = false)
    private AccessProfile accessProfilie;

    protected static final long TABLE_ID = 120L;

    public static long getTableId() {
        return TABLE_ID;
    }

    // Constantes equivalentes
    public static final long SYSTEM_ID = 0;




}