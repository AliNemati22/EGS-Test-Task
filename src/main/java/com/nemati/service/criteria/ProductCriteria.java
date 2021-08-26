package com.nemati.service.criteria;

import com.nemati.utils.jpa.*;
import com.nemati.utils.jpa.*;

import java.io.Serializable;
import java.util.Objects;


public class ProductCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter productName;

    private FloatFilter vat;

    private FloatFilter fee;

    private IntegerFilter count;

    private FloatFilter totalPrice;

    private StringFilter description;

    private ZonedDateTimeFilter created;

    private LongFilter createdBy;

    private LongFilter articleReviewId;

    private LongFilter offerProductId;

    private LongFilter articleCategoryId;

    public ProductCriteria() {}

    public ProductCriteria(ProductCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.productName = other.productName == null ? null : other.productName.copy();
        this.vat = other.vat == null ? null : other.vat.copy();
        this.fee = other.fee == null ? null : other.fee.copy();
        this.count = other.count == null ? null : other.count.copy();
        this.totalPrice = other.totalPrice == null ? null : other.totalPrice.copy();
        this.description = other.description == null ? null : other.description.copy();
        this.created = other.created == null ? null : other.created.copy();
        this.createdBy = other.createdBy == null ? null : other.createdBy.copy();
        this.articleReviewId = other.articleReviewId == null ? null : other.articleReviewId.copy();
        this.offerProductId = other.offerProductId == null ? null : other.offerProductId.copy();
        this.articleCategoryId = other.articleCategoryId == null ? null : other.articleCategoryId.copy();
    }

    @Override
    public ProductCriteria copy() {
        return new ProductCriteria(this);
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

    public StringFilter getProductName() {
        return productName;
    }

    public StringFilter productName() {
        if (productName == null) {
            productName = new StringFilter();
        }
        return productName;
    }

    public void setProductName(StringFilter productName) {
        this.productName = productName;
    }

    public FloatFilter getVat() {
        return vat;
    }

    public FloatFilter vat() {
        if (vat == null) {
            vat = new FloatFilter();
        }
        return vat;
    }

    public void setVat(FloatFilter vat) {
        this.vat = vat;
    }

    public FloatFilter getFee() {
        return fee;
    }

    public FloatFilter fee() {
        if (fee == null) {
            fee = new FloatFilter();
        }
        return fee;
    }

    public void setFee(FloatFilter fee) {
        this.fee = fee;
    }

    public IntegerFilter getCount() {
        return count;
    }

    public IntegerFilter count() {
        if (count == null) {
            count = new IntegerFilter();
        }
        return count;
    }

    public void setCount(IntegerFilter count) {
        this.count = count;
    }

    public FloatFilter getTotalPrice() {
        return totalPrice;
    }

    public FloatFilter totalPrice() {
        if (totalPrice == null) {
            totalPrice = new FloatFilter();
        }
        return totalPrice;
    }

    public void setTotalPrice(FloatFilter totalPrice) {
        this.totalPrice = totalPrice;
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

    public LongFilter getArticleReviewId() {
        return articleReviewId;
    }

    public LongFilter articleReviewId() {
        if (articleReviewId == null) {
            articleReviewId = new LongFilter();
        }
        return articleReviewId;
    }

    public void setArticleReviewId(LongFilter articleReviewId) {
        this.articleReviewId = articleReviewId;
    }

    public LongFilter getOfferProductId() {
        return offerProductId;
    }

    public LongFilter offerProductId() {
        if (offerProductId == null) {
            offerProductId = new LongFilter();
        }
        return offerProductId;
    }

    public void setOfferProductId(LongFilter offerProductId) {
        this.offerProductId = offerProductId;
    }

    public LongFilter getArticleCategoryId() {
        return articleCategoryId;
    }

    public LongFilter articleCategoryId() {
        if (articleCategoryId == null) {
            articleCategoryId = new LongFilter();
        }
        return articleCategoryId;
    }

    public void setArticleCategoryId(LongFilter articleCategoryId) {
        this.articleCategoryId = articleCategoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final ProductCriteria that = (ProductCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(productName, that.productName) &&
            Objects.equals(vat, that.vat) &&
            Objects.equals(fee, that.fee) &&
            Objects.equals(count, that.count) &&
            Objects.equals(totalPrice, that.totalPrice) &&
            Objects.equals(description, that.description) &&
            Objects.equals(created, that.created) &&
            Objects.equals(createdBy, that.createdBy) &&
            Objects.equals(articleReviewId, that.articleReviewId) &&
            Objects.equals(offerProductId, that.offerProductId) &&
            Objects.equals(articleCategoryId, that.articleCategoryId)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            id,
            productName,
            vat,
            fee,
            count,
            totalPrice,
            description,
            created,
            createdBy,
            articleReviewId,
            offerProductId,
            articleCategoryId
        );
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ProductCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (productName != null ? "productName=" + productName + ", " : "") +
            (vat != null ? "vat=" + vat + ", " : "") +
            (fee != null ? "fee=" + fee + ", " : "") +
            (count != null ? "count=" + count + ", " : "") +
            (totalPrice != null ? "totalPrice=" + totalPrice + ", " : "") +
            (description != null ? "description=" + description + ", " : "") +
            (created != null ? "created=" + created + ", " : "") +
            (createdBy != null ? "createdBy=" + createdBy + ", " : "") +
            (articleReviewId != null ? "articleReviewId=" + articleReviewId + ", " : "") +
            (offerProductId != null ? "offerProductId=" + offerProductId + ", " : "") +
            (articleCategoryId != null ? "articleCategoryId=" + articleCategoryId + ", " : "") +
            "}";
    }
}
