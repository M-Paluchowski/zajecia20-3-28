package com.example.demo.examples.springdata.repository;

import com.example.demo.examples.springdata.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByAvailable(boolean available);

    @Query("SELECT p FROM Product p WHERE p.name = :productName")
    List<Product> getProductsWithName(@Param("productName") String name);

    @Query("SELECT p FROM Product p " +
            "WHERE p.price = :price " +
            "AND p.name LIKE CONCAT(:name, '%')")
    List<Product> getProductsWithNameAndPrice(@Param("name") String nameLike, @Param("price") Double price);

    @Query(value = "SELECT * FROM product " +
            "WHERE price = :price " +
            "AND name LIKE :name%", nativeQuery = true)
    List<Product> getProductsWithNameAndPriceNative(@Param("name") String nameLike, @Param("price") Double price);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM product WHERE name LIKE :name%", nativeQuery = true)
    void deleteProductWithNameLike(@Param("name") String nameLike);
}
