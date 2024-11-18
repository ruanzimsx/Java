package com.ifrr.projetojpamaven.cliente.dao;

import com.ifrr.projetojpamaven.cliente.bean.ClienteBean;
import com.ifrr.projetojpamaven.util.JpaUtil;
import util.DaoException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public abstract class ClienteDao {
    public static ClienteBean inserir(ClienteBean clienteBean) throws DaoException {
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        try{
            transaction.begin();
            manager.persist(clienteBean);
            transaction.commit();
        }catch(Exception e){
            if(transaction.isActive()) transaction.rollback();
            System.err.println("Erro ao inserir ClienteBean: "+e.getMessage());
            throw new DaoException("Erro ao inserir Cliente", e);
        }finally {
            JpaUtil.closeEntityManager(manager);
        }
        return clienteBean;
    }
    public static ClienteBean alterar(ClienteBean clienteBean) throws DaoException {
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        try{
            transaction.begin();
            ClienteBean merged = manager.merge(clienteBean);
            transaction.commit();
        }catch(Exception e){
            if(transaction.isActive()) transaction.rollback();
            System.err.println("Erro ao alterar ClienteBean: "+e.getMessage());
            throw new DaoException("Erro ao alterar Cliente", e);
        }finally {
            JpaUtil.closeEntityManager(manager);
        }
        return clienteBean; //Não é o objeto alterado, pois o retorno do objeto alterado tem ciclo de vida no try.
    }    
    public static Boolean excluir(Integer id) throws DaoException {
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        try{
            transaction.begin();
            ClienteBean clienteBean = manager.find(ClienteBean.class, id);
            if(clienteBean != null){
                manager.remove(clienteBean);
                transaction.commit();
                return true;
            }else{
                System.err.println("Cliente com o id " + id + " não encontrado.");
                return false;
            }
        }catch(Exception e){
            if(transaction.isActive()) transaction.rollback();
            System.err.println("Erro ao excluir ClienteBean: "+e.getMessage());
            throw new DaoException("Erro ao excluir Cliente", e);
        }finally {
            JpaUtil.closeEntityManager(manager);
        }
    }
    public static ClienteBean selecionar(Integer id) throws DaoException{
        EntityManager manager = JpaUtil.getEntityManager();
        try{
            return manager.find(ClienteBean.class, id);
        }finally {
            JpaUtil.closeEntityManager(manager);
        }
    }

    public static List listar() throws DaoException{
        EntityManager manager = JpaUtil.getEntityManager();
        try{
            Query fromClienteBean = manager.createQuery("from ClienteBean");
            return fromClienteBean.getResultList();
        }finally {
            JpaUtil.closeEntityManager(manager);
        }
    }
}
