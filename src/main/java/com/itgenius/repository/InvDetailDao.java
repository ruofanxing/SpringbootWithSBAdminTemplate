
package com.itgenius.repository;


import com.itgenius.beans.InvDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface InvDetailDao extends JpaRepository<InvDetail, Long>, JpaSpecificationExecutor<InvDetail> {
    List<InvDetail> findByInvId(Long invId);
}
