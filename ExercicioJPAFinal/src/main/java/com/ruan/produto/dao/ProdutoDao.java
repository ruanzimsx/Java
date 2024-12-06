package com.ruan.produto.dao;

import com.ruan.produto.bean.ProdutoBean;
import com.ruan.util.DaoException;
import com.ruan.util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.Collection;
import java.util.List;

public class ProdutoDao {

    public ProdutoBean save(ProdutoBean produtoBean) throws DaoException {
        EntityManager entityManager = JpaUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(produtoBean);
            transaction.commit();
        } catch (Exception exception) {
            if (transaction.isActive()) transaction.rollback();
            System.err.println("Erro ao inserir produto: " + exception.getMessage());
            throw new DaoException("Erro ao inserir Produto", exception);
        } finally {
            JpaUtil.closeEntityManager(entityManager);
        }
        return produtoBean;
    }

    public ProdutoBean replace(ProdutoBean produtoBean) throws DaoException {
        EntityManager entityManager = JpaUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            produtoBean = entityManager.merge(produtoBean);
            transaction.commit();
        } catch (Exception exception) {
            if (transaction.isActive()) transaction.rollback();
            System.err.println("Erro ao alterar produto: " + exception.getMessage());
            throw new DaoException("Erro ao alterar Produto", exception);
        } finally {
            JpaUtil.closeEntityManager(entityManager);
        }
        return produtoBean;
    }

    public ProdutoBean findById(Long id) throws DaoException{
        EntityManager entityManager = JpaUtil.getEntityManager();
        try {
            return entityManager.find(ProdutoBean.class, id);
        } finally {
            JpaUtil.closeEntityManager(entityManager);
        }
    }

    public Collection<ProdutoBean> findAll() throws DaoException{
        EntityManager entityManager = JpaUtil.getEntityManager();
        try {
            Query fromProduto = entityManager.createQuery("from ProdutoBean");
            return fromProduto.getResultList();
        } finally {
            JpaUtil.closeEntityManager(entityManager);
        }
    }

    public boolean removeById(Long id) throws DaoException {
        EntityManager entityManager = JpaUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            ProdutoBean produtoBean = entityManager.find(ProdutoBean.class, id);
            if (produtoBean != null) {
                entityManager.remove(produtoBean);
                transaction.commit();
                return true;
            } else {
                System.err.println("codigo produto " + id + "nao encontrado!");
                return false;
            }
        } catch (Exception e) {
            System.err.println("Erro ao excluir produto: " + e.getMessage());
            throw new DaoException("Erro ao excluir produto", e);
        } finally {
            JpaUtil.closeEntityManager(entityManager);
        }
    }
}
