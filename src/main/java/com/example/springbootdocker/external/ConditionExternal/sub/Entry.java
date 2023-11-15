package com.example.springbootdocker.external.ConditionExternal.sub;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Entry {
    public String fullUrl;
    public Resource resource;
    public Search search;
}
