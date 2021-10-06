package com.pratap.microservices.currencyexchangeservice.service;

import com.pratap.microservices.currencyexchangeservice.dto.CurrencyExchangeDto;

public interface CurrencyExchangeService {
    CurrencyExchangeDto getCurrencyExchangeFromAndTo(String from, String to);
}
