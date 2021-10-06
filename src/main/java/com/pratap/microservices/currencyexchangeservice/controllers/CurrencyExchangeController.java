package com.pratap.microservices.currencyexchangeservice.controllers;

import com.pratap.microservices.currencyexchangeservice.dto.CurrencyExchangeDto;
import com.pratap.microservices.currencyexchangeservice.model.CurrencyExchangeResponseModel;
import com.pratap.microservices.currencyexchangeservice.service.CurrencyExchangeService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/currency-exchange")
@Slf4j
public class CurrencyExchangeController {

    @Autowired
    private Environment environment;

    @Autowired
    private CurrencyExchangeService currencyExchangeService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/from/{from}/to/{to}")
    public CurrencyExchangeResponseModel retrieveExchangeValue
            (@PathVariable("from") String from, @PathVariable("to") String to){

        log.info("Executing retrieveExchangeValue() with from={} and to={}", from, to);
        CurrencyExchangeDto currencyExchangeDto = currencyExchangeService.getCurrencyExchangeFromAndTo(from, to);
        CurrencyExchangeResponseModel currencyExchangeResponseModel = modelMapper.map(currencyExchangeDto, CurrencyExchangeResponseModel.class);
        String port = environment.getProperty("local.server.port");
        currencyExchangeResponseModel.setEnvironment(port);
        return currencyExchangeResponseModel;
    }
}
