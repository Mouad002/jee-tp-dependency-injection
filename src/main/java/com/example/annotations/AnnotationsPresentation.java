package com.example.annotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationsPresentation {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.example.annotations");
        IMetier metier = (IMetier) context.getBean(IMetier.class);
        System.out.println(metier.calcul());
    }
}
