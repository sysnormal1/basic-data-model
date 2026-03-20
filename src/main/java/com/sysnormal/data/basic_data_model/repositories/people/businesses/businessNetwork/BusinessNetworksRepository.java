package com.sysnormal.data.basic_data_model.repositories.people.businesses.businessNetwork;

import com.sysnormal.data.basic_data_model.entities.people.businesses.businessNetwork.BusinessNetwork;
import com.sysnormal.data.basic_data_model.repositories.BaseBasicRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessNetworksRepository extends BaseBasicRepository<BusinessNetwork, Long> {

    @Override
    default long getTableId(){return BusinessNetwork.getTableId();}

}
