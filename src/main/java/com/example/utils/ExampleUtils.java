package com.example.utils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: Example 工具类
 * @author: Mr.Eight
 * @date: 5.7
 **/
public class ExampleUtils {
    /**
     * 构造 Example 动态添加查询条件
     * @param builder CriteriaBuilder对象
     * @param root Root对象
     * @param o 查询对象
     * @return 查询条件列表
     */
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
