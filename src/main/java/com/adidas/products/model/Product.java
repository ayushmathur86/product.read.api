package com.adidas.products.model;

import java.io.Serializable;

import javax.persistence.*;

import com.adidas.products.util.JsonConverter;
import com.adidas.products.util.MetaDataConverter;
import com.adidas.products.util.PricingInformationConverter;
import com.adidas.products.util.ProductDescriptionConverter;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Class to represent the product.
 *
 */
@Entity
@Table(name = "PRODUCT")
public class Product implements Serializable {

    @Id
    @Schema(description = "The ID of the product")
    private String id;

    @Schema(description = "The name of the product")
    private String name;

    @Schema(description = "The model number of the product")
    private String modelNumber;

    @Schema(description = "The type of the product")
    private String productType;

    @Lob
    @Convert(converter = MetaDataConverter.class)
    @Schema(description = "The MetaData of the product")
    private MetaData metaData;

    @Lob
    @Convert(converter = PricingInformationConverter.class)
    @Schema(description = "The Pricing Information of the product")
    private PricingInformation pricingInformation;

    @Lob
    @Convert(converter = ProductDescriptionConverter.class)
    @Schema(description = "The Description of the product")
    private ProductDescription productDescription;

    private final static long serialVersionUID = 5630818181778103425L;

    public Product() {
    }

    public Product(String id, String name, String model, String type) {
        this.id = id;
        this.name = name;
        this.modelNumber = model;
        this.productType = type;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    public Product withId(String id) {
        this.id = id;
        return this;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public Product withName(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("model_number")
    public String getModelNumber() {
        return modelNumber;
    }

    @JsonProperty("model_number")
    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public Product withModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
        return this;
    }

    @JsonProperty("product_type")
    public String getProductType() {
        return productType;
    }

    @JsonProperty("product_type")
    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Product withProductType(String productType) {
        this.productType = productType;
        return this;
    }

    @JsonProperty("meta_data")
    public MetaData getMetaData() {
        return metaData;
    }

    @JsonProperty("meta_data")
    public void setMetaData(MetaData metaData) {
        this.metaData = metaData;
    }

    public Product withMetaData(MetaData metaData) {
        this.metaData = metaData;
        return this;
    }

    @JsonProperty("pricing_information")
    public PricingInformation getPricingInformation() {
        return pricingInformation;
    }

    @JsonProperty("pricing_information")
    public void setPricingInformation(PricingInformation pricingInformation) {
        this.pricingInformation = pricingInformation;
    }

    public Product withPricingInformation(PricingInformation pricingInformation) {
        this.pricingInformation = pricingInformation;
        return this;
    }

    @JsonProperty("product_description")
    public ProductDescription getProductDescription() {
        return productDescription;
    }

    @JsonProperty("product_description")
    public void setProductDescription(ProductDescription productDescription) {
        this.productDescription = productDescription;
    }

    public Product withProductDescription(ProductDescription productDescription) {
        this.productDescription = productDescription;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("name", name).append("modelNumber", modelNumber)
                .append("productType", productType).append("metaData", metaData)
                .append("pricingInformation", pricingInformation).append("productDescription", productDescription)
                .toString();
    }

}