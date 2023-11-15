package com.example.springbootdocker.external.ConditionExternal;

import com.example.springbootdocker.external.ConditionExternal.sub.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ExternalConditionController {
    private final RestTemplate restTemplate;
    private final ExternalConditionService conditionService;

    @GetMapping("/external-condition-blocking")
    public ResponseEntity<List<ConditionExternal>> getProductsBlocking() {
        String url = "http://hapi.fhir.org/baseR4/Condition?_include=Condition:encounter&_count=2&_format=json&_pretty=true";
        ResponseEntity<Root> response = restTemplate.getForEntity(url, Root.class);
        Root conditions = response.getBody();
        List<ConditionExternal> res = conditionService.processConditions(conditions);
        return ResponseEntity.ok( res);

    }

}
