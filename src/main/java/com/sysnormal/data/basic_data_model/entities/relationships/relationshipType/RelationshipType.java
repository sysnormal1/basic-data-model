package com.sysnormal.data.basic_data_model.entities.relationships.relationshipType;

import com.sysnormal.data.basic_data_model.entities.BaseBasicEntity;
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
        name = "relationship_types",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "relationship_types_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "name"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class RelationshipType extends BaseBasicEntity<RelationshipType> {

    @Column(name = "name", nullable = false, length = 127)
    private String name;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    public static final long RELATIONSHIP_ID = 1;
    public static final long IDENTIFIER_ID = 2;
    public static final long SUBORDINATED_ID = 10;
    public static final long WINTHOR_ID_ID = 11;
    public static final long EP_ID_ID = 12;

    public static final RelationshipType RELATIONSHIP = new RelationshipType(){{
        setId(RELATIONSHIP_ID);
        setIsSysRec((byte) 1);
        setName("RELATIONSHIP");
    }};
    public static final RelationshipType IDENTIFIER = new RelationshipType(){{
        setId(IDENTIFIER_ID);
        setIsSysRec((byte) 1);
        setName("IDENTIFIER");
    }};
    public static final RelationshipType SUBORDINATED = new RelationshipType(){{
        setId(SUBORDINATED_ID);
        setIsSysRec((byte) 1);
        setName("SUBORDINATED");
    }};
    public static final RelationshipType WINTHOR_ID = new RelationshipType(){{
        setId(WINTHOR_ID_ID);
        setIsSysRec((byte) 1);
        setName("WINTHOR ID");
    }};
    public static final RelationshipType EP_ID = new RelationshipType(){{
        setId(EP_ID_ID);
        setIsSysRec((byte) 1);
        setName("EP ID");
    }};



}