package com.openpay.service.service;

import com.openpay.service.model.Audit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AuditService {

    Audit save(String endpoint);
    Page<Audit> list(Pageable pageable);
}
