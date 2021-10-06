package com.pratap.microservices.currencyexchangeservice.repository;

import com.pratap.microservices.currencyexchangeservice.entity.CurrencyExchangeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepository
        extends JpaRepository<CurrencyExchangeEntity, Long> {

    CurrencyExchangeEntity findByFromAndTo(String from, String to);
}
