package com.sysnormal.libs.db.entities.basic_entities.people;

import com.sysnormal.libs.db.entities.basic_entities.BaseBasicEntity;
import com.sysnormal.libs.db.entities.basic_entities.people.people.People;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@MappedSuperclass
@Getter
@Setter
public abstract class BasePeopleEntity<T extends BasePeopleEntity<T>>  extends BaseBasicEntity<T> {

    @Column(name = "people_id", nullable = false)
    private Long peopleId;

    @Column(name = "alias")
    private String alias;

    @Column(name = "notes", length = Integer.MAX_VALUE)
    private String notes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "people_id", insertable = false, updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private People people;
}
