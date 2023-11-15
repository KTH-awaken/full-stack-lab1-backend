package com.example.springbootdocker.external.ConditionExternal.sub;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Resource {
    public String resourceType;
    public String id;
    public Meta meta;
    public ClinicalStatus clinicalStatus;
    public Code code;
    public Subject subject;
    public String onsetDateTime;
}
