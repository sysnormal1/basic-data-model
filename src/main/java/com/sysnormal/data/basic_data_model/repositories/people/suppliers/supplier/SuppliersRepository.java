package com.sysnormal.data.basic_data_model.repositories.people.suppliers.supplier;

import com.sysnormal.data.basic_data_model.entities.people.suppliers.supplier.Supplier;
import com.sysnormal.data.basic_data_model.repositories.people.BasePeopleRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuppliersRepository extends BasePeopleRepository<Supplier, Long> {

    }
