package com.numetry.in.repository;

import com.numetry.in.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    @Query("SELECT p FROM Product p WHERE " +
            "p.name LIKE CONCAT('%',:query,'%')" +
            " Or p.description LIKE CONCAT('%', :query,'%')"
    )
    List<Product> searchProducts(String query);

//we can use this also
//    @Query(value = "SELECT * FROM products p WHERE " +
//            "p.name LIKE CONCAT('%',:query,'%')"+
//            " Or p.description LIKE CONCAT('%',query,'%')",nativeQuery = true)
//
//    List<Product> searchProductsSQL(String query);
//}


    /**Returns a products whose dataCtrated between start data and end date
     * param startDate
     * @param endDate
     * return
     */
    List<Product> findByDateCreatedBetween(LocalDateTime startDate,LocalDateTime endDate);
}
