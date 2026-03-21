package com.sysnormal.data.basic_data_model.repositories.scheduler.scheduler;

import com.sysnormal.data.basic_data_model.entities.scheduler.scheduler.Scheduler;
import com.sysnormal.data.basic_data_model.repositories.BaseBasicRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchedulersRepository extends BaseBasicRepository<Scheduler, Long> {


}
