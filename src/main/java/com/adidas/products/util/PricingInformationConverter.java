package com.adidas.products.util;

import com.adidas.products.model.PricingInformation;

import javax.persistence.Converter;


@Converter(autoApply = true)
public class PricingInformationConverter extends JsonConverter<PricingInformation> {
    public PricingInformationConverter() {
        super(PricingInformation.class);
    }
}