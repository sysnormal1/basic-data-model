package com.sysnormal.data.basic_data_model.repositories.people.people;

import com.sysnormal.data.basic_data_model.entities.people.people.People;
import com.sysnormal.data.basic_data_model.repositories.BaseBasicRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PeopleRepository extends BaseBasicRepository<People, Long> {

    default Optional<People> findByByIdentifierDocTypeIdAndIdentifierDoc(Long identifierDocTypeId, String identifierDoc) {
        Specification<People> specs = (root, query, cb) -> cb.and(
                PeopleSpecs.normalizedIdentifierDocEquals(identifierDoc).toPredicate(root, query, cb),
                cb.equal(root.get("identifierDocTypeId"), identifierDocTypeId)
        );
        return findAll(specs, PageRequest.of(0,1)).stream().findFirst();
    }

}
