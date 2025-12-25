package com.sysnormal.libs.db.entities.basic_entities.people.collaborators;

import com.sysnormal.libs.db.entities.basic_entities.BaseBasicEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(
        name = "collaborator_contracts",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "collaborator_contracts_u1",
                        columnNames = {
                                "(coalesce(parent_id, 0))","status_reg_id","data_origin_id","(coalesce(table_origin_id, 0))","(coalesce(id_at_origin, 0))",
                                "collaborator_id","contract_type_id", "(coalesce(start_at,'1900-01-01'))"
                        }
                )
        }
)
public class CollaboratorContract extends BaseBasicEntity<CollaboratorContract> {

    @Column(name = "collaborator_id", nullable = false)
    private Long collaboratorId;

    @Column(name = "contract_type_id", nullable = false)
    private Long contractTypeId;

    @Column(name = "start_at")
    private LocalDateTime startAt;

    @Column(name = "end_at")
    private LocalDateTime endAt;

    @Column(name = "is_time_controlled", nullable = false)
    @ColumnDefault("1")
    @Check(constraints = "is_time_controlled in (0,1)")
    private Integer isTimeControlled = 1;

    @Column(name = "notes")
    private String notes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "collaborator_id", updatable = false, insertable = false)
    private Collaborator collaborator;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contract_type_id", updatable = false, insertable = false)
    private ContractType contractType;


    protected static final long TABLE_ID = 6002L;
    public static long getTableId() {
        return TABLE_ID;
    }

}