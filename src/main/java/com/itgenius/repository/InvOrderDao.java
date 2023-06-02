
package com.itgenius.repository;


import com.itgenius.beans.InvDetail;
import com.itgenius.beans.InvOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface InvOrderDao extends JpaRepository<InvOrder, Long>, JpaSpecificationExecutor<InvOrder> {
    List<InvOrder> findByBatchCode(String batchCode);
}
