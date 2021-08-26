package com.nemati.model.dto;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * A DTO for the {@link ProductComment} entity.
 */
public class ProductCommentDTO implements Serializable {

    private Long id;

    private Boolean description;

    private ZonedDateTime created;

    private Long createdBy;

    private ProductDTO product;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getDescription() {
        return description;
    }

    public void setDescription(Boolean description) {
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
        if (!(o instanceof ProductCommentDTO)) {
            return false;
        }

        ProductCommentDTO productCommentDTO = (ProductCommentDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, productCommentDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ProductCommentDTO{" +
            "id=" + getId() +
            ", description='" + getDescription() + "'" +
            ", created='" + getCreated() + "'" +
            ", createdBy=" + getCreatedBy() +
            ", product=" + getProduct() +
            "}";
    }
}
