package com.adidas.products.model;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.swagger.annotations.ApiModelProperty;

/**
 * Class to represent product_description of the product.
 *
 */
@JsonSerialize
@JsonPropertyOrder({ "title", "subtitle", "text" })
public class ProductDescription implements Serializable {

    @JsonProperty("title")
    @ApiModelProperty(notes = "The title of the product")
    private String title;

    @JsonProperty("subtitle")
    @ApiModelProperty(notes = "The subtitile of the product")
    private String subtitle;

    @JsonProperty("text")
    @ApiModelProperty(notes = "The text of the product")
    private String text;

    private final static long serialVersionUID = 7184786613965775002L;

    public ProductDescription() {
    }

    public ProductDescription(String title, String subtitle, String text) {
        this.title = title;
        this.subtitle = subtitle;
        this.text = text;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    public ProductDescription withTitle(String title) {
        this.title = title;
        return this;
    }

    @JsonProperty("subtitle")
    public String getSubtitle() {
        return subtitle;
    }

    @JsonProperty("subtitle")
    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public ProductDescription withSubtitle(String subtitle) {
        this.subtitle = subtitle;
        return this;
    }

    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

    public ProductDescription withText(String text) {
        this.text = text;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("title", title).append("subtitle", subtitle).append("text", text)
                .toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(text).append(title).append(subtitle).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ProductDescription) == false) {
            return false;
        }
        ProductDescription rhs = ((ProductDescription) other);
        return new EqualsBuilder().append(text, rhs.text).append(title, rhs.title).append(subtitle, rhs.subtitle)
                .isEquals();
    }

}