package com.ifrr.projetojpamaven.cliente.dao; // Declara o pacote para a classe de acesso a dados de Cliente

import com.ifrr.projetojpamaven.cliente.bean.ClienteBean; // Importa a classe de entidade Cliente
import java.util.Collection; // Importa interface para coleções
import javax.persistence.EntityManager; // Importa gerenciador de entidades JPA
import javax.persistence.EntityTransaction; // Importa gerenciador de transações
import javax.persistence.Query; // Importa interface para consultas
import util.DaoException; // Importa exceção personalizada para camada de persistência
import com.ifrr.projetojpamaven.util.JpaUtil; // Importa utilitário para gerenciamento de EntityManager

public class ClienteDao { // Declara classe de acesso a dados para Cliente

    public ClienteBean inserir(ClienteBean obj) throws DaoException { // Método para inserir novo cliente
        EntityManager manager = JpaUtil.getEntityManager(); // Obtém gerenciador de entidades
        EntityTransaction tx = manager.getTransaction(); // Inicia transação
        try {
            tx.begin(); // Inicia transação
            manager.persist(obj); // Persiste objeto no banco de dados
            tx.commit(); // Confirma transação
        } catch (Exception e) { // Captura qualquer exceção
            if (tx.isActive()) tx.rollback(); // Reverte transação se ainda ativa
            System.err.println("Erro ao inserir Cliente: " + e.getMessage()); // Imprime erro no console
            throw new DaoException("Erro ao inserir Cliente", e); // Lança exceção personalizada
        } finally {
            JpaUtil.closeEntityManager(manager); // Fecha gerenciador de entidades
        }
        return obj; // Retorna objeto inserido
    }

    public ClienteBean alterar(ClienteBean obj) throws DaoException { // Método para alterar cliente existente
        EntityManager manager = JpaUtil.getEntityManager(); // Obtém gerenciador de entidades
        EntityTransaction tx = manager.getTransaction(); // Inicia transação
        try {
            tx.begin(); // Inicia transação
            obj = manager.merge(obj); // Atualiza objeto no banco de dados
            tx.commit(); // Confirma transação
        } catch (Exception e) { // Captura qualquer exceção
            if (tx.isActive()) tx.rollback(); // Reverte transação se ainda ativa
            System.err.println("Erro ao alterar Cliente: " + e.getMessage()); // Imprime erro no console
            throw new DaoException("Erro ao alterar Cliente", e); // Lança exceção personalizada
        } finally {
            JpaUtil.closeEntityManager(manager); // Fecha gerenciador de entidades
        }
        return obj; // Retorna objeto alterado
    }

    public Boolean excluir(Integer codigo) throws DaoException { // Método para excluir cliente
        EntityManager manager = JpaUtil.getEntityManager(); // Obtém gerenciador de entidades
        EntityTransaction tx = manager.getTransaction(); // Inicia transação
        try {
            tx.begin(); // Inicia transação
            ClienteBean cliente = manager.find(ClienteBean.class, codigo); // Busca cliente pelo código
            if (cliente != null) { // Verifica se cliente existe
                manager.remove(cliente); // Remove cliente do banco de dados
                tx.commit(); // Confirma transação
                return true; // Retorna sucesso na exclusão
            } else {
                System.err.println("Cliente com o código " + codigo + " não encontrado."); // Imprime mensagem de cliente não encontrado
                return false; // Retorna falha na exclusão
            }
        } catch (Exception e) { // Captura qualquer exceção
            if (tx.isActive()) tx.rollback(); // Reverte transação se ainda ativa
            System.err.println("Erro ao excluir Cliente: " + e.getMessage()); // Imprime erro no console
            throw new DaoException("Erro ao excluir Cliente", e); // Lança exceção personalizada
        } finally {
            JpaUtil.closeEntityManager(manager); // Fecha gerenciador de entidades
        }
    }

    public ClienteBean selecionar(Integer codigo) throws DaoException { // Método para selecionar cliente
        EntityManager manager = JpaUtil.getEntityManager(); // Obtém gerenciador de entidades
        try {
            return manager.find(ClienteBean.class, codigo); // Busca e retorna cliente pelo código
        } finally {
            JpaUtil.closeEntityManager(manager); // Fecha gerenciador de entidades
        }
    }

    public Collection<ClienteBean> listar() throws DaoException { // Método para listar todos os clientes
        EntityManager manager = JpaUtil.getEntityManager(); // Obtém gerenciador de entidades
        try {
            Query query = manager.createQuery("from ClienteBean"); // Cria consulta para buscar todos os clientes
            return query.getResultList(); // Retorna lista de clientes
        } finally {
            JpaUtil.closeEntityManager(manager); // Fecha gerenciador de entidades
        }
    }
}