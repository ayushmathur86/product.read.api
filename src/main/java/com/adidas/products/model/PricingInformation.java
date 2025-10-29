package com.adidas.products.model;

import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


/**
 * Class to represent pricing_information of the product.
 *
 */
@JsonSerialize
@JsonPropertyOrder({ "standard_price", "standard_price_no_vat", "currentPrice" })
public class PricingInformation implements Serializable {

    @JsonProperty("standard_price")
    @Schema(description = "The standard price of the product")
    private double standardPrice;

    @JsonProperty("standard_price_no_vat")
    @Schema(description = "The standard price without VAT of the product")
    private double standardPriceNoVat;

    @JsonProperty("currentPrice")
    @Schema(description = "The current price of the product")
    private double currentPrice;

    private final static long serialVersionUID = -3531910269169108709L;

    public PricingInformation() {
    }

    public PricingInformation(double price, double noVatPrice, double currPrice) {
        this.standardPrice = price;
        this.standardPriceNoVat = noVatPrice;
        this.currentPrice = currPrice;
    }

    @JsonProperty("standard_price")
    public double getStandardPrice() {
        return standardPrice;
    }

    @JsonProperty("standard_price")
    public void setStandardPrice(double standardPrice) {
        this.standardPrice = standardPrice;
    }

    public PricingInformation withStandardPrice(double standardPrice) {
        this.standardPrice = standardPrice;
        return this;
    }

    @JsonProperty("standard_price_no_vat")
    public double getStandardPriceNoVat() {
        return standardPriceNoVat;
    }

    @JsonProperty("standard_price_no_vat")
    public void setStandardPriceNoVat(double standardPriceNoVat) {
        this.standardPriceNoVat = standardPriceNoVat;
    }

    public PricingInformation withStandardPriceNoVat(double standardPriceNoVat) {
        this.standardPriceNoVat = standardPriceNoVat;
        return this;
    }

    @JsonProperty("currentPrice")
    public double getCurrentPrice() {
        return currentPrice;
    }

    @JsonProperty("currentPrice")
    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public PricingInformation withCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("standardPrice", standardPrice)
                .append("standardPriceNoVat", standardPriceNoVat).append("currentPrice", currentPrice).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(standardPriceNoVat).append(standardPrice).append(currentPrice).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PricingInformation) == false) {
            return false;
        }
        PricingInformation rhs = ((PricingInformation) other);
        return new EqualsBuilder().append(standardPriceNoVat, rhs.standardPriceNoVat)
                .append(standardPrice, rhs.standardPrice).append(currentPrice, rhs.currentPrice).isEquals();
    }

}
