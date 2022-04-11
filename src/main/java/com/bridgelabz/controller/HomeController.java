package com.bridgelabz.controller;

import com.bridgelabz.customannotation.MethodInfo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class HomeController {

    public static void main(String[] args) {
        System.out.println("Welcome to Custom Annotation Program.");
        try {

            for (Method method : HomeController.class.getMethods()) {
                if (method.isAnnotationPresent(MethodInfo.class)) {  // Checks if MethodInfo annotation is present for method
                    try {
                        // Iterates all the annotation available in the method
                        for (Annotation annotation : method.getDeclaredAnnotations()) {
                            System.out.println("Annotation in Method '" + method + "' : " + annotation);
                        }

                        MethodInfo methodInfo = method.getAnnotation(MethodInfo.class);
                        if (methodInfo.revsion() == 1) {
                            System.out.println("Method with revsion no 1 = " + method);
                        }
                    } catch (Throwable e) {
                        e.printStackTrace();
                    }
                }
            }

        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }

    @Deprecated
    @MethodInfo(comments = "deprecated method", date = "Nov 17 2012")
    public static void oldMethod() {
        System.out.println("Old Method, don't use it.");
    }

    @Override
    @MethodInfo(author = "Mangesh", comments = "main method", date = "April 11 2022")
    public String toString() {
        return "Overridden toString Method";
    }
}
