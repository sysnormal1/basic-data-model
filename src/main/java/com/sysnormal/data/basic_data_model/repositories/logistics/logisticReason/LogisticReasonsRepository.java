package com.sysnormal.data.basic_data_model.repositories.logistics.logisticReason;

import com.sysnormal.data.basic_data_model.entities.logistic.logisticReason.LogisticReason;
import com.sysnormal.data.basic_data_model.repositories.BaseBasicRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogisticReasonsRepository extends BaseBasicRepository<LogisticReason, Long> {

    @Override
    default long getTableId(){return LogisticReason.getTableId();}

}
