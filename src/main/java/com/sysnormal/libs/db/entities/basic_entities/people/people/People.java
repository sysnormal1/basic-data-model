package com.sysnormal.libs.db.entities.basic_entities.people.people;

import com.sysnormal.libs.db.entities.basic_entities.BaseBasicEntity;
import com.sysnormal.libs.db.entities.basic_entities.commons.identifierType.IdentifierType;
import com.sysnormal.libs.db.entities.basic_entities.localizations.address.Address;
import com.sysnormal.libs.db.entities.basic_entities.localizations.neighborhood.Neighborhood;
import com.sysnormal.libs.db.entities.basic_entities.localizations.postalCode.PostalCode;
import com.sysnormal.libs.db.entities.basic_entities.localizations.street.Street;
import com.sysnormal.libs.db.entities.basic_entities.logistic.logisticSquare.LogisticSquare;
import com.sysnormal.libs.db.entities.basic_entities.people.businesses.businessLine.BusinessLine;
import com.sysnormal.libs.db.entities.basic_entities.people.businesses.businessNetwork.BusinessNetwork;
import com.sysnormal.libs.db.entities.basic_entities.people.businesses.isic.Isic;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(
        name = "people",
        uniqueConstraints = {
            @UniqueConstraint(
                    name = "people_u1",
                    columnNames = {
                            /*
                            people only is differenced by identifier doc type and document, not by origin
                            "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                             */
                            "identifier_doc_type_id", "identifier_doc"
                    }
            )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class People extends BaseBasicEntity<People> {

    @Column(name = "identifier_doc_type_id", nullable = false)
    private Long identifierDocTypeId;

    @Column(name = "identifier_doc", nullable = false, length = 127)
    private String identifierDoc;

    @Column(name = "name", nullable = false, length = 2000)
    private String name;

    @Column(name = "birth_date")
    private LocalDateTime birthDate;

    @Column(name = "fantasy", length = 2000)
    private String fantasy;

    @Column(name = "alias", length = 2000)
    private String alias;

    @Column(name = "isic_id")
    private Long isicId;

    @Column(name = "business_line_id")
    private Long businessLineId;

    @Column(name = "address_id")
    private Long addressId;

    @Column(name = "neigborhood_id")
    private Long neigborhoodId;

    @Column(name = "street_id")
    private Long streetId;

    @Column(name = "postal_code_id")
    private Long postalCodeId;

    @Column(name = "addrress_number", length = 127)
    private String addrressNumber;

    @Column(name = "complement", length = 127)
    private String complement;

    @Column(name = "phone_number", length = 127)
    private String phoneNumber;

    @Column(name = "latitude", precision = 18, scale = 10)
    private BigDecimal latitude;

    @Column(name = "longitude", precision = 18, scale = 10)
    private BigDecimal longitude;

    @Column(name = "logistic_square_id")
    private Long logisticSquareId;

    @Column(name = "business_network_id")
    private Long businessNetworkId;

    @Column(name = "notes", length = Integer.MAX_VALUE)
    private String notes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "identifier_doc_type_id", nullable = false, updatable = false, insertable = false)
    private IdentifierType identifierDocType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "isic_id", updatable = false, insertable = false)
    private Isic isic;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "business_line_id", updatable = false, insertable = false)
    private BusinessLine businessLine;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id", updatable = false, insertable = false)
    private Address address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "neigborhood_id", updatable = false, insertable = false)
    private Neighborhood neighborhood;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "street_id", updatable = false, insertable = false)
    private Street street;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "postal_code_id", updatable = false, insertable = false)
    private PostalCode postalCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "logistic_square_id", updatable = false, insertable = false)
    private LogisticSquare logisticSquare;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "business_network_id", updatable = false, insertable = false)
    private BusinessNetwork businessNetwork;

    protected static final long TABLE_ID = 100L;
    public static long getTableId() {
        return TABLE_ID;
    }

    public static final long SYSTEM_ID = 0;

    public static final People SYSTEM = new People(){{
        setId(SYSTEM_ID);
        setIsSysRec((byte) 1);
        setIdentifierDocType(IdentifierType.IDENTIFIER);
        setIdentifierDoc(SYSTEM_ID+"");
        setName("SYSTEM");
    }};
}
