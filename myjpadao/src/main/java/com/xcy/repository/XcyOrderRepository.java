package com.xcy.repository;

import com.xcy.domain.XcyOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface XcyOrderRepository extends JpaRepository<XcyOrder, String>,JpaSpecificationExecutor<XcyOrder> {
}
