package com.ruan.itemCarrinho.dao;

import com.ruan.itemCarrinho.bean.ItemCarrinhoBean;
import com.ruan.util.DaoException;
import com.ruan.util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.Collection;

public class ItemCarrinhoDao {
    public ItemCarrinhoBean save(ItemCarrinhoBean itemCarrinhoBean) throws DaoException {
        EntityManager entityManager = JpaUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(itemCarrinhoBean);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) transaction.rollback();
            System.err.println("Erro em inserir item carrinho: " + e.getMessage());
            throw new DaoException("Erro inserir item carrinho", e);
        } finally {
            JpaUtil.closeEntityManager(entityManager);
        }
        return itemCarrinhoBean;
    }

    public ItemCarrinhoBean replace(ItemCarrinhoBean itemCarrinhoBean) throws DaoException {
        EntityManager entityManager = JpaUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(itemCarrinhoBean);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) transaction.rollback();
            System.err.println("Erro em alterar item carrinho: " + e.getMessage());
            throw new DaoException("Erro alterar item carrinho", e);
        } finally {
            JpaUtil.closeEntityManager(entityManager);
        }
        return itemCarrinhoBean;
    }
    public ItemCarrinhoBean findById(Long id) throws DaoException{
        EntityManager entityManager = JpaUtil.getEntityManager();
        try{
            return entityManager.find(ItemCarrinhoBean.class, id);
        }finally {
            JpaUtil.closeEntityManager(entityManager);
        }
    }
    public Collection<ItemCarrinhoBean> findAll(){
        EntityManager entityManager = JpaUtil.getEntityManager();
        try{
            Query fromItemCarrinhoBean = entityManager.createQuery("from ItemCarrinhoBean");
            return fromItemCarrinhoBean.getResultList();
        }finally {
            JpaUtil.closeEntityManager(entityManager);
        }
    }
    public boolean removeById(Long id) throws DaoException{
        EntityManager entityManager = JpaUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            ItemCarrinhoBean itemCarrinhoBean = entityManager.find(ItemCarrinhoBean.class, id);
            if (itemCarrinhoBean != null) {
                entityManager.remove(itemCarrinhoBean);
                transaction.commit();
                return true;
            } else {
                System.err.println("codigo item carrinho " + id + "nao encontrado!");
                return false;
            }
        } catch (Exception e) {
            System.err.println("Erro ao excluir item carrinho: " + e.getMessage());
            throw new DaoException("Erro ao excluir item carrinho", e);
        } finally {
            JpaUtil.closeEntityManager(entityManager);
        }
    }
}
