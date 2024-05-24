package org.example.repository;

import org.example.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    <T> Optional<T> findById(Long id);

    void deleteById(Long id);

//   @Query(value ="SELECT * ")
//    @Query("select new org.example.dto.ProductDTO(p.name,p.price) from Product p where p.id=?1")
//    public Product getproductsById(long id);
//    public Product getProductsById(long id);
//   @Query
//   Product findProductById(long id);
}
