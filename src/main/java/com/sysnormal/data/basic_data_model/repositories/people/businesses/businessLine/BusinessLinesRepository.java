package com.sysnormal.data.basic_data_model.repositories.people.businesses.businessLine;

import com.sysnormal.data.basic_data_model.entities.people.businesses.businessLine.BusinessLine;
import com.sysnormal.data.basic_data_model.repositories.BaseBasicRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessLinesRepository extends BaseBasicRepository<BusinessLine, Long> {

    @Override
    default long getTableId(){return BusinessLine.getTableId();}

}
