package com.hackathon.application.controller.productController;

import com.hackathon.application.dto.productDTO.ProductRequest;
import com.hackathon.application.dto.productDTO.ProductResponse;
import com.hackathon.application.service.productService.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest request) {
        ProductResponse newProduct = productService.createProduct(request);

        return ResponseEntity.ok(newProduct);
    }


    @PostMapping("/update/{id}")
    public ResponseEntity<ProductResponse> updateProduct(@PathVariable Long id, @RequestBody ProductRequest request) {
        ProductResponse updatedProduct = productService.updateProduct(id, request);

        return ResponseEntity.ok(updatedProduct);
    }

    @PostMapping("/delete/${id}")
    public ResponseEntity<ProductResponse> deleteProduct(@PathVariable Long id) {
        ProductResponse deletedProduct = productService.deleteProductById(id);

        return ResponseEntity.ok(deletedProduct);
    }

    @PatchMapping("/getById/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable Long id) {
        ProductResponse product = productService.getProductById(id);

        return ResponseEntity.ok(product);
    }

    @GetMapping("/listAll")
    public ResponseEntity<List<ProductResponse>> listAllProducts() {
        List<ProductResponse> products = productService.listAllProducts();

        return ResponseEntity.ok(products);
    }
}
