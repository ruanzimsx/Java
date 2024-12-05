package com.ruan.categoria.dao;

import com.ruan.categoria.bean.CategoriaBean;
import com.ruan.produto.bean.ProdutoBean;
import com.ruan.util.DaoException;
import com.ruan.util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.Collection;

public class CategoriaDao {
    public CategoriaBean save(CategoriaBean categoriaBean) throws DaoException {
        EntityManager entityManager = JpaUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(categoriaBean);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) transaction.rollback();
            System.err.println("Erro em inserir categoria: " + e.getMessage());
            throw new DaoException("Erro inserir categoria", e);
        } finally {
            JpaUtil.closeEntityManager(entityManager);
        }
        return categoriaBean;
    }

    public CategoriaBean replace(CategoriaBean categoriaBean) throws DaoException {
        EntityManager entityManager = JpaUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(categoriaBean);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) transaction.rollback();
            System.err.println("Erro em alterar categoria: " + e.getMessage());
            throw new DaoException("Erro alterar categoria", e);
        } finally {
            JpaUtil.closeEntityManager(entityManager);
        }
        return categoriaBean;
    }
    public CategoriaBean findById(Long id) throws DaoException{
        EntityManager entityManager = JpaUtil.getEntityManager();
        try{
            return entityManager.find(CategoriaBean.class, id);
        }finally {
            JpaUtil.closeEntityManager(entityManager);
        }
    }
    public Collection<CategoriaBean> findAll(){
        EntityManager entityManager = JpaUtil.getEntityManager();
        try{
            Query fromCategoriaBean = entityManager.createQuery("from CategoriaBean");
            return fromCategoriaBean.getResultList();
        }finally {
            JpaUtil.closeEntityManager(entityManager);
        }
    }
    public boolean removeById(Long id) throws DaoException{
        EntityManager entityManager = JpaUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            CategoriaBean categoriaBean = entityManager.find(CategoriaBean.class, id);
            if (categoriaBean != null) {
                entityManager.remove(categoriaBean);
                transaction.commit();
                return true;
            } else {
                System.err.println("codigo categoria " + id + "nao encontrado!");
                return false;
            }
        } catch (Exception e) {
            System.err.println("Erro ao excluir categoria: " + e.getMessage());
            throw new DaoException("Erro ao excluir categoria", e);
        } finally {
            JpaUtil.closeEntityManager(entityManager);
        }
    }
}
