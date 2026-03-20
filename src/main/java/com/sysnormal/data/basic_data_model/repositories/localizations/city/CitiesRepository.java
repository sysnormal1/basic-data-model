package com.sysnormal.data.basic_data_model.repositories.localizations.city;

import com.sysnormal.data.basic_data_model.entities.localizations.city.City;
import com.sysnormal.data.basic_data_model.repositories.BaseBasicRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CitiesRepository extends BaseBasicRepository<City, Long> {

    @Override
    default long getTableId(){return City.getTableId();}

    Optional<City> findByStateIdAndName(Long stateId, String name);

}
