package com.sysnormal.data.basic_data_model.repositories.items.item;

import com.sysnormal.data.basic_data_model.entities.items.item.Item;
import com.sysnormal.data.basic_data_model.repositories.BaseBasicRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemsRepository extends BaseBasicRepository<Item, Long> {

    @Override
    default long getTableId(){return Item.getTableId();}

}
