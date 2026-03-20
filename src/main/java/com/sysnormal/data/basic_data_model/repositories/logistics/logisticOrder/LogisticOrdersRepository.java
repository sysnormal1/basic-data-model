package com.sysnormal.data.basic_data_model.repositories.logistics.logisticOrder;

import com.sysnormal.data.basic_data_model.entities.logistic.logisticOrder.LogisticOrder;
import com.sysnormal.data.basic_data_model.repositories.BaseBasicRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogisticOrdersRepository extends BaseBasicRepository<LogisticOrder, Long> {

    @Override
    default long getTableId(){return LogisticOrder.getTableId();}

}
