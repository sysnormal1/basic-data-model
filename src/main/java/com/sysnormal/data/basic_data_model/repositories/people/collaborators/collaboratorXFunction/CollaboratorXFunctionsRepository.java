package com.sysnormal.data.basic_data_model.repositories.people.collaborators.collaboratorXFunction;

import com.sysnormal.data.basic_data_model.entities.people.collaborators.collaboratorXFunction.CollaboratorXFunction;
import com.sysnormal.data.basic_data_model.repositories.BaseBasicRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface CollaboratorXFunctionsRepository extends BaseBasicRepository<CollaboratorXFunction, Long> {

    Optional<CollaboratorXFunction> findByCollaboratorContractIdAndCollaboratorFunctionIdAndEndAt(Long collaboratorContractId, Long collaboratorFunctionId, LocalDateTime endAt);

}
