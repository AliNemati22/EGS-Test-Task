package com.nemati.service.criteria;


import com.nemati.utils.jpa.*;
import com.nemati.utils.jpa.Criteria;
import com.nemati.utils.jpa.LongFilter;
import com.nemati.utils.jpa.StringFilter;
import com.nemati.utils.jpa.ZonedDateTimeFilter;

import java.io.Serializable;
import java.util.Objects;


public class ProductCategoryCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter categoryName;

    private StringFilter description;

    private ZonedDateTimeFilter created;

    private LongFilter createdBy;

    private LongFilter articleId;

    public ProductCategoryCriteria() {}

    public ProductCategoryCriteria(ProductCategoryCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.categoryName = other.categoryName == null ? null : other.categoryName.copy();
        this.description = other.description == null ? null : other.description.copy();
        this.created = other.created == null ? null : other.created.copy();
        this.createdBy = other.createdBy == null ? null : other.createdBy.copy();
        this.articleId = other.articleId == null ? null : other.articleId.copy();
    }

    @Override
    public ProductCategoryCriteria copy() {
        return new ProductCategoryCriteria(this);
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

    public StringFilter getCategoryName() {
        return categoryName;
    }

    public StringFilter categoryName() {
        if (categoryName == null) {
            categoryName = new StringFilter();
        }
        return categoryName;
    }

    public void setCategoryName(StringFilter categoryName) {
        this.categoryName = categoryName;
    }

    public StringFilter getDescription() {
        return description;
    }

    public StringFilter description() {
        if (description == null) {
            description = new StringFilter();
        }
        return description;
    }

    public void setDescription(StringFilter description) {
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

    public LongFilter getArticleId() {
        return articleId;
    }

    public LongFilter articleId() {
        if (articleId == null) {
            articleId = new LongFilter();
        }
        return articleId;
    }

    public void setArticleId(LongFilter articleId) {
        this.articleId = articleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final ProductCategoryCriteria that = (ProductCategoryCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(categoryName, that.categoryName) &&
            Objects.equals(description, that.description) &&
            Objects.equals(created, that.created) &&
            Objects.equals(createdBy, that.createdBy) &&
            Objects.equals(articleId, that.articleId)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, categoryName, description, created, createdBy, articleId);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ProductCategoryCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (categoryName != null ? "categoryName=" + categoryName + ", " : "") +
            (description != null ? "description=" + description + ", " : "") +
            (created != null ? "created=" + created + ", " : "") +
            (createdBy != null ? "createdBy=" + createdBy + ", " : "") +
            (articleId != null ? "articleId=" + articleId + ", " : "") +
            "}";
    }
}
