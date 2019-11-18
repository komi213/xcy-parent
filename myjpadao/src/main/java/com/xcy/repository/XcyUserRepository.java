package com.xcy.repository;

import com.xcy.domain.XcyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface XcyUserRepository extends JpaRepository<XcyUser, String>,JpaSpecificationExecutor<XcyUser> {
}
