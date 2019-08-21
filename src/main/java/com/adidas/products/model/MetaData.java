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
 * Class to represent meta_data of the product.
 *
 */
@JsonSerialize
@JsonPropertyOrder({ "page_title", "site_name", "description", "keywords", "canonical" })
public class MetaData implements Serializable {

    @JsonProperty("page_title")
    @ApiModelProperty(notes = "The page title of the product")
    private String pageTitle;

    @JsonProperty("site_name")
    @ApiModelProperty(notes = "The site name of the product")
    private String siteName;

    @JsonProperty("description")
    @ApiModelProperty(notes = "The description of the product")
    private String description;

    @JsonProperty("keywords")
    @ApiModelProperty(notes = "The keywords of the product")
    private String keywords;

    @JsonProperty("canonical")
    @ApiModelProperty(notes = "The canonical representation of the product")
    private String canonical;

    private final static long serialVersionUID = -3847613725282647542L;

    public MetaData() {
    }

    public MetaData(String title, String site, String desc, String key, String uri) {
        this.pageTitle = title;
        this.siteName = site;
        this.description = desc;
        this.canonical = uri;
    }

    @JsonProperty("page_title")
    public String getPageTitle() {
        return pageTitle;
    }

    @JsonProperty("page_title")
    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    public MetaData withPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
        return this;
    }

    @JsonProperty("site_name")
    public String getSiteName() {
        return siteName;
    }

    @JsonProperty("site_name")
    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public MetaData withSiteName(String siteName) {
        this.siteName = siteName;
        return this;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    public MetaData withDescription(String description) {
        this.description = description;
        return this;
    }

    @JsonProperty("keywords")
    public String getKeywords() {
        return keywords;
    }

    @JsonProperty("keywords")
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public MetaData withKeywords(String keywords) {
        this.keywords = keywords;
        return this;
    }

    @JsonProperty("canonical")
    public String getCanonical() {
        return canonical;
    }

    @JsonProperty("canonical")
    public void setCanonical(String canonical) {
        this.canonical = canonical;
    }

    public MetaData withCanonical(String canonical) {
        this.canonical = canonical;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("pageTitle", pageTitle).append("siteName", siteName)
                .append("description", description).append("keywords", keywords).append("canonical", canonical)
                .toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(keywords).append(description).append(pageTitle).append(canonical)
                .append(siteName).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof MetaData) == false) {
            return false;
        }
        MetaData rhs = ((MetaData) other);
        return new EqualsBuilder().append(keywords, rhs.keywords).append(description, rhs.description)
                .append(pageTitle, rhs.pageTitle).append(canonical, rhs.canonical).append(siteName, rhs.siteName)
                .isEquals();
    }

}