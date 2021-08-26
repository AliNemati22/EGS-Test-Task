package com.nemati.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * A ProductCategory.
 */
@Entity
@Table(name = "product_category")
public class ProductCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "description")
    private String description;

    @Column(name = "created")
    private ZonedDateTime created;

    @Column(name = "created_by")
    private Long createdBy;

    @OneToMany(mappedBy = "articleCategory")
    @JsonIgnoreProperties(value = { "articleReviews", "offerProducts", "articleCategory" }, allowSetters = true)
    private Set<Product> articles = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductCategory id(Long id) {
        this.id = id;
        return this;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public ProductCategory categoryName(String categoryName) {
        this.categoryName = categoryName;
        return this;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return this.description;
    }

    public ProductCategory description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ZonedDateTime getCreated() {
        return this.created;
    }

    public ProductCategory created(ZonedDateTime created) {
        this.created = created;
        return this;
    }

    public void setCreated(ZonedDateTime created) {
        this.created = created;
    }

    public Long getCreatedBy() {
        return this.createdBy;
    }

    public ProductCategory createdBy(Long createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Set<Product> getArticles() {
        return this.articles;
    }

    public ProductCategory articles(Set<Product> products) {
        this.setArticles(products);
        return this;
    }

    public ProductCategory addArticle(Product product) {
        this.articles.add(product);
        product.setArticleCategory(this);
        return this;
    }

    public ProductCategory removeArticle(Product product) {
        this.articles.remove(product);
        product.setArticleCategory(null);
        return this;
    }

    public void setArticles(Set<Product> products) {
        if (this.articles != null) {
            this.articles.forEach(i -> i.setArticleCategory(null));
        }
        if (products != null) {
            products.forEach(i -> i.setArticleCategory(this));
        }
        this.articles = products;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ProductCategory)) {
            return false;
        }
        return id != null && id.equals(((ProductCategory) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ProductCategory{" +
            "id=" + getId() +
            ", categoryName='" + getCategoryName() + "'" +
            ", description='" + getDescription() + "'" +
            ", created='" + getCreated() + "'" +
            ", createdBy=" + getCreatedBy() +
            "}";
    }
}
