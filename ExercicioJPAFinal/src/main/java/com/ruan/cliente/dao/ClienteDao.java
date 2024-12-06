package com.ruan.cliente.dao;

import com.ruan.categoria.bean.CategoriaBean;
import com.ruan.cliente.bean.ClienteBean;
import com.ruan.util.DaoException;
import com.ruan.util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.Collection;

public class ClienteDao {
    public ClienteBean save(ClienteBean clienteBean) throws DaoException {
        EntityManager entityManager = JpaUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(clienteBean);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) transaction.rollback();
            System.err.println("Erro em inserir cliente: " + e.getMessage());
            throw new DaoException("Erro inserir cliente", e);
        } finally {
            JpaUtil.closeEntityManager(entityManager);
        }
        return clienteBean;
    }

    public ClienteBean replace(ClienteBean clienteBean) throws DaoException {
        EntityManager entityManager = JpaUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(clienteBean);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) transaction.rollback();
            System.err.println("Erro em alterar cliente: " + e.getMessage());
            throw new DaoException("Erro alterar cliente", e);
        } finally {
            JpaUtil.closeEntityManager(entityManager);
        }
        return clienteBean;
    }
    public ClienteBean findById(Long id) throws DaoException{
        EntityManager entityManager = JpaUtil.getEntityManager();
        try{
            return entityManager.find(ClienteBean.class, id);
        }finally {
            JpaUtil.closeEntityManager(entityManager);
        }
    }
    public Collection<ClienteBean> findAll() throws DaoException{
        EntityManager entityManager = JpaUtil.getEntityManager();
        try{
            Query fromClienteBean = entityManager.createQuery("from ClienteBean");
            return fromClienteBean.getResultList();
        }finally {
            JpaUtil.closeEntityManager(entityManager);
        }
    }
    public boolean removeById(Long id) throws DaoException{
        EntityManager entityManager = JpaUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            ClienteBean clienteBean = entityManager.find(ClienteBean.class, id);
            if (clienteBean != null) {
                entityManager.remove(clienteBean);
                transaction.commit();
                return true;
            } else {
                System.err.println("codigo cliente " + id + "nao encontrado!");
                return false;
            }
        } catch (Exception e) {
            System.err.println("Erro ao excluir cliente: " + e.getMessage());
            throw new DaoException("Erro ao excluir cliente", e);
        } finally {
            JpaUtil.closeEntityManager(entityManager);
        }
    }
}
