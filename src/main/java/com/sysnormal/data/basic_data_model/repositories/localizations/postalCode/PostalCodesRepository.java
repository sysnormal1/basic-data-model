package com.sysnormal.data.basic_data_model.repositories.localizations.postalCode;

import com.sysnormal.data.basic_data_model.entities.localizations.postalCode.PostalCode;
import com.sysnormal.data.basic_data_model.repositories.BaseBasicRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostalCodesRepository extends BaseBasicRepository<PostalCode, Long> {

    @Override
    default long getTableId(){return PostalCode.getTableId();}

    default Optional<PostalCode> findByCityIdAndPostalCode(Long cityId, String postalCode) {
        Specification<PostalCode> specs = ((root, query, cb) ->
            cb.and(
                    PostalCodesSpecs.normalizedPostalCodeEquals(postalCode).toPredicate(root, query, cb),
                    cb.equal(root.get("cityId"), cityId)
            )
        );
        return findAll(specs, PageRequest.of(0,1)).stream().findFirst();
    };


}
