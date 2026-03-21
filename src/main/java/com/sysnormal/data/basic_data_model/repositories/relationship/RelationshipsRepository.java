package com.sysnormal.data.basic_data_model.repositories.relationship;

import com.sysnormal.data.basic_data_model.entities.relationships.relationship.Relationship;
import com.sysnormal.data.basic_data_model.repositories.BaseBasicRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RelationshipsRepository extends BaseBasicRepository<Relationship, Long> {

    Optional<Relationship> findByStatusRegIdAndDeletedAtIsNullAndRelationshipTypeIdAndTable1IdAndRecord1ColumnAndRecord1IdAndTable2IdAndRecord2ColumnAndRecord2IdAndEndAtIsNull(
            Long statusRegId,
            Long relationshipTypeId,
            Long table1Id,
            String record1Column,
            Long record1Id,
            Long table2Id,
            String record2Column,
            Long record2Id
    );
}
