package com.sysnormal.data.basic_data_model.repositories.movements.movement;

import com.sysnormal.data.basic_data_model.entities.movements.movement.Movement;
import com.sysnormal.data.basic_data_model.repositories.BaseBasicRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;

@Repository
public interface MovementsRepository extends BaseBasicRepository<Movement, Long> {

    @Override
    default long getTableId(){return Movement.getTableId();}

    @Query(value = """
        SELECT
            m.id as movement_id,
            m.type_mov_id as type_mov_id,
            m.status_mov_id as status_mov_id,
            i.id as item_id,
            i.net_weight_un as net_weight_un,
            i.gross_weight_un as gross_weight_un,
            (select id from ncms where exception is null and ncm = :ncm) as ncm_id,
            (select id from fiscal_codes where fiscal_code = :fiscalCode) as fiscal_code_id,
            (select id from suppliers where data_origin_id = :dataOriginId and id_at_origin = :supplierIdAtOrigin) as supplier_id,
            (select id from item_departments where data_origin_id = :dataOriginId and id_at_origin = :itemDepartmentIdAtOrigin) as item_department_id,
            (select id from measurement_units where sigla = :measurementUnitSigla) as measurement_unit_id
        FROM
            movements m
            left outer join items i on i.data_origin_id = :dataOriginId and i.id_at_origin = :itemIdAtOrigin
        WHERE
            m.data_origin_id = :dataOriginId 
            and m.table_origin_id = :tableOriginId
            and m.id_at_origin = :idAtOrigin
    """, nativeQuery = true)
    Optional<Map<String, Object>> findWithJoins(
        @Param("dataOriginId") Long dataOriginId,
        @Param("tableOriginId") Long tableOriginId,
        @Param("idAtOrigin") String idAtOrigin,
        @Param("itemIdAtOrigin") String itemIdAtOrigin,
        @Param("ncm") Long ncm,
        @Param("fiscalCode") Integer fiscalCode,
        @Param("supplierIdAtOrigin") String supplierIdAtOrigin,
        @Param("itemDepartmentIdAtOrigin") String itemDepartmentIdAtOrigin,
        @Param("measurementUnitSigla") String measurementUnitSigla
    );

    @Query(value = """
        SELECT
            m.id as movement_id,
            m.type_mov_id as type_mov_id,
            m.status_mov_id as status_mov_id,
            m.seller_id as seller_id,
            i.id as item_id,
            i.net_weight_un as net_weight_un,
            i.gross_weight_un as gross_weight_un,
            i.ncm_id as ncm_id,
            (select id from fiscal_codes where fiscal_code = :fiscalCode) as fiscal_code_id,
            (select id from suppliers where data_origin_id = :dataOriginId and id_at_origin = :supplierIdAtOrigin) as supplier_id,
            (select id from item_departments where data_origin_id = :dataOriginId and id_at_origin = :itemDepartmentIdAtOrigin) as item_department_id,
            (select id from measurement_units where sigla = :measurementUnitSigla) as measurement_unit_id
        FROM
            movements m
            left outer join items i on i.data_origin_id = :dataOriginId and i.id_at_origin = :itemIdAtOrigin
        WHERE
            m.data_origin_id = :dataOriginId 
            and m.id_at_origin = :idAtOrigin
    """, nativeQuery = true)
    Optional<Map<String, Object>> findWithJoins(
            @Param("dataOriginId") Long dataOriginId,
            @Param("idAtOrigin") String idAtOrigin,
            @Param("itemIdAtOrigin") String itemIdAtOrigin,
            @Param("fiscalCode") Integer fiscalCode,
            @Param("supplierIdAtOrigin") String supplierIdAtOrigin,
            @Param("itemDepartmentIdAtOrigin") String itemDepartmentIdAtOrigin,
            @Param("measurementUnitSigla") String measurementUnitSigla
    );


}
