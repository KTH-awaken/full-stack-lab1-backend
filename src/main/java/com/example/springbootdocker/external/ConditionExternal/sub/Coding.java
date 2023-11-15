package com.example.springbootdocker.external.ConditionExternal.sub;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Coding {
    public String system;
    public String code;
    public String display;
}
