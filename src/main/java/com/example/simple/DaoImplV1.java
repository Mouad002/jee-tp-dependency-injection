package com.example.simple;

public class DaoImplV1 implements IDao{
    @Override
    public double getData() {
        System.out.println("version base de donnees");
        return 29;
    }
}
