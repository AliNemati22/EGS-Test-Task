package com.nemati.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;

/**
 * A ProductReview.
 */
@Entity
@Table(name = "product_review")
public class ProductReview implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rate")
    private Integer rate;

    @Column(name = "created")
    private ZonedDateTime created;

    @Column(name = "created_by")
    private Long createdBy;

    @ManyToOne
    @JsonIgnoreProperties(value = { "articleReviews", "offerProducts", "articleCategory" }, allowSetters = true)
    private Product product;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductReview id(Long id) {
        this.id = id;
        return this;
    }

    public Integer getRate() {
        return this.rate;
    }

    public ProductReview rate(Integer rate) {
        this.rate = rate;
        return this;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public ZonedDateTime getCreated() {
        return this.created;
    }

    public ProductReview created(ZonedDateTime created) {
        this.created = created;
        return this;
    }

    public void setCreated(ZonedDateTime created) {
        this.created = created;
    }

    public Long getCreatedBy() {
        return this.createdBy;
    }

    public ProductReview createdBy(Long createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Product getProduct() {
        return this.product;
    }

    public ProductReview product(Product product) {
        this.setProduct(product);
        return this;
    }

    public void setProduct(Product product) {
        this.product = product;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ProductReview)) {
            return false;
        }
        return id != null && id.equals(((ProductReview) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ProductReview{" +
            "id=" + getId() +
            ", rate=" + getRate() +
            ", created='" + getCreated() + "'" +
            ", createdBy=" + getCreatedBy() +
            "}";
    }
}
