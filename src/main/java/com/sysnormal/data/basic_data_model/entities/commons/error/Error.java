package com.sysnormal.data.basic_data_model.entities.commons.error;

import com.sysnormal.data.base_data_model.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Entity class
 */
@Getter
@Setter
@Entity
@Table(
        name = "errors"
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Error extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Long id;

    @Column(name = "object_type", length = 127)
    private String objectType;

    @Column(name = "object_name", length = 127)
    private String objectName;

    @Column(name = "line", length = 127)
    private String line;

    @Column(name = "code", length = 127)
    private String code;

    @Column(name = "data", length = 2000)
    private String data;

    protected static final long TABLE_ID = 1;
    public static long getTableId() {
        return TABLE_ID;
    }
}
