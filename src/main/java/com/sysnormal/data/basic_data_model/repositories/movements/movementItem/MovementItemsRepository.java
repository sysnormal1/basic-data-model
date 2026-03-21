package com.sysnormal.data.basic_data_model.repositories.movements.movementItem;

import com.sysnormal.data.basic_data_model.entities.movements.movementItem.MovementItem;
import com.sysnormal.data.basic_data_model.repositories.BaseBasicRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovementItemsRepository extends BaseBasicRepository<MovementItem, Long> {

    Optional<MovementItem> findByMovementIdAndItemIdAndNumOrd(Long movementId, Long itemId, Integer numOrd);
}
