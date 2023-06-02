
package com.itgenius.repository;


import com.itgenius.beans.InvDetail;
import com.itgenius.beans.InvDetailExport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface InvDetailDao extends JpaRepository<InvDetail, Long>, JpaSpecificationExecutor<InvDetail> {
    List<InvDetail> findByInvId(long invId);
    List<InvDetail> findByInvIdAndStatus(long invId,String status);
    @Query(nativeQuery = true,value = "select tbo.batch_code,tbd.status,tbd.updatetime,tbp.* from tb_inv_order tbo JOIN tb_inv_detail tbd on tbo.id=tbd.inv_id join tb_prod tbp on tbd.prod_id =tbp.id where tbo.batch_code=:batchCode")
    List<Map<String,Object>> findInvDetailExport(@Param("batchCode")String batchCode);
    @Query(nativeQuery = true,value = "select tbo.batch_code,tbd.status,tbd.updatetime,tbp.* from tb_inv_order tbo JOIN tb_inv_detail tbd on tbo.id=tbd.inv_id join tb_prod tbp on tbd.prod_id =tbp.id where tbo.id=:invId")
    List<Map<String,Object>> findInvDetailExport(@Param("invId")long invId);
}
