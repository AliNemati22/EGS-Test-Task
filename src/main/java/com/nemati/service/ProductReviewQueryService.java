package com.nemati.service;

import com.nemati.model.ProductReview;
import com.nemati.model.ProductReview_;
import com.nemati.model.Product_;
import com.nemati.model.dto.ProductReviewDTO;
import com.nemati.repository.ProductReviewRepository;
import com.nemati.service.criteria.ProductReviewCriteria;
import com.nemati.service.mapper.ProductReviewMapper;
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
 * Service for executing complex queries for {@link ProductReview} entities in the database.
 * The main input is a {@link ProductReviewCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link ProductReviewDTO} or a {@link Page} of {@link ProductReviewDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class ProductReviewQueryService extends QueryService<ProductReview> {

    private final Logger log = LoggerFactory.getLogger(ProductReviewQueryService.class);

    private final ProductReviewRepository productReviewRepository;

    private final ProductReviewMapper productReviewMapper;

    public ProductReviewQueryService(ProductReviewRepository productReviewRepository, ProductReviewMapper productReviewMapper) {
        this.productReviewRepository = productReviewRepository;
        this.productReviewMapper = productReviewMapper;
    }

    /**
     * Return a {@link List} of {@link ProductReviewDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<ProductReviewDTO> findByCriteria(ProductReviewCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<ProductReview> specification = createSpecification(criteria);
        return productReviewMapper.toDto(productReviewRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link ProductReviewDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<ProductReviewDTO> findByCriteria(ProductReviewCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<ProductReview> specification = createSpecification(criteria);
        return productReviewRepository.findAll(specification, page).map(productReviewMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(ProductReviewCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<ProductReview> specification = createSpecification(criteria);
        return productReviewRepository.count(specification);
    }

    /**
     * Function to convert {@link ProductReviewCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<ProductReview> createSpecification(ProductReviewCriteria criteria) {
        Specification<ProductReview> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), ProductReview_.id));
            }
            if (criteria.getRate() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getRate(), ProductReview_.rate));
            }
            if (criteria.getCreated() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getCreated(), ProductReview_.created));
            }
            if (criteria.getCreatedBy() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getCreatedBy(), ProductReview_.createdBy));
            }
            if (criteria.getProductId() != null) {
                specification =
                    specification.and(
                        buildSpecification(
                            criteria.getProductId(),
                            root -> root.join(ProductReview_.product, JoinType.LEFT).get(Product_.id)
                        )
                    );
            }
        }
        return specification;
    }
}
