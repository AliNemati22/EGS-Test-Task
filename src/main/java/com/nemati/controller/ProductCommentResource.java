package com.nemati.controller;

import com.nemati.model.ProductComment;
import com.nemati.model.dto.ProductCommentDTO;
import com.nemati.repository.ProductCommentRepository;
import com.nemati.service.ProductCommentQueryService;
import com.nemati.service.ProductCommentService;
import com.nemati.service.criteria.ProductCommentCriteria;
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
 * REST controller for managing {@link ProductComment}.
 */
@RestController
@RequestMapping("/api")
public class ProductCommentResource {

    private final Logger log = LoggerFactory.getLogger(ProductCommentResource.class);

    private final ProductCommentService productCommentService;

    private final ProductCommentRepository productCommentRepository;

    private final ProductCommentQueryService productCommentQueryService;

    public ProductCommentResource(
        ProductCommentService productCommentService,
        ProductCommentRepository productCommentRepository,
        ProductCommentQueryService productCommentQueryService
    ) {
        this.productCommentService = productCommentService;
        this.productCommentRepository = productCommentRepository;
        this.productCommentQueryService = productCommentQueryService;
    }

    /**
     * {@code POST  /product-comments} : Create a new productComment.
     *
     * @param productCommentDTO the productCommentDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new productCommentDTO, or with status {@code 400 (Bad Request)} if the productComment has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/product-comments")
    public ResponseEntity<ProductCommentDTO> createProductComment(@RequestBody ProductCommentDTO productCommentDTO)
        throws URISyntaxException {
        log.debug("REST request to save ProductComment : {}", productCommentDTO);
        if (productCommentDTO.getId() != null) {
            ResponseEntity.noContent();
        }
        ProductCommentDTO result = productCommentService.save(productCommentDTO);
        return ResponseEntity
            .created(new URI("/api/product-comments/" + result.getId()))
            .body(result);
    }

    /**
     * {@code PUT  /product-comments/:id} : Updates an existing productComment.
     *
     * @param id the id of the productCommentDTO to save.
     * @param productCommentDTO the productCommentDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated productCommentDTO,
     * or with status {@code 400 (Bad Request)} if the productCommentDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the productCommentDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/product-comments/{id}")
    public ResponseEntity<ProductCommentDTO> updateProductComment(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody ProductCommentDTO productCommentDTO
    ) throws URISyntaxException {
        log.debug("REST request to update ProductComment : {}, {}", id, productCommentDTO);
        if (productCommentDTO.getId() == null) {
            ResponseEntity.noContent();
        }
        if (!Objects.equals(id, productCommentDTO.getId())) {
            ResponseEntity.noContent();
        }

        if (!productCommentRepository.existsById(id)) {
            ResponseEntity.noContent();
        }

        ProductCommentDTO result = productCommentService.save(productCommentDTO);
        return ResponseEntity
            .ok()
            .body(result);
    }

    /**
     * {@code PATCH  /product-comments/:id} : Partial updates given fields of an existing productComment, field will ignore if it is null
     *
     * @param id the id of the productCommentDTO to save.
     * @param productCommentDTO the productCommentDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated productCommentDTO,
     * or with status {@code 400 (Bad Request)} if the productCommentDTO is not valid,
     * or with status {@code 404 (Not Found)} if the productCommentDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the productCommentDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/product-comments/{id}", consumes = "application/merge-patch+json")
    public ResponseEntity<ProductCommentDTO> partialUpdateProductComment(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody ProductCommentDTO productCommentDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update ProductComment partially : {}, {}", id, productCommentDTO);
        if (productCommentDTO.getId() == null) {
            ResponseEntity.noContent();
        }
        if (!Objects.equals(id, productCommentDTO.getId())) {
            ResponseEntity.noContent();
        }

        if (!productCommentRepository.existsById(id)) {
            ResponseEntity.noContent();
        }

        Optional<ProductCommentDTO> result = productCommentService.partialUpdate(productCommentDTO);

        return ResponseEntity.ok(result.get());
    }

    /**
     * {@code GET  /product-comments} : get all the productComments.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of productComments in body.
     */
    @GetMapping("/product-comments")
    public ResponseEntity<List<ProductCommentDTO>> getAllProductComments(ProductCommentCriteria criteria) {
        log.debug("REST request to get ProductComments by criteria: {}", criteria);
        List<ProductCommentDTO> entityList = productCommentQueryService.findByCriteria(criteria);
        return ResponseEntity.ok().body(entityList);
    }

    /**
     * {@code GET  /product-comments/count} : count all the productComments.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/product-comments/count")
    public ResponseEntity<Long> countProductComments(ProductCommentCriteria criteria) {
        log.debug("REST request to count ProductComments by criteria: {}", criteria);
        return ResponseEntity.ok().body(productCommentQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /product-comments/:id} : get the "id" productComment.
     *
     * @param id the id of the productCommentDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the productCommentDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/product-comments/{id}")
    public ResponseEntity<ProductCommentDTO> getProductComment(@PathVariable Long id) {
        log.debug("REST request to get ProductComment : {}", id);
        Optional<ProductCommentDTO> productCommentDTO = productCommentService.findOne(id);
        return ResponseEntity.ok(productCommentDTO.get());
    }

    /**
     * {@code DELETE  /product-comments/:id} : delete the "id" productComment.
     *
     * @param id the id of the productCommentDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/product-comments/{id}")
    public ResponseEntity<Void> deleteProductComment(@PathVariable Long id) {
        log.debug("REST request to delete ProductComment : {}", id);
        productCommentService.delete(id);
        return ResponseEntity
            .noContent()
            .build();
    }
}
