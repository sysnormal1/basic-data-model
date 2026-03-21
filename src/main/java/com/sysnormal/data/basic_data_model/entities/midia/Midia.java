package com.sysnormal.data.basic_data_model.entities.midia;

import com.sysnormal.data.basic_data_model.entities.BaseBasicEntity;
import com.sysnormal.data.basic_data_model.entities.database.tables.Tables;
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
        name = "midias"
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Midia extends BaseBasicEntity<Midia> {

    @Column(name = "table_ref_id")
    private Long tableRefId;

    @Column(name = "record_ref_id", nullable = false)
    private Long recordRefId;

    @Column(name = "numeric_order")
    private Integer numericOrder;

    @Column(name = "name", length = 127)
    private String name;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @Column(name = "type", length = 127)
    private String type;

    @Column(name = "local_path", length = Integer.MAX_VALUE)
    private String localPath;

    @Column(name = "content_base64", length = Integer.MAX_VALUE)
    private String contentBase64;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "table_ref_id", insertable = false, updatable = false)
    private Tables tableRef;

}