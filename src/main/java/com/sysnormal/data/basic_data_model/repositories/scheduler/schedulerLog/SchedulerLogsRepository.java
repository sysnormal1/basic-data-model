package com.sysnormal.data.basic_data_model.repositories.scheduler.schedulerLog;

import com.sysnormal.data.basic_data_model.entities.scheduler.schedulerLog.SchedulerLog;
import com.sysnormal.data.basic_data_model.repositories.BaseBasicRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchedulerLogsRepository extends BaseBasicRepository<SchedulerLog, Long> {

    @Override
    default long getTableId(){return SchedulerLog.getTableId();}

}
