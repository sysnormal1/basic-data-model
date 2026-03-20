package com.sysnormal.data.basic_data_model.repositories.items.itemDepartment;

import com.sysnormal.data.basic_data_model.entities.items.itemDepartment.ItemDepartment;
import com.sysnormal.data.basic_data_model.repositories.BaseBasicRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemDepartmentsRepository extends BaseBasicRepository<ItemDepartment, Long> {

    @Override
    default long getTableId(){return ItemDepartment.getTableId();}

}
