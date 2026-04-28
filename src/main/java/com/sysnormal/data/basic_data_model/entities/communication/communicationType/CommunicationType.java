package com.sysnormal.data.basic_data_model.entities.communication.communicationType;

import com.sysnormal.data.basic_data_model.entities.BaseBasicEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Entity class
 */
@Getter @Setter
@Entity
@Table(
        name = "communication_types",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "communication_types_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "name"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class CommunicationType extends BaseBasicEntity<CommunicationType> {

    @Column(name = "name", nullable = false, length = 127)
    private String name;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @Column(name = "base_address", length = 5000)
    private String baseAddress;

    @Column(name = "default_endpoint", length = 5000)
    private String defaultEndpoint;

    @Column(name = "default_method", length = 10)
    private String defaultMethod;

    @Column(name = "default_headers", length = 5000)
    private String defaultHeaders;

    @Column(name = "default_body", length = Integer.MAX_VALUE)
    private String defaultBody;

    @Column(name = "default_destiny_id_field_name", length = 100)
    private String defaultDestinyIdFieldName;

    @Column(name = "default_message_field_name", length = 100)
    private String defaultMessageFieldName;

    @Column(name = "text_replacements", length = Integer.MAX_VALUE)
    private String textReplacements;

}