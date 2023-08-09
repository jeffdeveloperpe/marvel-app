package com.openpay.service.service.impl;

import com.openpay.service.model.Audit;
import com.openpay.service.repository.AuditRepository;
import com.openpay.service.service.AuditService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class AuditServiceImpl implements AuditService {

    private final AuditRepository repository;

    @Override
    public Audit save(String endpoint) {
        var audit = new Audit();
        audit.setEndpoint(endpoint);
        audit.setDate(new Date());

        return repository.save(audit);
    }

    @Override
    public Page<Audit> list(Pageable pageable) {
        return repository.list(pageable);
    }
}
