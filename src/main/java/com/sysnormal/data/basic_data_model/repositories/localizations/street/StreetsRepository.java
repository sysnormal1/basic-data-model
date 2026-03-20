package com.sysnormal.data.basic_data_model.repositories.localizations.street;

import com.sysnormal.data.basic_data_model.entities.localizations.street.Street;
import com.sysnormal.data.basic_data_model.repositories.BaseBasicRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StreetsRepository extends BaseBasicRepository<Street, Long> {

    @Override
    default long getTableId(){return Street.getTableId();}

    Optional<Street> findByCityIdAndName(Long cityId, String name);


}
