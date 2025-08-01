package com.example.springcloudapp.Services;


import com.example.springcloudapp.Dtos.FakeStoreProductDto;
import com.example.springcloudapp.Models.Category;
import com.example.springcloudapp.Models.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class FakeStoreProductService implements ProductService {

    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getSingleProduct(Long id) {

        ResponseEntity <FakeStoreProductDto> responseEntity= restTemplate.getForEntity(
                "http://fakestoreapi.com/products/" +id, FakeStoreProductDto.class);

        


        FakeStoreProductDto fakeStoreProductDto = responseEntity.getBody();
        return fakeStoreProductDto.toProduct();

    }

    @Override
    public Product createProduct(String title, String description, Double price, String category, String image) {

        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setTitle(title);
        fakeStoreProductDto.setDescription(description);
        fakeStoreProductDto.setPrice(price);
        fakeStoreProductDto.setCategory(category);
        fakeStoreProductDto.setImage(image);


        FakeStoreProductDto response = restTemplate.postForObject("https://fakestoreapi.com/products",
                fakeStoreProductDto, FakeStoreProductDto.class);

        return response.toProduct();

    }

    @Override
    public List<Product> getAllProducts() {

        FakeStoreProductDto[] response = restTemplate.getForObject("https://fakestoreapi.com/products",
                FakeStoreProductDto[].class);

        List<Product> products = new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto : response) {
            products.add(fakeStoreProductDto.toProduct());
        }
        return products;
    }
}
