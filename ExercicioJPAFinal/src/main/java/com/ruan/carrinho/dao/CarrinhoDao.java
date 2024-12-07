package com.ruan.carrinho.dao;

import com.ruan.carrinho.bean.CarrinhoBean;
import com.ruan.categoria.bean.CategoriaBean;
import com.ruan.util.DaoException;
import com.ruan.util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.Collection;

public class CarrinhoDao {
    public CarrinhoBean save(CarrinhoBean carrinhoBean) throws DaoException {
        EntityManager entityManager = JpaUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(carrinhoBean);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) transaction.rollback();
            System.err.println("Erro em inserir carrinho: " + e.getMessage());
            throw new DaoException("Erro inserir carrinho", e);
        } finally {
            JpaUtil.closeEntityManager(entityManager);
        }
        return carrinhoBean;
    }

    public CarrinhoBean replace(CarrinhoBean carrinhoBean) throws DaoException {
        EntityManager entityManager = JpaUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(carrinhoBean);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) transaction.rollback();
            System.err.println("Erro em alterar carrinho: " + e.getMessage());
            throw new DaoException("Erro alterar carrinho", e);
        } finally {
            JpaUtil.closeEntityManager(entityManager);
        }
        return carrinhoBean;
    }
    public CarrinhoBean findById(Long id) throws DaoException{
        EntityManager entityManager = JpaUtil.getEntityManager();
        try{
            return entityManager.find(CarrinhoBean.class, id);
        }finally {
            JpaUtil.closeEntityManager(entityManager);
        }
    }
    public Collection<CarrinhoBean> findAll() throws DaoException{
        EntityManager entityManager = JpaUtil.getEntityManager();
        try{
            Query fromCarrinhoBean = entityManager.createQuery("from CarrinhoBean");
            return fromCarrinhoBean.getResultList();
        }finally {
            JpaUtil.closeEntityManager(entityManager);
        }
    }
    public boolean removeById(Long id) throws DaoException{
        EntityManager entityManager = JpaUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            CarrinhoBean carrinhoBean = entityManager.find(CarrinhoBean.class, id);
            if (carrinhoBean != null) {
                entityManager.remove(carrinhoBean);
                transaction.commit();
                return true;
            } else {
                System.err.println("codigo carrinho " + id + "nao encontrado!");
                return false;
            }
        } catch (Exception e) {
            System.err.println("Erro ao excluir carrinho: " + e.getMessage());
            throw new DaoException("Erro ao excluir carrinho", e);
        } finally {
            JpaUtil.closeEntityManager(entityManager);
        }
    }
}
