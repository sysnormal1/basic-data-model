package com.sysnormal.data.basic_data_model.repositories.measurementUnit;

import com.sysnormal.data.basic_data_model.entities.measures.measurementUnit.MeasurementUnit;
import com.sysnormal.data.basic_data_model.repositories.BaseBasicRepository;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Repository
public interface MeasurementUnitsRepository extends BaseBasicRepository<MeasurementUnit, Long> {

    @Override
    default long getTableId(){return MeasurementUnit.getTableId();}

    default String getInternationalSigla(String sigla) {
        String result = sigla;
        if (StringUtils.hasText(sigla)) {
            switch (sigla.trim().toUpperCase()) {
                case "KG": result = "WT"; break;
                case "PC": result = "PK"; break;//pacote
                case "CX": result = "BX"; break;//caixa
                case "BD": result = "BK"; break;//balde
                case "LT": result = "CN"; break;//lata
                case "SC": result = "BG"; break;//saca
            }
        }
        return result;
    }

    Optional<MeasurementUnit> findBySigla(String sigla);


}
