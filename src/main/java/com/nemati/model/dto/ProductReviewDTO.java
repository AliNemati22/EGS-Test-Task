package com.nemati.model.dto;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * A DTO for the {@link ProductReview} entity.
 */
public class ProductReviewDTO implements Serializable {

    private Long id;

    private Integer rate;

    private ZonedDateTime created;

    private Long createdBy;

    private ProductDTO product;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
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

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ProductReviewDTO)) {
            return false;
        }

        ProductReviewDTO productReviewDTO = (ProductReviewDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, productReviewDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ProductReviewDTO{" +
            "id=" + getId() +
            ", rate=" + getRate() +
            ", created='" + getCreated() + "'" +
            ", createdBy=" + getCreatedBy() +
            ", product=" + getProduct() +
            "}";
    }
}
