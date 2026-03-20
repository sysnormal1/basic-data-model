package com.sysnormal.data.basic_data_model.repositories.people.businesses.isic;

import com.sysnormal.data.basic_data_model.entities.people.businesses.isic.Isic;
import com.sysnormal.data.basic_data_model.repositories.BaseBasicRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IsicsRepository extends BaseBasicRepository<Isic, Long> {

    @Override
    default long getTableId(){return Isic.getTableId();}

    Optional<Isic> findBySectionAndDivisionAndGroupAndClazzAndSubclass(String section, Short division, Short group, Short clazz, Short subclass);

}
