package com.sysnormal.data.basic_data_model.repositories.people;

import com.sysnormal.data.basic_data_model.entities.people.BasePeopleEntity;
import com.sysnormal.data.basic_data_model.repositories.BaseBasicRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BasePeopleRepository<E extends BasePeopleEntity<E>, ID> extends BaseBasicRepository<E, ID> {

}
