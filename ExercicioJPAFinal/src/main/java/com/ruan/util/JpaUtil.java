package com.ruan.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
    private static EntityManagerFactory entityManagerFactory;

    static {
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
        } catch (Exception exception) {
            System.out.println("Erro in create EntityManagerFactory: " + exception.getMessage());
            throw new ExceptionInInitializerError(exception);
        }
    }

    public static EntityManager getEntityManager(){
        if(entityManagerFactory == null){
            throw new IllegalStateException("Err EntityManagerFactory not inicied");
        }
        return entityManagerFactory.createEntityManager();
    }

    public static void closeEntityManager(EntityManager entityManager){
        if(entityManager != null && entityManager.isOpen()){
            entityManager.close();
        }

    }

    public static void closeEntityManagerFactory(){
        if(entityManagerFactory != null && entityManagerFactory.isOpen()){
            entityManagerFactory.close();
        }
    }

    static{
        Runtime.getRuntime().addShutdownHook(new Thread(JpaUtil::closeEntityManagerFactory));
    }
}
