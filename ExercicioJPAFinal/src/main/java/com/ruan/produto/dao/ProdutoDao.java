package com.ruan.produto.dao;

import com.ruan.produto.bean.ProdutoBean;
import com.ruan.util.DaoException;
import com.ruan.util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class ProdutoDao {

    public ProdutoBean inserir(ProdutoBean produtoBean) throws DaoException {
        EntityManager entityManager = JpaUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try{
            transaction.begin();
            entityManager.persist(produtoBean);
            transaction.commit();
        }catch(Exception exception){
            if(transaction.isActive()) transaction.rollback();
            System.err.println("Erro ao inserir produto: "+exception.getMessage());
            throw new DaoException("Erro ao inserir Produto", exception);
        }finally {
            JpaUtil.closeEntityManager(entityManager);
        }
        return produtoBean;
    }

    public ProdutoBean alterar (ProdutoBean produtoBean) throws DaoException{
        EntityManager entityManager = JpaUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try{
            transaction.begin();
            produtoBean = entityManager.merge(produtoBean);
            transaction.commit();
        }catch(Exception exception){
            if(transaction.isActive()) transaction.rollback();
            System.err.println("Erro ao alterar produto: "+exception.getMessage());
            throw new DaoException("Erro ao alterar Produto", exception);
        }finally {
            JpaUtil.closeEntityManager(entityManager);
        }
        return produtoBean;
    }

    public ProdutoBean selecionar(Long id) throws DaoException{
        EntityManager entityManager = JpaUtil.getEntityManager();
        try{
            return entityManager.find(ProdutoBean.class, id);
        }catch (Exception e){
            System.out.println("Erro ao selecionar produto: "+e.getMessage());
            throw new DaoException("Erro ao selecionar produto", e);
        }finally {
            JpaUtil.closeEntityManager(entityManager);
        }
    }
}
