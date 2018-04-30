package com.example.utils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ExampleUtils {
    public static List<Predicate> Example(CriteriaBuilder builder, Root<?> root, Object o) {
        List<Predicate> predicateList = new ArrayList<>();
        Class<?> clazz = o.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            try {
                String fieldName = field.getName();
                PropertyDescriptor descriptor = new PropertyDescriptor(fieldName, clazz);
                Method method = descriptor.getReadMethod();
                Object value = method.invoke(o);
                if (value != null && !"".equals(value)){
                    predicateList.add(builder.equal(root.get(fieldName), value));
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return predicateList;
    }
}
