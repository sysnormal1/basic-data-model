package com.sysnormal.data.basic_data_model.repositories.people.collaborators.collaborator;

import com.sysnormal.data.basic_data_model.entities.people.collaborators.collaborator.Collaborator;
import com.sysnormal.data.basic_data_model.repositories.people.BasePeopleRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollaboratorsRepository extends BasePeopleRepository<Collaborator, Long> {

    @Override
    default long getTableId(){return Collaborator.getTableId();}

}
