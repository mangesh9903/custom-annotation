package com.bridgelabz.customannotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodInfo {

    String author() default "Mangesh";

    String date();

    int revsion() default 1;

    String comments();
}