package com.nemati.controller;

import com.nemati.model.ProductReview;
import com.nemati.model.dto.ProductReviewDTO;
import com.nemati.repository.ProductReviewRepository;
import com.nemati.service.ProductReviewQueryService;
import com.nemati.service.ProductReviewService;
import com.nemati.service.criteria.ProductReviewCriteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * REST controller for managing {@link ProductReview}.
 */
@RestController
@RequestMapping("/api")
public class ProductReviewResource {

    private final Logger log = LoggerFactory.getLogger(ProductReviewResource.class);

    private final ProductReviewService productReviewService;

    private final ProductReviewRepository productReviewRepository;

    private final ProductReviewQueryService productReviewQueryService;

    public ProductReviewResource(
            ProductReviewService productReviewService,
            ProductReviewRepository productReviewRepository,
            ProductReviewQueryService productReviewQueryService
    ) {
        this.productReviewService = productReviewService;
        this.productReviewRepository = productReviewRepository;
        this.productReviewQueryService = productReviewQueryService;
    }

    /**
     * {@code POST  /product-reviews} : Create a new productReview.
     *
     * @param productReviewDTO the productReviewDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new productReviewDTO, or with status {@code 400 (Bad Request)} if the productReview has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/product-reviews")
    public ResponseEntity<ProductReviewDTO> createProductReview(@RequestBody ProductReviewDTO productReviewDTO) throws URISyntaxException {
        log.debug("REST request to save ProductReview : {}", productReviewDTO);
        if (productReviewDTO.getRate() > 5 && productReviewDTO.getRate() < 0)
            ResponseEntity.badRequest();

        if (productReviewDTO.getId() != null) {
            ResponseEntity.notFound();
        }
        ProductReviewDTO result = productReviewService.save(productReviewDTO);
        return ResponseEntity
                .created(new URI("/api/product-reviews/" + result.getId()))
                .body(result);
    }

    /**
     * {@code PUT  /product-reviews/:id} : Updates an existing productReview.
     *
     * @param id               the id of the productReviewDTO to save.
     * @param productReviewDTO the productReviewDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated productReviewDTO,
     * or with status {@code 400 (Bad Request)} if the productReviewDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the productReviewDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/product-reviews/{id}")
    public ResponseEntity<ProductReviewDTO> updateProductReview(
            @PathVariable(value = "id", required = false) final Long id,
            @RequestBody ProductReviewDTO productReviewDTO
    ) throws URISyntaxException {
        log.debug("REST request to update ProductReview : {}, {}", id, productReviewDTO);
        if (productReviewDTO.getId() == null) {
            ResponseEntity.notFound();
        }
        if (!Objects.equals(id, productReviewDTO.getId())) {
            ResponseEntity.notFound();
        }

        if (!productReviewRepository.existsById(id)) {
            ResponseEntity.notFound();
        }

        ProductReviewDTO result = productReviewService.save(productReviewDTO);
        return ResponseEntity
                .ok()
                .body(result);
    }

    /**
     * {@code PATCH  /product-reviews/:id} : Partial updates given fields of an existing productReview, field will ignore if it is null
     *
     * @param id               the id of the productReviewDTO to save.
     * @param productReviewDTO the productReviewDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated productReviewDTO,
     * or with status {@code 400 (Bad Request)} if the productReviewDTO is not valid,
     * or with status {@code 404 (Not Found)} if the productReviewDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the productReviewDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/product-reviews/{id}", consumes = "application/merge-patch+json")
    public ResponseEntity<ProductReviewDTO> partialUpdateProductReview(
            @PathVariable(value = "id", required = false) final Long id,
            @RequestBody ProductReviewDTO productReviewDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update ProductReview partially : {}, {}", id, productReviewDTO);
        if (productReviewDTO.getId() == null) {
            ResponseEntity.notFound();
        }
        if (!Objects.equals(id, productReviewDTO.getId())) {
            ResponseEntity.notFound();
        }

        if (!productReviewRepository.existsById(id)) {
            ResponseEntity.notFound();
        }

        Optional<ProductReviewDTO> result = productReviewService.partialUpdate(productReviewDTO);

        return ResponseEntity.ok(result.get());
    }

    /**
     * {@code GET  /product-reviews} : get all the productReviews.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of productReviews in body.
     */
    @GetMapping("/product-reviews")
    public ResponseEntity<List<ProductReviewDTO>> getAllProductReviews(ProductReviewCriteria criteria) {
        log.debug("REST request to get ProductReviews by criteria: {}", criteria);
        List<ProductReviewDTO> entityList = productReviewQueryService.findByCriteria(criteria);
        return ResponseEntity.ok().body(entityList);
    }

    /**
     * {@code GET  /product-reviews/count} : count all the productReviews.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/product-reviews/count")
    public ResponseEntity<Long> countProductReviews(ProductReviewCriteria criteria) {
        log.debug("REST request to count ProductReviews by criteria: {}", criteria);
        return ResponseEntity.ok().body(productReviewQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /product-reviews/:id} : get the "id" productReview.
     *
     * @param id the id of the productReviewDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the productReviewDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/product-reviews/{id}")
    public ResponseEntity<ProductReviewDTO> getProductReview(@PathVariable Long id) {
        log.debug("REST request to get ProductReview : {}", id);
        Optional<ProductReviewDTO> productReviewDTO = productReviewService.findOne(id);
        return ResponseEntity.ok(productReviewDTO.get());
    }

    /**
     * {@code DELETE  /product-reviews/:id} : delete the "id" productReview.
     *
     * @param id the id of the productReviewDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/product-reviews/{id}")
    public ResponseEntity<Void> deleteProductReview(@PathVariable Long id) {
        log.debug("REST request to delete ProductReview : {}", id);
        productReviewService.delete(id);
        return ResponseEntity
                .noContent()
                .build();
    }
}
