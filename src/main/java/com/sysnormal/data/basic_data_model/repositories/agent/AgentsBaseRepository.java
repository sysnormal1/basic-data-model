package com.sysnormal.data.basic_data_model.repositories.agent;

import com.sysnormal.data.base_data_model.repositories.BaseRepository;
import com.sysnormal.data.basic_data_model.entities.agents.agent.Agent;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface AgentsBaseRepository<E extends Agent, ID> extends BaseRepository<E, ID> {


}


