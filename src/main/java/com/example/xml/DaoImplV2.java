package com.example.xml;

public class DaoImplV2 implements IDao{
    @Override
    public double getData() {
        System.out.println("version web service");
        return 130;
    }
}
