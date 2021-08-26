package com.nemati.service;


import com.nemati.model.dto.ProductCommentDTO;

import java.util.List;
import java.util.Optional;

public interface ProductCommentService {
    /**
     * Save a productComment.
     *
     * @param productCommentDTO the entity to save.
     * @return the persisted entity.
     */
    ProductCommentDTO save(ProductCommentDTO productCommentDTO);

    /**
     * Partially updates a productComment.
     *
     * @param productCommentDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<ProductCommentDTO> partialUpdate(ProductCommentDTO productCommentDTO);

    /**
     * Get all the productComments.
     *
     * @return the list of entities.
     */
    List<ProductCommentDTO> findAll();

    /**
     * Get the "id" productComment.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ProductCommentDTO> findOne(Long id);

    /**
     * Delete the "id" productComment.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
