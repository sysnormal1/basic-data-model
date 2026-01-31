package com.sysnormal.libs.db.entities.basic_entities.people.businesses.isic;

import com.sysnormal.libs.db.entities.basic_entities.BaseBasicEntity;
import com.sysnormal.libs.db.entities.basic_entities.localizations.country.Country;
import com.sysnormal.libs.db.entities.basic_entities.localizations.state.State;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(
        name = "isics",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "isics_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "(coalesce(country_id,0))",
                                "(coalesce(state_id,0))",
                                "section",
                                "(coalesce(division,0))",
                                "(coalesce(`group`,0))",
                                "(coalesce(class,0))",
                                "(coalesce(subclass,0))",
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Isic extends BaseBasicEntity<Isic> {
    @Column(name = "country_id")
    private Long countryId;

    @Column(name = "state_id")
    private Long stateId;

    @Column(name = "section", nullable = false, length = 10)
    private String section;

    @Column(name = "division")
    private Short division;

    @Column(name = "group")
    private Short group;

    @Column(name = "class")
    private Short clazz;

    @Column(name = "subclass")
    private Short subclass;

    @Column(name = "description", nullable = false, length = 4000)
    private String description;

    @Column(name = "notes", length = Integer.MAX_VALUE)
    private String notes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", updatable = false, insertable = false)
    private Country country;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "state_id", updatable = false, insertable = false)
    private State state;

    protected static final long TABLE_ID = 2050L;
    public static long getTableId() {
        return TABLE_ID;
    }
}
