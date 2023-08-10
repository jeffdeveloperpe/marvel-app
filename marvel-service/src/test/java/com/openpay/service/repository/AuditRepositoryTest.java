package com.openpay.service.repository;

import com.openpay.service.model.Audit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AuditRepositoryTest {

    @Mock AuditRepository repository;

    @Test
    public void test_save() {
        when(repository.save(any())).thenReturn(new Audit(1L, "Endpoint", new Date()));
        assertEquals(repository.save(any()).getId(), 1L);
    }

    @Test
    public void test_list() {
        when(repository.list(any())).thenReturn(Page.empty());
        assertNotNull(repository.list(any()));
    }
}
