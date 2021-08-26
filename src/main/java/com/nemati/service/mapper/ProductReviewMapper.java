package com.nemati.service.mapper;


import com.nemati.model.ProductReview;
import com.nemati.model.dto.ProductReviewDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper for the entity {@link ProductReview} and its DTO {@link ProductReviewDTO}.
 */
@Mapper(componentModel = "spring", uses = { ProductMapper.class })
public interface ProductReviewMapper extends EntityMapper<ProductReviewDTO, ProductReview> {
    @Mapping(target = "product", source = "product", qualifiedByName = "id")
    ProductReviewDTO toDto(ProductReview s);
}
