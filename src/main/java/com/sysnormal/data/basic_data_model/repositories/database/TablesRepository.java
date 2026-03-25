package com.sysnormal.data.basic_data_model.repositories.database;

import com.sysnormal.data.basic_data_model.entities.database.tables.Tables;
import com.sysnormal.data.basic_data_model.entities.records.dataOrigin.DataOrigin;
import com.sysnormal.data.basic_data_model.repositories.BaseBasicRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface TablesRepository extends BaseBasicRepository<Tables, Long> {
    @Query(value = """
        select t.id
        from `tables` t
        join `schemas` s on s.id = t.schema_id and s.name = :schemaName
        where t.name = :name
    """, nativeQuery = true)
    Optional<Long> getIdBySchemaNameAndName(
        @Param("schemaName") String schemaName,
        @Param("name") String name
    );

}
