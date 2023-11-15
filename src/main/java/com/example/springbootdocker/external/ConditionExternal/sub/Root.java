package com.example.springbootdocker.external.ConditionExternal.sub;

import com.example.springbootdocker.external.ConditionExternal.sub.Entry;
import com.example.springbootdocker.external.ConditionExternal.sub.Link;
import com.example.springbootdocker.external.ConditionExternal.sub.Meta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Root {
    public String resourceType;
    public String id;
    public Meta meta;
    public String type;
    public ArrayList<Link> link;
    public ArrayList<Entry> entry;
}

