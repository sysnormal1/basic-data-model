package com.sysnormal.data.basic_data_model.repositories.movements.movementType;

import com.sysnormal.data.basic_data_model.entities.movements.movementType.MovementType;
import com.sysnormal.data.basic_data_model.repositories.BaseBasicRepository;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Repository
public interface MovementTypesRepository extends BaseBasicRepository<MovementType, Long> {

    @Override
    default long getTableId(){return MovementType.getTableId();}

    default String getInternationalSigla(String sigla) {
        String result = sigla;
        if (StringUtils.hasText(sigla)) {
            switch (sigla.trim().toUpperCase()) {
                case "S": result = "O"; break;//output
                case "E": result = "I"; break;//input
                case "EA": result = "AI"; break;//adjust input
                case "EB": result = "BI"; break;//bonus input
                case "EI": result = "II"; break;//inventory input
                case "ER": result = "SI"; break;//simple shipment input
                case "ET": result = "TI"; break;//transference input
                case "ED": result = "RI"; break;//return input
                case "SA": result = "AO"; break;//adjust output
                case "SB": result = "BO"; break;//bonus output
                case "SI": result = "IO"; break;//inventory output
                case "SR": result = "SO"; break;//simple shipment output
                case "ST": result = "TO"; break;//transference output
                case "SD": result = "RO"; break;//return output
            }
        }
        return result;
    }

    Optional<MovementType> findBySigla(String sigla);


}
