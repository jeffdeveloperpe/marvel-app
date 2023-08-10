package com.openpay.service.service;

import com.openpay.service.model.Audit;
import com.openpay.service.repository.AuditRepository;
import com.openpay.service.service.impl.AuditServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AuditServiceImplTest {

    @InjectMocks
    AuditServiceImpl service;

    @Mock
    AuditRepository repository;

    @Test
    public void test_save() {
        when(repository.save(any())).thenReturn(new Audit(1L, "", new Date()));

        assertEquals(service.save(any()).getId(), 1L);
    }

    @Test
    public void test_list() {
        when(repository.list(any())).thenReturn(Page.empty());

        assertNotNull(service.list(any()));
    }
}
