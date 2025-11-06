package com.hackathon.application.service.productService;

import com.hackathon.application.dto.productDTO.ProductRequest;
import com.hackathon.application.dto.productDTO.ProductResponse;
import com.hackathon.application.entity.productEntity.Product;
import com.hackathon.application.repository.productRepository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ProductResponse createProduct(ProductRequest productRequest){
        if(Objects.isNull(productRequest)){
            throw new IllegalArgumentException("Há campos obrigatórios não preenchidos");
        }

        Product newProduct = Product.builder()
                .name(productRequest.name())
                .description(productRequest.description())
                .price(productRequest.price())
                .build();

        productRepository.save(newProduct);
        return new ProductResponse(newProduct.getId(), newProduct.getName(), newProduct.getDescription(), newProduct.getPrice());
    }

    public ProductResponse getProductById(Long productId){
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));
        return new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice());
    }

    public List<ProductResponse> listAllProducts() {
        return productRepository.findAll().stream().map(product ->
                new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice())
        ).toList();
    }

    public ProductResponse deleteProductById(Long productId){
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));
        productRepository.deleteById(productId);
        return new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice());
    }

    public ProductResponse updateProduct(Long productId, ProductRequest productRequest){

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));

        if(Objects.nonNull(productRequest.name()))
            product.setName(productRequest.name());


        if(Objects.nonNull(productRequest.description()))
            product.setDescription(productRequest.description());

        if(Objects.nonNull(productRequest.price()))
            product.setPrice(productRequest.price());


        productRepository.save(product);

        return new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice());
    }
}
