package com.sysnormal.libs.db.entities.basic_entities.agents.agent;

import com.sysnormal.libs.db.entities.basic_entities.BaseBasicEntity;
import com.sysnormal.libs.db.entities.basic_entities.commons.identifierType.IdentifierType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

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

    @Column(name = "alias")
    private String alias;

    @Column(name = "notes", length = 1000)
    private String notes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "identifier_type_id", nullable = false, updatable = false, insertable = false)
    private IdentifierType identifierType;

     protected static final long TABLE_ID = 120L;

    public static long getTableId() {
        return TABLE_ID;
    }

    // Constantes equivalentes
    public static final long SYSTEM_ID = 0;
}