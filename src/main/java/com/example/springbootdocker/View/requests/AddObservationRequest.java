package com.example.springbootdocker.View.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddObservationRequest {

    private String content;
    private int encounterId;
}
