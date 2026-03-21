package com.sysnormal.data.basic_data_model.repositories.people.businesses.companies.company;

import com.sysnormal.data.basic_data_model.entities.people.businesses.companies.company.Company;
import com.sysnormal.data.basic_data_model.repositories.people.BasePeopleRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompaniesRepository extends BasePeopleRepository<Company, Long> {

    }
