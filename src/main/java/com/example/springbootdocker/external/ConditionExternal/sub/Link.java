package com.example.springbootdocker.external.ConditionExternal.sub;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Link {
    public String relation;
    public String url;
}
