package com.nemati.model.dto;

import com.nemati.model.Product;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * A DTO for the {@link Product} entity.
 */
public class ProductDTO implements Serializable {

    private Long id;

    private String productName;

    private Float vat;

    private Float fee;

    private Integer count;

    private Float totalPrice;

    private String description;

    private ZonedDateTime created;

    private Long createdBy;

    private ProductCategoryDTO articleCategory;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Float getVat() {
        return vat;
    }

    public void setVat(Float vat) {
        this.vat = vat;
    }

    public Float getFee() {
        return fee;
    }

    public void setFee(Float fee) {
        this.fee = fee;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ZonedDateTime getCreated() {
        return created;
    }

    public void setCreated(ZonedDateTime created) {
        this.created = created;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public ProductCategoryDTO getArticleCategory() {
        return articleCategory;
    }

    public void setArticleCategory(ProductCategoryDTO articleCategory) {
        this.articleCategory = articleCategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ProductDTO)) {
            return false;
        }

        ProductDTO productDTO = (ProductDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, productDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ProductDTO{" +
            "id=" + getId() +
            ", productName='" + getProductName() + "'" +
            ", vat=" + getVat() +
            ", fee=" + getFee() +
            ", count=" + getCount() +
            ", totalPrice=" + getTotalPrice() +
            ", description='" + getDescription() + "'" +
            ", created='" + getCreated() + "'" +
            ", createdBy=" + getCreatedBy() +
            ", articleCategory=" + getArticleCategory() +
            "}";
    }
}
