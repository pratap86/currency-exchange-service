package com.pratap.microservices.currencyexchangeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
public class CurrencyExchangeDto {

    private Long id;
    private String from;
    private String to;
    private BigDecimal conversionMultiple;

}
