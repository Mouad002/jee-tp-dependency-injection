package com.example.simple;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;

public class PresentationSimple {
    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        // static instantiation using "new" keyword
        IMetier metierImpl = new MetierImpl();
        System.out.println(metierImpl.calcul());
    }
}
