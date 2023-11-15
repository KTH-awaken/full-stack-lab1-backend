package com.example.springbootdocker.external.ConditionExternal;


import com.example.springbootdocker.external.ConditionExternal.ConditionExternal;
import com.example.springbootdocker.external.ConditionExternal.sub.Entry;
import com.example.springbootdocker.external.ConditionExternal.sub.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ExternalConditionService {

    public List<ConditionExternal> processConditions(Root conditions) {
        List<ConditionExternal> conditionExternals = new ArrayList<>();

        for (Entry entry : conditions.getEntry()) {
            String patient = entry.getResource().getSubject().getReference();
            String date = entry.getResource().getOnsetDateTime();
            String diagnosis = entry.getResource().getCode().getCoding().get(0).getDisplay();

            ConditionExternal cons = new ConditionExternal(patient, diagnosis, date);
            conditionExternals.add(cons);
        }

        return conditionExternals;
    }
}
