package com.example.annotations;

import org.springframework.stereotype.Repository;

@Repository("dao")
public class DaoImplV1 implements IDao {
    @Override
    public double getData() {
        System.out.println("version base de donnees");
        return 29;
    }
}
