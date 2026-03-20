package com.sysnormal.data.basic_data_model.repositories.localizations.postalCode;


import com.sysnormal.commons.core.utils_core.TextUtils;
import com.sysnormal.data.basic_data_model.entities.localizations.postalCode.PostalCode;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.domain.Specification;

public class PostalCodesSpecs {

    public static Specification<PostalCode> normalizedPostalCodeEquals(String postalCode) {
        String onlyDigits = TextUtils.onlyDigitsLeftTrim(postalCode);
        return (root, query, cb) ->
                cb.equal(
                        cb.trim(
                                CriteriaBuilder.Trimspec.LEADING,
                                cb.literal('0'),
                                cb.function(
                                        "regexp_replace",
                                        String.class,
                                        root.get("postalCode"),
                                        cb.literal("[^0-9]"),
                                        cb.literal("")
                                )
                        ),
                        onlyDigits
                );
    }
}
