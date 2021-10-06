package com.arrisdev.productservice.repository;

import com.arrisdev.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**developed by
 * arris manduma
 * on 10/6/2021
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
