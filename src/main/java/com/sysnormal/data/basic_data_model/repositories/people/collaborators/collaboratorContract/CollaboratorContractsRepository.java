package com.sysnormal.data.basic_data_model.repositories.people.collaborators.collaboratorContract;

import com.sysnormal.data.basic_data_model.entities.people.collaborators.collaboratorContract.CollaboratorContract;
import com.sysnormal.data.basic_data_model.repositories.BaseBasicRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface CollaboratorContractsRepository extends BaseBasicRepository<CollaboratorContract, Long> {

    Optional<CollaboratorContract> findByCollaboratorIdAndEndAt(Long collaboratorId, LocalDateTime endAt);

}
