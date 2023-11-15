package com.example.springbootdocker.external.sample;

import lombok.*;

import java.util.ArrayList;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO {
    public int id;
    public String title;
    public String description;
    public int price;
    public double discountPercentage;
    public double rating;
    public int stock;
    public String brand;
    public String category;
    public String thumbnail;
    public ArrayList<String> images;
}
