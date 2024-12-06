package com.ruan.itemPedido.dao;

import com.ruan.itemCarrinho.bean.ItemCarrinhoBean;
import com.ruan.itemPedido.bean.ItemPedidoBean;
import com.ruan.util.DaoException;
import com.ruan.util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.Collection;

public class ItemPedidoDao {
    public ItemPedidoBean save(ItemPedidoBean itemPedidoBean) throws DaoException {
        EntityManager entityManager = JpaUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(itemPedidoBean);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) transaction.rollback();
            System.err.println("Erro em inserir item pedido: " + e.getMessage());
            throw new DaoException("Erro inserir item pedido", e);
        } finally {
            JpaUtil.closeEntityManager(entityManager);
        }
        return itemPedidoBean;
    }

    public ItemPedidoBean replace(ItemPedidoBean itemPedidoBean) throws DaoException {
        EntityManager entityManager = JpaUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(itemPedidoBean);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) transaction.rollback();
            System.err.println("Erro em alterar item pedido: " + e.getMessage());
            throw new DaoException("Erro alterar item pedido", e);
        } finally {
            JpaUtil.closeEntityManager(entityManager);
        }
        return itemPedidoBean;
    }
    public ItemPedidoBean findById(Long id) throws DaoException{
        EntityManager entityManager = JpaUtil.getEntityManager();
        try{
            return entityManager.find(ItemPedidoBean.class, id);
        }finally {
            JpaUtil.closeEntityManager(entityManager);
        }
    }
    public Collection<ItemPedidoBean> findAll() throws DaoException{
        EntityManager entityManager = JpaUtil.getEntityManager();
        try{
            Query fromItemPedidoBean = entityManager.createQuery("from ItemPedidoBean");
            return fromItemPedidoBean.getResultList();
        }finally {
            JpaUtil.closeEntityManager(entityManager);
        }
    }
    public boolean removeById(Long id) throws DaoException{
        EntityManager entityManager = JpaUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            ItemPedidoBean itemPedidoBean = entityManager.find(ItemPedidoBean.class, id);
            if (itemPedidoBean != null) {
                entityManager.remove(itemPedidoBean);
                transaction.commit();
                return true;
            } else {
                System.err.println("codigo item pedido " + id + "nao encontrado!");
                return false;
            }
        } catch (Exception e) {
            System.err.println("Erro ao excluir item pedido: " + e.getMessage());
            throw new DaoException("Erro ao excluir item pedido", e);
        } finally {
            JpaUtil.closeEntityManager(entityManager);
        }
    }
}
