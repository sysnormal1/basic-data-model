package com.sysnormal.data.basic_data_model.repositories.reports.reportDataFount;

import com.sysnormal.data.basic_data_model.entities.reports.reportDataFount.ReportDataFount;
import com.sysnormal.data.basic_data_model.repositories.BaseBasicRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReportDataFountsRepository extends BaseBasicRepository<ReportDataFount, Long> {

    Optional<ReportDataFount> findByName(String name);

}
