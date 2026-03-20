package com.sysnormal.data.basic_data_model.repositories.logistics.logisticRoute;

import com.sysnormal.data.basic_data_model.entities.logistic.logisticRoute.LogisticRoute;
import com.sysnormal.data.basic_data_model.repositories.BaseBasicRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogisticRoutesRepository extends BaseBasicRepository<LogisticRoute, Long> {

    @Override
    default long getTableId(){return LogisticRoute.getTableId();}

}
