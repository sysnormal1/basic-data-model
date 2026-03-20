package com.sysnormal.data.basic_data_model.entities.commons.log;

import com.sysnormal.data.base_data_model.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Entity class
 */
@Entity
@Getter
@Setter
@Table(
        name = "logs"
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
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