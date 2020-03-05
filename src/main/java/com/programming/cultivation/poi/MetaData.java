package com.programming.cultivation.poi;

import com.programming.cultivation.poi.common.ClassTypeEnum;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author biyue
 * @since 2020/01/10
 */
public class MetaData implements Comparable<MetaData> {

    private String columnName;

    private int sort;

    private Field field;

    private Method method;

    private ClassTypeEnum clazzType;

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public ClassTypeEnum getClazzType() {
        return clazzType;
    }

    public void setClazzType(ClassTypeEnum clazzType) {
        this.clazzType = clazzType;
    }

    @Override
    public int compareTo(MetaData o) {
        return sort < o.sort ? -1 : 1;
    }

    @Override
    public String toString() {
        return "MetaData{" +
                "columnName='" + columnName + '\'' +
                ", sort=" + sort +
                ", field=" + field +
                ", method=" + method +
                ", clazzType=" + clazzType +
                '}';
    }
}
