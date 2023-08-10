package com.openpay.service.service;

import com.openpay.service.model.MarvelResponse;
import com.openpay.service.repository.AuditRepository;
import com.openpay.service.service.impl.AuditServiceImpl;
import com.openpay.service.service.impl.MarvelServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MarvelServiceImplTest {

    @InjectMocks
    MarvelServiceImpl service;

    @Mock
    RestTemplate restTemplate;

    @Mock
    AuditServiceImpl auditService;

    @Mock
    AuditRepository repository;

    @BeforeEach
    public void init() {
    }

    @Test
    public void test_get() {
        when(restTemplate.getForObject(anyString(), eq(MarvelResponse.class))).thenReturn(new MarvelResponse());

        assertNotNull(service.get(1L, 0));
    }

    @Test
    public void test_getEvent() {
        when(restTemplate.getForObject(anyString(), eq(MarvelResponse.class))).thenReturn(new MarvelResponse());

        assertNotNull(service.getEvent(any()));
    }

    @Test
    public void test_getStory() {
        when(restTemplate.getForObject(anyString(), eq(MarvelResponse.class))).thenReturn(new MarvelResponse());

        assertNotNull(service.getStory(any()));
    }

    @Test
    public void test_getSerie() {
        when(restTemplate.getForObject(anyString(), eq(MarvelResponse.class))).thenReturn(new MarvelResponse());

        assertNotNull(service.getSerie(any()));
    }

    @Test
    public void test_getComic() {
        when(restTemplate.getForObject(anyString(), eq(MarvelResponse.class))).thenReturn(new MarvelResponse());

        assertNotNull(service.getComic(any()));
    }
}
