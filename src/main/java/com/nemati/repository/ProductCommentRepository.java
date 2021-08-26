package com.nemati.repository;

import com.nemati.model.ProductComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the ProductComment entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ProductCommentRepository extends JpaRepository<ProductComment, Long>, JpaSpecificationExecutor<ProductComment> {}
