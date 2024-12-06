package com.ruan.pessoa.dao;

import com.ruan.itemCarrinho.bean.ItemCarrinhoBean;
import com.ruan.pessoa.bean.PessoaBean;
import com.ruan.util.DaoException;
import com.ruan.util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.Collection;

public class PessoaDao {
    public PessoaBean save(PessoaBean pessoaBean) throws DaoException {
        EntityManager entityManager = JpaUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(pessoaBean);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) transaction.rollback();
            System.err.println("Erro em inserir pessoa: " + e.getMessage());
            throw new DaoException("Erro inserir pessoa", e);
        } finally {
            JpaUtil.closeEntityManager(entityManager);
        }
        return pessoaBean;
    }

    public PessoaBean replace(PessoaBean pessoaBean) throws DaoException {
        EntityManager entityManager = JpaUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(pessoaBean);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) transaction.rollback();
            System.err.println("Erro em alterar pessoa: " + e.getMessage());
            throw new DaoException("Erro alterar pessoa", e);
        } finally {
            JpaUtil.closeEntityManager(entityManager);
        }
        return pessoaBean;
    }

    public PessoaBean findById(Long id) throws DaoException {
        EntityManager entityManager = JpaUtil.getEntityManager();
        try {
            return entityManager.find(PessoaBean.class, id);
        } finally {
            JpaUtil.closeEntityManager(entityManager);
        }
    }

    public Collection<PessoaBean> findAll() throws DaoException{
        EntityManager entityManager = JpaUtil.getEntityManager();
        try {
            Query fromPessoaBean = entityManager.createQuery("from PessoaBean");
            return fromPessoaBean.getResultList();
        } finally {
            JpaUtil.closeEntityManager(entityManager);
        }
    }

    public boolean removeById(Long id) throws DaoException {
        EntityManager entityManager = JpaUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            PessoaBean pessoaBean = entityManager.find(PessoaBean.class, id);
            if (pessoaBean != null) {
                entityManager.remove(pessoaBean);
                transaction.commit();
                return true;
            } else {
                System.err.println("codigo pessoa " + id + "nao encontrado!");
                return false;
            }
        } catch (Exception e) {
            System.err.println("Erro ao excluir pessoa: " + e.getMessage());
            throw new DaoException("Erro ao excluir pessoa", e);
        } finally {
            JpaUtil.closeEntityManager(entityManager);
        }
    }
}
