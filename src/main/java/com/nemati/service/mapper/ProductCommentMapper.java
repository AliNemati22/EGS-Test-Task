package com.nemati.service.mapper;

import com.nemati.model.ProductComment;
import com.nemati.model.dto.ProductCommentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { ProductMapper.class })
public interface ProductCommentMapper extends EntityMapper<ProductCommentDTO, ProductComment> {
    @Mapping(target = "product", source = "product", qualifiedByName = "id")
    ProductCommentDTO toDto(ProductComment s);
}
