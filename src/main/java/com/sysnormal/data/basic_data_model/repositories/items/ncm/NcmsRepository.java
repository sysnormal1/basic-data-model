package com.sysnormal.data.basic_data_model.repositories.items.ncm;

import com.sysnormal.data.basic_data_model.entities.items.ncm.Ncm;
import com.sysnormal.data.basic_data_model.repositories.BaseBasicRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NcmsRepository extends BaseBasicRepository<Ncm, Long> {

    Optional<Ncm> findByNcmAndException(Long code, Byte exception);

}
