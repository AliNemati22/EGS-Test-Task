package com.nemati.service;

import com.nemati.model.ProductCategory;
import com.nemati.model.ProductCategory_;
import com.nemati.model.Product_;
import com.nemati.model.dto.ProductCategoryDTO;
import com.nemati.repository.ProductCategoryRepository;
import com.nemati.service.criteria.ProductCategoryCriteria;
import com.nemati.service.mapper.ProductCategoryMapper;
import com.nemati.utils.jpa.QueryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.JoinType;
import java.util.List;

/**
 * Service for executing complex queries for {@link ProductCategory} entities in the database.
 * The main input is a {@link ProductCategoryCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link ProductCategoryDTO} or a {@link Page} of {@link ProductCategoryDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class ProductCategoryQueryService extends QueryService<ProductCategory> {

    private final Logger log = LoggerFactory.getLogger(ProductCategoryQueryService.class);

    private final ProductCategoryRepository productCategoryRepository;

    private final ProductCategoryMapper productCategoryMapper;

    public ProductCategoryQueryService(ProductCategoryRepository productCategoryRepository, ProductCategoryMapper productCategoryMapper) {
        this.productCategoryRepository = productCategoryRepository;
        this.productCategoryMapper = productCategoryMapper;
    }

    /**
     * Return a {@link List} of {@link ProductCategoryDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<ProductCategoryDTO> findByCriteria(ProductCategoryCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<ProductCategory> specification = createSpecification(criteria);
        return productCategoryMapper.toDto(productCategoryRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link ProductCategoryDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<ProductCategoryDTO> findByCriteria(ProductCategoryCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<ProductCategory> specification = createSpecification(criteria);
        return productCategoryRepository.findAll(specification, page).map(productCategoryMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(ProductCategoryCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<ProductCategory> specification = createSpecification(criteria);
        return productCategoryRepository.count(specification);
    }

    /**
     * Function to convert {@link ProductCategoryCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<ProductCategory> createSpecification(ProductCategoryCriteria criteria) {
        Specification<ProductCategory> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), ProductCategory_.id));
            }
            if (criteria.getCategoryName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCategoryName(), ProductCategory_.categoryName));
            }
            if (criteria.getDescription() != null) {
                specification = specification.and(buildStringSpecification(criteria.getDescription(), ProductCategory_.description));
            }
            if (criteria.getCreated() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getCreated(), ProductCategory_.created));
            }
            if (criteria.getCreatedBy() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getCreatedBy(), ProductCategory_.createdBy));
            }
            if (criteria.getArticleId() != null) {
                specification =
                    specification.and(
                        buildSpecification(
                            criteria.getArticleId(),
                            root -> root.join(ProductCategory_.articles, JoinType.LEFT).get(Product_.id)
                        )
                    );
            }
        }
        return specification;
    }
}
