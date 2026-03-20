package com.sysnormal.data.basic_data_model.repositories.movements.fiscalCode;


import com.sysnormal.data.basic_data_model.entities.movements.fiscalCode.FiscalCode;
import com.sysnormal.data.basic_data_model.repositories.BaseBasicRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FiscalCodesRepository extends BaseBasicRepository<FiscalCode, Long> {

    @Override
    default long getTableId(){return FiscalCode.getTableId();}

    Optional<FiscalCode> findByFiscalCode(Integer fiscalCode);

}
