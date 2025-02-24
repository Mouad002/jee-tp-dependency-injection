package com.example.simple;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class MetierImpl implements IMetier {
    IDao daoImp;
    public MetierImpl() throws FileNotFoundException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        // dynamic instantiation
        Scanner scanner = new Scanner(new File("config.txt"));
        Class iDao = Class.forName(scanner.nextLine());
        daoImp = (IDao)iDao.getConstructor().newInstance();
    }
    public void setDaoImp(IDao daoImp) {
        this.daoImp = daoImp;
    }
    @Override
    public double calcul() {
        return daoImp.getData() * 10;
    }
}
