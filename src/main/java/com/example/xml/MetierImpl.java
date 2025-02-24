package com.example.xml;

public class MetierImpl implements IMetier {
    IDao daoImp;
    public MetierImpl() {

    }
    public void setDaoImp(IDao daoImp) {
        this.daoImp = daoImp;
    }
    @Override
    public double calcul() {
        return daoImp.getData();
    }
}
