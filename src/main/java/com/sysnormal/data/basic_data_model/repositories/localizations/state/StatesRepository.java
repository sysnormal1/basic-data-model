package com.sysnormal.data.basic_data_model.repositories.localizations.state;

import com.sysnormal.data.basic_data_model.entities.localizations.state.State;
import com.sysnormal.data.basic_data_model.repositories.BaseBasicRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StatesRepository extends BaseBasicRepository<State, Long> {

    @Override
    default long getTableId(){return State.getTableId();}

    Optional<State> findByCountryIdAndSigla(Long countryId, String sigla);

}
