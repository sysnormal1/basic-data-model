package com.sysnormal.data.basic_data_model.repositories.dataOrigin;

import com.sysnormal.data.basic_data_model.entities.records.dataOrigin.DataOrigin;
import com.sysnormal.data.basic_data_model.repositories.BaseBasicRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataOriginsRepository extends BaseBasicRepository<DataOrigin, Long> {

    }
