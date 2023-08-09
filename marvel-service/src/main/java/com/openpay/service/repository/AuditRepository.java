package com.openpay.service.repository;

import com.openpay.service.model.Audit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditRepository extends CrudRepository<Audit, Long> {

    @Query("select a from Audit a order by a.id desc")
    Page<Audit> list(Pageable pageable);
}
