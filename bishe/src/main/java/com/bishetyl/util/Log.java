package com.bishetyl.util;
import java.lang.annotation.*;
/**
 * Created by 汤玉龙 on 2018/4/13.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD,ElementType.FIELD,ElementType.PARAMETER})
@Inherited
public @interface Log {
    public String title() default "";
    public String type() default "";
}
