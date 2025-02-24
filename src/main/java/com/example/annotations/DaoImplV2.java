package com.example.annotations;

import org.springframework.stereotype.Repository;

@Repository("dao2")
public class DaoImplV2 implements IDao {
    @Override
    public double getData() {
        System.out.println("version web service");
        return 130;
    }
}
