package com.sysnormal.data.basic_data_model.repositories;

import com.sysnormal.data.base_data_model.repositories.BaseCommonRepository;
import com.sysnormal.data.basic_data_model.entities.BaseBasicEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

@NoRepositoryBean
public interface BaseBasicRepository<E extends BaseBasicEntity<E>, ID> extends BaseCommonRepository<E, ID> {

    @Deprecated
    Optional<E> findByDataOriginIdAndIdAtOrigin(Long dataOriginId, String idAtOrigin);

    Optional<E> findByDataOriginIdAndTableOriginIdAndIdAtOrigin(Long dataOriginId, Long tableOriginId, String idAtOrigin);

}
