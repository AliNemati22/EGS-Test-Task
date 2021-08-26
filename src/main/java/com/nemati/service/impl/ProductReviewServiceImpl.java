package com.nemati.service.impl;

import com.nemati.model.ProductReview;
import com.nemati.model.dto.ProductReviewDTO;
import com.nemati.repository.ProductReviewRepository;
import com.nemati.service.ProductReviewService;
import com.nemati.service.mapper.ProductReviewMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link ProductReview}.
 */
@Service
@Transactional
public class ProductReviewServiceImpl implements ProductReviewService {

    private final Logger log = LoggerFactory.getLogger(ProductReviewServiceImpl.class);

    private final ProductReviewRepository productReviewRepository;

    private final ProductReviewMapper productReviewMapper;

    public ProductReviewServiceImpl(ProductReviewRepository productReviewRepository, ProductReviewMapper productReviewMapper) {
        this.productReviewRepository = productReviewRepository;
        this.productReviewMapper = productReviewMapper;
    }

    @Override
    public ProductReviewDTO save(ProductReviewDTO productReviewDTO) {
        log.debug("Request to save ProductReview : {}", productReviewDTO);
        ProductReview productReview = productReviewMapper.toEntity(productReviewDTO);
        productReview = productReviewRepository.save(productReview);
        return productReviewMapper.toDto(productReview);
    }

    @Override
    public Optional<ProductReviewDTO> partialUpdate(ProductReviewDTO productReviewDTO) {
        log.debug("Request to partially update ProductReview : {}", productReviewDTO);

        return productReviewRepository
            .findById(productReviewDTO.getId())
            .map(
                existingProductReview -> {
                    productReviewMapper.partialUpdate(existingProductReview, productReviewDTO);

                    return existingProductReview;
                }
            )
            .map(productReviewRepository::save)
            .map(productReviewMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductReviewDTO> findAll() {
        log.debug("Request to get all ProductReviews");
        return productReviewRepository.findAll().stream().map(productReviewMapper::toDto).collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ProductReviewDTO> findOne(Long id) {
        log.debug("Request to get ProductReview : {}", id);
        return productReviewRepository.findById(id).map(productReviewMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete ProductReview : {}", id);
        productReviewRepository.deleteById(id);
    }
}
