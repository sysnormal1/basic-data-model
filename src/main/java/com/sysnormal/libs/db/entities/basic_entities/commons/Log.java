package com.sysnormal.libs.db.entities.basic_entities.commons;

import com.sysnormal.libs.db.entities.base_entities.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(
        name = "logs"
)
public class Log extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Long id;

    @Column(name = "process_name", length = 127)
    private String processName;

    @Column(name = "values_names", length = 2000)
    private String valuesNames;

    protected static final long TABLE_ID = 2;
    public static long getTableId() {
        return TABLE_ID;
    }

}