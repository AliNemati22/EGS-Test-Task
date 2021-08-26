package com.nemati.service.criteria;


import com.nemati.utils.jpa.*;
import com.nemati.utils.jpa.BooleanFilter;
import com.nemati.utils.jpa.Criteria;
import com.nemati.utils.jpa.LongFilter;
import com.nemati.utils.jpa.ZonedDateTimeFilter;

import java.io.Serializable;
import java.util.Objects;


public class ProductCommentCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private BooleanFilter description;

    private ZonedDateTimeFilter created;

    private LongFilter createdBy;

    private LongFilter productId;

    public ProductCommentCriteria() {}

    public ProductCommentCriteria(ProductCommentCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.description = other.description == null ? null : other.description.copy();
        this.created = other.created == null ? null : other.created.copy();
        this.createdBy = other.createdBy == null ? null : other.createdBy.copy();
        this.productId = other.productId == null ? null : other.productId.copy();
    }

    @Override
    public ProductCommentCriteria copy() {
        return new ProductCommentCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public LongFilter id() {
        if (id == null) {
            id = new LongFilter();
        }
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public BooleanFilter getDescription() {
        return description;
    }

    public BooleanFilter description() {
        if (description == null) {
            description = new BooleanFilter();
        }
        return description;
    }

    public void setDescription(BooleanFilter description) {
        this.description = description;
    }

    public ZonedDateTimeFilter getCreated() {
        return created;
    }

    public ZonedDateTimeFilter created() {
        if (created == null) {
            created = new ZonedDateTimeFilter();
        }
        return created;
    }

    public void setCreated(ZonedDateTimeFilter created) {
        this.created = created;
    }

    public LongFilter getCreatedBy() {
        return createdBy;
    }

    public LongFilter createdBy() {
        if (createdBy == null) {
            createdBy = new LongFilter();
        }
        return createdBy;
    }

    public void setCreatedBy(LongFilter createdBy) {
        this.createdBy = createdBy;
    }

    public LongFilter getProductId() {
        return productId;
    }

    public LongFilter productId() {
        if (productId == null) {
            productId = new LongFilter();
        }
        return productId;
    }

    public void setProductId(LongFilter productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final ProductCommentCriteria that = (ProductCommentCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(description, that.description) &&
            Objects.equals(created, that.created) &&
            Objects.equals(createdBy, that.createdBy) &&
            Objects.equals(productId, that.productId)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, created, createdBy, productId);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ProductCommentCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (description != null ? "description=" + description + ", " : "") +
            (created != null ? "created=" + created + ", " : "") +
            (createdBy != null ? "createdBy=" + createdBy + ", " : "") +
            (productId != null ? "productId=" + productId + ", " : "") +
            "}";
    }
}
