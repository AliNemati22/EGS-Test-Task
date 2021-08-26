package com.nemati.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * A Product.
 */
@Entity
@Table(name = "product")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "vat")
    private Float vat;

    @Column(name = "fee")
    private Float fee;

    @Column(name = "count")
    private Integer count;

    @Column(name = "total_price")
    private Float totalPrice;

    @Column(name = "description")
    private String description;

    @Column(name = "created")
    private ZonedDateTime created;

    @Column(name = "created_by")
    private Long createdBy;

    @OneToMany(mappedBy = "product")
    @JsonIgnoreProperties(value = { "product" }, allowSetters = true)
    private Set<ProductReview> articleReviews = new HashSet<>();

    @OneToMany(mappedBy = "product")
    @JsonIgnoreProperties(value = { "product" }, allowSetters = true)
    private Set<ProductComment> offerProducts = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties(value = { "articles" }, allowSetters = true)
    private ProductCategory articleCategory;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product id(Long id) {
        this.id = id;
        return this;
    }

    public String getProductName() {
        return this.productName;
    }

    public Product productName(String productName) {
        this.productName = productName;
        return this;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Float getVat() {
        return this.vat;
    }

    public Product vat(Float vat) {
        this.vat = vat;
        return this;
    }

    public void setVat(Float vat) {
        this.vat = vat;
    }

    public Float getFee() {
        return this.fee;
    }

    public Product fee(Float fee) {
        this.fee = fee;
        return this;
    }

    public void setFee(Float fee) {
        this.fee = fee;
    }

    public Integer getCount() {
        return this.count;
    }

    public Product count(Integer count) {
        this.count = count;
        return this;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Float getTotalPrice() {
        return this.totalPrice;
    }

    public Product totalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
        return this;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getDescription() {
        return this.description;
    }

    public Product description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ZonedDateTime getCreated() {
        return this.created;
    }

    public Product created(ZonedDateTime created) {
        this.created = created;
        return this;
    }

    public void setCreated(ZonedDateTime created) {
        this.created = created;
    }

    public Long getCreatedBy() {
        return this.createdBy;
    }

    public Product createdBy(Long createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Set<ProductReview> getArticleReviews() {
        return this.articleReviews;
    }

    public Product articleReviews(Set<ProductReview> productReviews) {
        this.setArticleReviews(productReviews);
        return this;
    }

    public Product addArticleReview(ProductReview productReview) {
        this.articleReviews.add(productReview);
        productReview.setProduct(this);
        return this;
    }

    public Product removeArticleReview(ProductReview productReview) {
        this.articleReviews.remove(productReview);
        productReview.setProduct(null);
        return this;
    }

    public void setArticleReviews(Set<ProductReview> productReviews) {
        if (this.articleReviews != null) {
            this.articleReviews.forEach(i -> i.setProduct(null));
        }
        if (productReviews != null) {
            productReviews.forEach(i -> i.setProduct(this));
        }
        this.articleReviews = productReviews;
    }

    public Set<ProductComment> getOfferProducts() {
        return this.offerProducts;
    }

    public Product offerProducts(Set<ProductComment> productComments) {
        this.setOfferProducts(productComments);
        return this;
    }

    public Product addOfferProduct(ProductComment productComment) {
        this.offerProducts.add(productComment);
        productComment.setProduct(this);
        return this;
    }

    public Product removeOfferProduct(ProductComment productComment) {
        this.offerProducts.remove(productComment);
        productComment.setProduct(null);
        return this;
    }

    public void setOfferProducts(Set<ProductComment> productComments) {
        if (this.offerProducts != null) {
            this.offerProducts.forEach(i -> i.setProduct(null));
        }
        if (productComments != null) {
            productComments.forEach(i -> i.setProduct(this));
        }
        this.offerProducts = productComments;
    }

    public ProductCategory getArticleCategory() {
        return this.articleCategory;
    }

    public Product articleCategory(ProductCategory productCategory) {
        this.setArticleCategory(productCategory);
        return this;
    }

    public void setArticleCategory(ProductCategory productCategory) {
        this.articleCategory = productCategory;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Product)) {
            return false;
        }
        return id != null && id.equals(((Product) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Product{" +
            "id=" + getId() +
            ", productName='" + getProductName() + "'" +
            ", vat=" + getVat() +
            ", fee=" + getFee() +
            ", count=" + getCount() +
            ", totalPrice=" + getTotalPrice() +
            ", description='" + getDescription() + "'" +
            ", created='" + getCreated() + "'" +
            ", createdBy=" + getCreatedBy() +
            "}";
    }
}
