package com.sysnormal.data.basic_data_model.repositories.agent;


import com.sysnormal.data.basic_data_model.entities.agents.agent.Agent;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentsRepository extends AgentsBaseRepository<Agent, Long> {

}

