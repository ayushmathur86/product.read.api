package com.adidas.products.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.codehaus.jackson.annotate.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * Class to represent the product.
 *
 */
@Entity
@Table(name = "PRODUCT")
public class Product implements Serializable {

    @Id
    @ApiModelProperty(notes = "The ID of the product")
    private String id;

    @ApiModelProperty(notes = "The name of the product")
    private String name;

    @ApiModelProperty(notes = "The model number of the product")
    private String modelNumber;

    @ApiModelProperty(notes = "The type of the product")
    private String productType;

    @Lob
    @ApiModelProperty(notes = "The MetaData of the product")
    private MetaData metaData;

    @Lob
    @ApiModelProperty(notes = "The Pricing Information of the product")
    private PricingInformation pricingInformation;

    @Lob
    @ApiModelProperty(notes = "The Description of the product")
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