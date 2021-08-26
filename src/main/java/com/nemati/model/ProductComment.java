package com.nemati.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;

/**
 * A ProductComment.
 */
@Entity
@Table(name = "product_comment")
public class ProductComment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description")
    private Boolean description;

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

    public ProductComment id(Long id) {
        this.id = id;
        return this;
    }

    public Boolean getDescription() {
        return this.description;
    }

    public ProductComment description(Boolean description) {
        this.description = description;
        return this;
    }

    public void setDescription(Boolean description) {
        this.description = description;
    }

    public ZonedDateTime getCreated() {
        return this.created;
    }

    public ProductComment created(ZonedDateTime created) {
        this.created = created;
        return this;
    }

    public void setCreated(ZonedDateTime created) {
        this.created = created;
    }

    public Long getCreatedBy() {
        return this.createdBy;
    }

    public ProductComment createdBy(Long createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Product getProduct() {
        return this.product;
    }

    public ProductComment product(Product product) {
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
        if (!(o instanceof ProductComment)) {
            return false;
        }
        return id != null && id.equals(((ProductComment) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ProductComment{" +
            "id=" + getId() +
            ", description='" + getDescription() + "'" +
            ", created='" + getCreated() + "'" +
            ", createdBy=" + getCreatedBy() +
            "}";
    }
}
