package com.programming.cultivation.poi.common.reflect;

import com.programming.cultivation.base.Book;
import com.programming.cultivation.poi.MetaData;
import com.programming.cultivation.poi.common.ClassTypeEnum;
import com.programming.cultivation.poi.common.anno.Excel;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @author biyue
 * @since 2020/01/10
 */
public class Reflector {

    private static final String GET = "get";

    public static void main(String[] args) {
        List<MetaData> analysis = analysis(Book.class);
        analysis.stream().forEach(item -> System.out.println(item));

        MetaData metaData = analysis.get(0);
        Book book = new Book(1, "锦鲤");
        try {
            Object value = metaData.getMethod().invoke(book, null);

            System.out.println(value);

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }

    public static List<MetaData> analysis(Class clazz) {
        Method[] declaredMethods = clazz.getDeclaredMethods();
        Map<String, Method> methodMap = new HashMap<>();
        for (Method method : declaredMethods) {
            methodMap.put(method.getName().toLowerCase(), method);
        }
        Field[] declaredFields = clazz.getDeclaredFields();
        List<MetaData> metaDataList = new ArrayList<>();
        for (Field field : declaredFields) {
            Excel declaredAnnotation = field.getDeclaredAnnotation(Excel.class);
            if (declaredAnnotation != null) {
                Method method = methodMap.get(GET + field.getName());
                ClassTypeEnum classTypeEnum = analysisType(field);
                field.setAccessible(true);
                MetaData metaData = new MetaData();
                metaData.setColumnName(declaredAnnotation.columnName());
                metaData.setSort(declaredAnnotation.sort());
                metaData.setField(field);
                metaData.setMethod(method);
                metaData.setClazzType(classTypeEnum);
                metaDataList.add(metaData);
            }
        }
        Collections.sort(metaDataList);
        return metaDataList;
    }

    private static ClassTypeEnum analysisType(Field field) {
        Class<?> type = field.getType();
        String name = type.getName();
        if ("java.lang.Integer".equals(name) || "int".equals(name)) {
            return ClassTypeEnum.INTEGER;
        } else if (type.getName().equals("java.lang.String")) {
            return ClassTypeEnum.STRING;
        } else if (type.getName().equals("java.lang.Boolean")) {
            return ClassTypeEnum.BOOLEAN;
        } else if (type.getName().equals("java.util.Date")) {
            return ClassTypeEnum.DATE;
        }
        return null;
    }
}
