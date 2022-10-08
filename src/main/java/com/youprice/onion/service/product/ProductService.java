package com.youprice.onion.service.product;

import com.youprice.onion.dto.product.ProductDTO;
import com.youprice.onion.dto.product.ProductImageDTO;
import com.youprice.onion.entity.product.Product;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {

    Long createProductDTO(ProductDTO productDTO, ProductImageDTO productImageDTO, MultipartFile file);
    List<Product> findAllProductDTO();

    ProductDTO getProductDTO(Long productId);
}
