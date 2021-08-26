package com.nemati.service.impl;

import com.nemati.model.ProductComment;
import com.nemati.model.dto.ProductCommentDTO;
import com.nemati.repository.ProductCommentRepository;
import com.nemati.service.ProductCommentService;
import com.nemati.service.mapper.ProductCommentMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link ProductComment}.
 */
@Service
@Transactional
public class ProductCommentServiceImpl implements ProductCommentService {

    private final Logger log = LoggerFactory.getLogger(ProductCommentServiceImpl.class);

    private final ProductCommentRepository productCommentRepository;

    private final ProductCommentMapper productCommentMapper;

    public ProductCommentServiceImpl(ProductCommentRepository productCommentRepository, ProductCommentMapper productCommentMapper) {
        this.productCommentRepository = productCommentRepository;
        this.productCommentMapper = productCommentMapper;
    }

    @Override
    public ProductCommentDTO save(ProductCommentDTO productCommentDTO) {
        log.debug("Request to save ProductComment : {}", productCommentDTO);
        ProductComment productComment = productCommentMapper.toEntity(productCommentDTO);
        productComment = productCommentRepository.save(productComment);
        return productCommentMapper.toDto(productComment);
    }

    @Override
    public Optional<ProductCommentDTO> partialUpdate(ProductCommentDTO productCommentDTO) {
        log.debug("Request to partially update ProductComment : {}", productCommentDTO);

        return productCommentRepository
            .findById(productCommentDTO.getId())
            .map(
                existingProductComment -> {
                    productCommentMapper.partialUpdate(existingProductComment, productCommentDTO);

                    return existingProductComment;
                }
            )
            .map(productCommentRepository::save)
            .map(productCommentMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductCommentDTO> findAll() {
        log.debug("Request to get all ProductComments");
        return productCommentRepository
            .findAll()
            .stream()
            .map(productCommentMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ProductCommentDTO> findOne(Long id) {
        log.debug("Request to get ProductComment : {}", id);
        return productCommentRepository.findById(id).map(productCommentMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete ProductComment : {}", id);
        productCommentRepository.deleteById(id);
    }
}
