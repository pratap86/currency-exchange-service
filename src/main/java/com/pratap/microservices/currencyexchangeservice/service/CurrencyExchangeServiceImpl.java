package com.pratap.microservices.currencyexchangeservice.service;

import com.pratap.microservices.currencyexchangeservice.dto.CurrencyExchangeDto;
import com.pratap.microservices.currencyexchangeservice.entity.CurrencyExchangeEntity;
import com.pratap.microservices.currencyexchangeservice.repository.CurrencyExchangeRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CurrencyExchangeServiceImpl implements CurrencyExchangeService{

    @Autowired
    private CurrencyExchangeRepository currencyExchangeRepository;

    @Autowired
    private ModelMapper modelMapper;

    private CurrencyExchangeDto currencyExchangeDto;

    @Override
    public CurrencyExchangeDto getCurrencyExchangeFromAndTo(String from, String to) {

        log.info("Executing getCurrencyExchangeFromAndTo() with from={} and to={}", from, to);
        CurrencyExchangeEntity currencyExchangeEntity = currencyExchangeRepository.findByFromAndTo(from, to);
        if (currencyExchangeEntity == null)
            throw new RuntimeException("Unable to find data from = "+from+" and to = "+ to);
        log.info("currencyExchangeEntity={}", currencyExchangeEntity);

        return modelMapper.map(currencyExchangeEntity, CurrencyExchangeDto.class);
    }
}
