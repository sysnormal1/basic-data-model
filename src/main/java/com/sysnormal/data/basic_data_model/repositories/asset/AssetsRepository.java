package com.sysnormal.data.basic_data_model.repositories.asset;


import com.sysnormal.data.basic_data_model.entities.assets.assets.Assets;
import com.sysnormal.data.basic_data_model.repositories.BaseBasicRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetsRepository extends BaseBasicRepository<Assets, Long> {

}
