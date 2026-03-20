package com.sysnormal.data.basic_data_model.repositories.people.people;

import com.sysnormal.commons.core.utils_core.TextUtils;
import com.sysnormal.data.basic_data_model.entities.people.people.People;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.domain.Specification;

public class PeopleSpecs {

    public static Specification<People> normalizedIdentifierDocEquals(String identifierDoc) {
        String onlyDigits = TextUtils.onlyDigitsLeftTrim(identifierDoc);
        return (root, query, cb) ->
                cb.equal(
                        cb.trim(
                                CriteriaBuilder.Trimspec.LEADING,
                                cb.literal('0'),
                                cb.function(
                                        "regexp_replace",
                                        String.class,
                                        root.get("identifierDoc"),
                                        cb.literal("[^0-9]"),
                                        cb.literal("")
                                )
                        ),
                        onlyDigits
                );
    }

}
