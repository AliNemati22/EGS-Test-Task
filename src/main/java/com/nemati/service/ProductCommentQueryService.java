package com.nemati.service;

import com.nemati.model.ProductComment;
import com.nemati.model.ProductComment_;
import com.nemati.model.Product_;
import com.nemati.model.dto.ProductCommentDTO;
import com.nemati.repository.ProductCommentRepository;
import com.nemati.service.criteria.ProductCommentCriteria;
import com.nemati.service.mapper.ProductCommentMapper;
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
 * Service for executing complex queries for {@link ProductComment} entities in the database.
 * The main input is a {@link ProductCommentCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link ProductCommentDTO} or a {@link Page} of {@link ProductCommentDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class ProductCommentQueryService extends QueryService<ProductComment> {

    private final Logger log = LoggerFactory.getLogger(ProductCommentQueryService.class);

    private final ProductCommentRepository productCommentRepository;

    private final ProductCommentMapper productCommentMapper;

    public ProductCommentQueryService(ProductCommentRepository productCommentRepository, ProductCommentMapper productCommentMapper) {
        this.productCommentRepository = productCommentRepository;
        this.productCommentMapper = productCommentMapper;
    }

    /**
     * Return a {@link List} of {@link ProductCommentDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<ProductCommentDTO> findByCriteria(ProductCommentCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<ProductComment> specification = createSpecification(criteria);
        return productCommentMapper.toDto(productCommentRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link ProductCommentDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<ProductCommentDTO> findByCriteria(ProductCommentCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<ProductComment> specification = createSpecification(criteria);
        return productCommentRepository.findAll(specification, page).map(productCommentMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(ProductCommentCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<ProductComment> specification = createSpecification(criteria);
        return productCommentRepository.count(specification);
    }

    /**
     * Function to convert {@link ProductCommentCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<ProductComment> createSpecification(ProductCommentCriteria criteria) {
        Specification<ProductComment> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), ProductComment_.id));
            }
            if (criteria.getDescription() != null) {
                specification = specification.and(buildSpecification(criteria.getDescription(), ProductComment_.description));
            }
            if (criteria.getCreated() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getCreated(), ProductComment_.created));
            }
            if (criteria.getCreatedBy() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getCreatedBy(), ProductComment_.createdBy));
            }
            if (criteria.getProductId() != null) {
                specification =
                    specification.and(
                        buildSpecification(
                            criteria.getProductId(),
                            root -> root.join(ProductComment_.product, JoinType.LEFT).get(Product_.id)
                        )
                    );
            }
        }
        return specification;
    }
}
