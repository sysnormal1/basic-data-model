package com.sysnormal.data.basic_data_model.repositories.communication;


import com.sysnormal.data.basic_data_model.entities.communication.communicationType.CommunicationType;
import com.sysnormal.data.basic_data_model.repositories.BaseBasicRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunicationTypesRepository extends BaseBasicRepository<CommunicationType, Long> {

}
