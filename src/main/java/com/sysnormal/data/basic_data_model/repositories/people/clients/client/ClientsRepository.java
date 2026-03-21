package com.sysnormal.data.basic_data_model.repositories.people.clients.client;

import com.sysnormal.data.basic_data_model.entities.people.clients.client.Client;
import com.sysnormal.data.basic_data_model.repositories.people.BasePeopleRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientsRepository extends BasePeopleRepository<Client, Long> {

    }
