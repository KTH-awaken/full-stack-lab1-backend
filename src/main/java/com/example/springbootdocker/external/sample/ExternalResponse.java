package com.example.springbootdocker.external.sample;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExternalResponse {
    private ProductDTO[] products;
    private int total;
    private  int skip;
    private int limit;
}
