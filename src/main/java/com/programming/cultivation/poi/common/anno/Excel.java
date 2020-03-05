package com.programming.cultivation.poi.common.anno;

import java.lang.annotation.*;

/**
 * @author biyue
 * @since 2020/01/10
 */
@Inherited
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Excel {

    String columnName();

    int sort();

}
