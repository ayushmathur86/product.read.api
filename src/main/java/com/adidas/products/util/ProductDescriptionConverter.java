package com.adidas.products.util;


import com.adidas.products.model.ProductDescription;

import javax.persistence.Converter;


@Converter(autoApply = true)
public class ProductDescriptionConverter extends JsonConverter<ProductDescription> {
    public ProductDescriptionConverter() {
        super(ProductDescription.class);
    }
}