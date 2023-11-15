package com.example.springbootdocker.external.ConditionExternal.sub;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Meta {
    public Date lastUpdated;
    public String versionId;
    public String source;
}
