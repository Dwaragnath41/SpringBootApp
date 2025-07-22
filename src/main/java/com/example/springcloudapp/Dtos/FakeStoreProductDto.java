package com.example.springcloudapp.Dtos;


import com.example.springcloudapp.Models.Category;
import com.example.springcloudapp.Models.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class FakeStoreProductDto {

    private Long id;

    private String title;

    private String description;

    private double price;

    private String category;

    private String image;


    public Product toProduct(){

        Product product = new Product();

        product.setId(getId());
        product.setTitle(getTitle());
        product.setDescription(getDescription());
        product.setPrice(getPrice());
        product.setImageUrl(getImage());

        Category category = new Category();
        category.setTitle(getCategory());
        product.setCategory(category);

        return product;

    }


}
