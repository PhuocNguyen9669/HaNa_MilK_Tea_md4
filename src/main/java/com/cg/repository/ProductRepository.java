package com.cg.repository;

import com.cg.model.Product;
import com.cg.model.dto.ProductDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.awt.*;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query ("SELECT new com.cg.model.dto.ProductDTO ( " +
            "p.id, " +
            "p.productName, " +
            "p.category, " +
            "p.quantity, " +
            "p.price, " +
            "p.description, " +
            "p.image, " +
            "p.createdAt, " +
            "p.updatedAt)" +
            "FROM Product AS p WHERE p.deleted = false ")
         List<ProductDTO> findALlProdutDTO();


}
