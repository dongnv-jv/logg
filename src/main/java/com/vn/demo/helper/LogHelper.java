package com.vn.demo.helper;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Data
public class LogHelper {

    private ThreadLocal<Long> id = new ThreadLocal<>();
    private ThreadLocal<Map<String, List<Object>>> differenceField = ThreadLocal.withInitial(HashMap::new);
    private ThreadLocal<Map<String,Map<String, List<Object>>>> differenceFieldLst = ThreadLocal.withInitial(HashMap::new);

    public Map<String, List<Object>> getDifferenceField() {
        return differenceField.get();
    }

    public Map<String,Map<String, List<Object>>> getDifferenceFieldLst() {
        return differenceFieldLst.get();
    }

    public void setDifferenceField(Map<String, List<Object>> diff) {
        differenceField.set(diff);
    }
    public void setDifferenceFieldLst(Map<String,Map<String, List<Object>>> diff) {
        differenceFieldLst.set(diff);
    }
    public void setDifferenceFieldLst(String id, Map<String, List<Object>> map) {
        Map<String,Map<String, List<Object>>> diff = differenceFieldLst.get();
        diff.put(id, map);
        differenceFieldLst.set(diff);
    }

    public void setId(Long id) {
        this.id.set(id);
    }

    public Long getId() {
        return id.get();
    }

    public void clear() {
        id.remove();
        differenceField.get().clear();
        differenceField.remove();
    }

}
