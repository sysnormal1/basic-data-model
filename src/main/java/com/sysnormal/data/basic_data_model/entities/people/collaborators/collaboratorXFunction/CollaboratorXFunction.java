package com.sysnormal.data.basic_data_model.entities.people.collaborators.collaboratorXFunction;

import com.sysnormal.data.basic_data_model.entities.BaseBasicEntity;
import com.sysnormal.data.basic_data_model.entities.people.collaborators.collaboratorContract.CollaboratorContract;
import com.sysnormal.data.basic_data_model.entities.people.collaborators.collaboratorFunction.CollaboratorFunction;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;

/**
 * Entity class
 */
@Entity
@Getter
@Setter
@Table(
        name = "collaborators_x_functions",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "collaborators_x_functions_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "collaborator_contract_id","collaborator_function_id","(coalesce(start_at,'1900-01-01'))"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class CollaboratorXFunction extends BaseBasicEntity<CollaboratorXFunction> {

    @Column(name = "collaborator_contract_id", nullable = false)
    private Long collaboratorContractId;

    @Column(name = "collaborator_function_id", nullable = false)
    private Long collaboratorFunctionId;

    @Column(name = "start_at")
    private LocalDateTime startAt;

    @Column(name = "end_at")
    private LocalDateTime endAt;

    @Column(name = "is_time_controlled", nullable = false)
    @ColumnDefault("1")
    @Check(constraints = "is_time_controlled in (0,1)")
    private Integer isTimeControlled = 1;

    @Column(name = "notes", length = Integer.MAX_VALUE)
    private String notes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "collaborator_contract_id", updatable = false, insertable = false)
    private CollaboratorContract collaboratorContract;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "collaborator_function_id", updatable = false, insertable = false)
    private CollaboratorFunction collaboratorFunction;


    protected static final long TABLE_ID = 6003L;
    public static long getTableId() {
        return TABLE_ID;
    }

}