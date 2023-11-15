//package com.example.springbootdocker.external.sample;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.reactive.function.client.WebClient;
//import reactor.core.publisher.Mono;
//
//@RestController
//@RequiredArgsConstructor
//public class ExternalController {
//    private final  WebClient.Builder webClientBuilder;
//    private final RestTemplate restTemplate;
//    @GetMapping("/external-non-blocking")
//    public Mono<ExternalResponse> getProductsNonBlocking() {
//
//            String url = "https://dummyjson.com/products";
//            return webClientBuilder.build()
//                    .get()
//                    .uri(url)
//                    .retrieve()
//                    .bodyToMono(ExternalResponse.class);
//
//    }
//
//    @GetMapping("/external-blocking")
//    public ResponseEntity<ExternalResponse> getProductsBlocking() {
//
//        String url = "https://dummyjson.com/products";
//        ResponseEntity<ExternalResponse> response = restTemplate.getForEntity(url, ExternalResponse.class);
//        ExternalResponse productDTOs = response.getBody();
//        return ResponseEntity.ok( productDTOs);
//
//    }
//
//}
