package com.nemati.controller;


import com.nemati.model.ProductCategory;
import com.nemati.model.dto.ProductCategoryDTO;
import com.nemati.repository.ProductCategoryRepository;
import com.nemati.service.ProductCategoryQueryService;
import com.nemati.service.ProductCategoryService;
import com.nemati.service.criteria.ProductCategoryCriteria;
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
 * REST controller for managing {@link ProductCategory}.
 */
@RestController
@RequestMapping("/api")
public class ProductCategoryResource {

    private final Logger log = LoggerFactory.getLogger(ProductCategoryResource.class);

    private final ProductCategoryService productCategoryService;

    private final ProductCategoryRepository productCategoryRepository;

    private final ProductCategoryQueryService productCategoryQueryService;

    public ProductCategoryResource(
        ProductCategoryService productCategoryService,
        ProductCategoryRepository productCategoryRepository,
        ProductCategoryQueryService productCategoryQueryService
    ) {
        this.productCategoryService = productCategoryService;
        this.productCategoryRepository = productCategoryRepository;
        this.productCategoryQueryService = productCategoryQueryService;
    }

    /**
     * {@code POST  /product-categories} : Create a new productCategory.
     *
     * @param productCategoryDTO the productCategoryDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new productCategoryDTO, or with status {@code 400 (Bad Request)} if the productCategory has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/product-categories")
    public ResponseEntity<ProductCategoryDTO> createProductCategory(@RequestBody ProductCategoryDTO productCategoryDTO)
        throws URISyntaxException {
        log.debug("REST request to save ProductCategory : {}", productCategoryDTO);
        if (productCategoryDTO.getId() != null) {
           return ResponseEntity.ok(new ProductCategoryDTO());
        }
        ProductCategoryDTO result = productCategoryService.save(productCategoryDTO);
        return ResponseEntity
            .created(new URI("/api/product-categories/" + result.getId()))
            .body(result);
    }

    /**
     * {@code PUT  /product-categories/:id} : Updates an existing productCategory.
     *
     * @param id the id of the productCategoryDTO to save.
     * @param productCategoryDTO the productCategoryDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated productCategoryDTO,
     * or with status {@code 400 (Bad Request)} if the productCategoryDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the productCategoryDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/product-categories/{id}")
    public ResponseEntity<ProductCategoryDTO> updateProductCategory(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody ProductCategoryDTO productCategoryDTO
    ) throws URISyntaxException {
        log.debug("REST request to update ProductCategory : {}, {}", id, productCategoryDTO);
        if (productCategoryDTO.getId() == null) {
            return ResponseEntity.ok(new ProductCategoryDTO());
        }
        if (!Objects.equals(id, productCategoryDTO.getId())) {
            return ResponseEntity.ok(new ProductCategoryDTO());
        }
        if (!productCategoryRepository.existsById(id)) {
            return ResponseEntity.ok(new ProductCategoryDTO());
        }

        ProductCategoryDTO result = productCategoryService.save(productCategoryDTO);
        return ResponseEntity
            .ok()
            .body(result);
    }

    /**
     * {@code PATCH  /product-categories/:id} : Partial updates given fields of an existing productCategory, field will ignore if it is null
     *
     * @param id the id of the productCategoryDTO to save.
     * @param productCategoryDTO the productCategoryDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated productCategoryDTO,
     * or with status {@code 400 (Bad Request)} if the productCategoryDTO is not valid,
     * or with status {@code 404 (Not Found)} if the productCategoryDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the productCategoryDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/product-categories/{id}", consumes = "application/merge-patch+json")
    public ResponseEntity<ProductCategoryDTO> partialUpdateProductCategory(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody ProductCategoryDTO productCategoryDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update ProductCategory partially : {}, {}", id, productCategoryDTO);
        if (productCategoryDTO.getId() == null) {
            return ResponseEntity.ok(new ProductCategoryDTO());
        }
        if (!Objects.equals(id, productCategoryDTO.getId())) {
            return ResponseEntity.ok(new ProductCategoryDTO());
        }

        if (!productCategoryRepository.existsById(id)) {
            return ResponseEntity.ok(new ProductCategoryDTO());
        }

        Optional<ProductCategoryDTO> result = productCategoryService.partialUpdate(productCategoryDTO);
        return ResponseEntity.ok(result.get());
    }

    /**
     * {@code GET  /product-categories} : get all the productCategories.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of productCategories in body.
     */
    @GetMapping("/product-categories")
    public ResponseEntity<List<ProductCategoryDTO>> getAllProductCategories(ProductCategoryCriteria criteria) {
        log.debug("REST request to get ProductCategories by criteria: {}", criteria);
        List<ProductCategoryDTO> entityList = productCategoryQueryService.findByCriteria(criteria);
        return ResponseEntity.ok().body(entityList);
    }

    /**
     * {@code GET  /product-categories/count} : count all the productCategories.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/product-categories/count")
    public ResponseEntity<Long> countProductCategories(ProductCategoryCriteria criteria) {
        log.debug("REST request to count ProductCategories by criteria: {}", criteria);
        return ResponseEntity.ok().body(productCategoryQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /product-categories/:id} : get the "id" productCategory.
     *
     * @param id the id of the productCategoryDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the productCategoryDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/product-categories/{id}")
    public ResponseEntity<ProductCategoryDTO> getProductCategory(@PathVariable Long id) {
        log.debug("REST request to get ProductCategory : {}", id);
        Optional<ProductCategoryDTO> productCategoryDTO = productCategoryService.findOne(id);
        return ResponseEntity.ok(productCategoryDTO.get());
    }

    /**
     * {@code DELETE  /product-categories/:id} : delete the "id" productCategory.
     *
     * @param id the id of the productCategoryDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/product-categories/{id}")
    public ResponseEntity<Void> deleteProductCategory(@PathVariable Long id) {
        log.debug("REST request to delete ProductCategory : {}", id);
        productCategoryService.delete(id);
        return ResponseEntity
            .noContent()
            .build();
    }
}
