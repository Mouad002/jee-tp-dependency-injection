package com.example.annotations;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("metier")
public class MetierImpl implements IMetier {

    private IDao daoImp;

    public MetierImpl(@Qualifier("dao2") IDao daoImp) {
        this.daoImp = daoImp;
    }
    public void setDaoImp(IDao daoImp) {
        this.daoImp = daoImp;
    }
    @Override
    public double calcul() {
        return daoImp.getData();
    }
}
