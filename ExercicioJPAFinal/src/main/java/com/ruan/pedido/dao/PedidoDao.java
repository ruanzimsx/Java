package com.ruan.pedido.dao;

import com.ruan.itemCarrinho.bean.ItemCarrinhoBean;
import com.ruan.pedido.bean.PedidoBean;
import com.ruan.util.DaoException;
import com.ruan.util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.Collection;

public class PedidoDao {
    public PedidoBean save(PedidoBean pedidoBean) throws DaoException {
        EntityManager entityManager = JpaUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(pedidoBean);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) transaction.rollback();
            System.err.println("Erro em inserir pedido: " + e.getMessage());
            throw new DaoException("Erro inserir pedido", e);
        } finally {
            JpaUtil.closeEntityManager(entityManager);
        }
        return pedidoBean;
    }

    public PedidoBean replace(PedidoBean pedidoBean) throws DaoException {
        EntityManager entityManager = JpaUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(pedidoBean);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) transaction.rollback();
            System.err.println("Erro em alterar pedido: " + e.getMessage());
            throw new DaoException("Erro alterar pedido", e);
        } finally {
            JpaUtil.closeEntityManager(entityManager);
        }
        return pedidoBean;
    }
    public PedidoBean findById(Long id) throws DaoException{
        EntityManager entityManager = JpaUtil.getEntityManager();
        try{
            return entityManager.find(PedidoBean.class, id);
        }finally {
            JpaUtil.closeEntityManager(entityManager);
        }
    }
    public Collection<PedidoBean> findAll() throws DaoException{
        EntityManager entityManager = JpaUtil.getEntityManager();
        try{
            Query fromPedidoBean = entityManager.createQuery("from PedidoBean");
            return fromPedidoBean.getResultList();
        }finally {
            JpaUtil.closeEntityManager(entityManager);
        }
    }
    public boolean removeById(Long id) throws DaoException{
        EntityManager entityManager = JpaUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            PedidoBean pedidoBean = entityManager.find(PedidoBean.class, id);
            if (pedidoBean != null) {
                entityManager.remove(pedidoBean);
                transaction.commit();
                return true;
            } else {
                System.err.println("codigo pedido " + id + "nao encontrado!");
                return false;
            }
        } catch (Exception e) {
            System.err.println("Erro ao excluir pedido: " + e.getMessage());
            throw new DaoException("Erro ao excluir pedido", e);
        } finally {
            JpaUtil.closeEntityManager(entityManager);
        }
    }
}
