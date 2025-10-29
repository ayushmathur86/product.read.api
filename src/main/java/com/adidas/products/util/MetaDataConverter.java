package com.adidas.products.util;


import com.adidas.products.model.MetaData;

import javax.persistence.Converter;


@Converter(autoApply = true)
public class MetaDataConverter extends JsonConverter<MetaData> {
    public MetaDataConverter() {
        super(MetaData.class);
    }
}