package org.example.dto;

import org.example.dto.ProductDTO;
import org.example.entity.Product;

public class ProductMapper {

    public static ProductDTO mapToProductDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setPrice(product.getPrice());
        return productDTO;
    }
}
