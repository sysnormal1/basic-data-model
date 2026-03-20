package com.sysnormal.data.basic_data_model.repositories.people.businesses.businessUnits.businessUnit;

import com.sysnormal.data.basic_data_model.entities.people.businesses.businessUnits.businessUnit.BusinessUnit;
import com.sysnormal.data.basic_data_model.repositories.people.BasePeopleRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessUnitsRepository extends BasePeopleRepository<BusinessUnit, Long> {

    @Override
    default long getTableId(){return BusinessUnit.getTableId();}

}
