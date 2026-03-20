package com.sysnormal.data.basic_data_model.repositories.localizations.neighborhood;

import com.sysnormal.data.basic_data_model.entities.localizations.neighborhood.Neighborhood;
import com.sysnormal.data.basic_data_model.repositories.BaseBasicRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NeighborhoodsRepository extends BaseBasicRepository<Neighborhood, Long> {

    @Override
    default long getTableId(){return Neighborhood.getTableId();}

    Optional<Neighborhood> findByCityIdAndName(Long cityId, String name);

}


