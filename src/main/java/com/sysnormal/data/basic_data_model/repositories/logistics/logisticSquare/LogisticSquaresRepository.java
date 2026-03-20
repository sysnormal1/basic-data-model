package com.sysnormal.data.basic_data_model.repositories.logistics.logisticSquare;

import com.sysnormal.data.basic_data_model.entities.logistic.logisticSquare.LogisticSquare;
import com.sysnormal.data.basic_data_model.repositories.BaseBasicRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogisticSquaresRepository extends BaseBasicRepository<LogisticSquare, Long> {

    @Override
    default long getTableId(){return LogisticSquare.getTableId();}

}
