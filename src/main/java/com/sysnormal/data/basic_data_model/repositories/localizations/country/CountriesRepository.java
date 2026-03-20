package com.sysnormal.data.basic_data_model.repositories.localizations.country;

import com.sysnormal.data.basic_data_model.entities.localizations.country.Country;
import com.sysnormal.data.basic_data_model.repositories.BaseBasicRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Repository
public interface CountriesRepository extends BaseBasicRepository<Country, Long> {

    @Override
    default long getTableId(){return Country.getTableId();}

    default String getInternationalName(String name) {
        String result = name;
        if (StringUtils.hasText(name)) {
            switch (name.trim().toLowerCase()) {
                case "brasil":
                    result = "brazil";
                    break;
            }
        }
        return result;
    }

    default Optional<Country> findByName(String name){
        if (StringUtils.hasText(name)) {
            Specification<Country> spec = (root, query, cb) -> cb.or(
                    cb.equal(
                            cb.lower(cb.trim(root.get("name"))),
                            getInternationalName(name).toLowerCase().trim()
                    ),
                    cb.equal(
                            cb.lower(cb.trim(root.get("name"))),
                            name.toLowerCase().trim()
                    )
            );

            return this.findAll(spec, PageRequest.of(0,1)).stream().findFirst();
        }
        return Optional.empty();
    };


}
