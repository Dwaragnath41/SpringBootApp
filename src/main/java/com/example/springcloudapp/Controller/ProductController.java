package com.example.springcloudapp.Controller;


import com.example.springcloudapp.Dtos.CreateProductRequestDto;
import com.example.springcloudapp.Models.Product;
import com.example.springcloudapp.Services.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public void getAllProducts(){

    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable("id") Long id){

        return productService.getSingleProduct(id);

    }

    public void deleteProductById(Long id){


    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody CreateProductRequestDto createProductRequestDto){

        return productService.createProduct(
                createProductRequestDto.getTitle(),
                createProductRequestDto.getDescription(),
                createProductRequestDto.getPrice(),
                createProductRequestDto.getImage(),
                createProductRequestDto.getCategory()

        );
        
    }




}
