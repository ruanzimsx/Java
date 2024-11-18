package com.ifrr.projetojpamaven.banco.dao; // Pacote para a classe BancoDao

import com.ifrr.projetojpamaven.banco.bean.BancoBean; // Importa a classe BancoBean
import java.util.Collection; // Importa Collection para retorno de listas
import javax.persistence.EntityManager; // Importa EntityManager para gerenciar persistência
import javax.persistence.EntityTransaction; // Importa EntityTransaction para manipular transações
import javax.persistence.Query; // Importa Query para consultas JPQL
import util.DaoException; // Importa DaoException para manipulação de exceções personalizadas
import com.ifrr.projetojpamaven.util.JpaUtil; // Importa JpaUtil para acessar o EntityManager

public class BancoDao {

    /**
     * Método para inserir um novo banco no banco de dados
     * @param obj BancoBean a ser inserido
     * @return BancoBean persistido
     * @throws DaoException em caso de erro na inserção
     */
    public BancoBean inserir(BancoBean obj) throws DaoException {
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        try {
            tx.begin(); // Inicia a transação
            manager.persist(obj); // Persiste o objeto BancoBean
            tx.commit(); // Confirma a transação
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback(); // Reverte a transação em caso de erro
            System.err.println("Erro ao inserir Banco: " + e.getMessage());
            throw new DaoException("Erro ao inserir Banco", e);
        } finally {
            JpaUtil.closeEntityManager(manager); // Fecha o EntityManager
        }
        return obj;
    }

    /**
     * Método para alterar um banco existente
     * @param obj BancoBean a ser alterado
     * @return BancoBean atualizado
     * @throws DaoException em caso de erro na alteração
     */
    public BancoBean alterar(BancoBean obj) throws DaoException {
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        try {
            tx.begin(); // Inicia a transação
            obj = manager.merge(obj); // Atualiza o estado do objeto
            tx.commit(); // Confirma a transação
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback(); // Reverte a transação em caso de erro
            System.err.println("Erro ao alterar Banco: " + e.getMessage());
            throw new DaoException("Erro ao alterar Banco", e);
        } finally {
            JpaUtil.closeEntityManager(manager); // Fecha o EntityManager
        }
        return obj;
    }

    /**
     * Método para excluir um banco pelo seu código
     * @param codigo Código do banco a ser excluído
     * @return Boolean indicando sucesso da exclusão
     * @throws DaoException em caso de erro na exclusão
     */
    public Boolean excluir(Integer codigo) throws DaoException {
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        try {
            tx.begin(); // Inicia a transação
            BancoBean banco = manager.find(BancoBean.class, codigo); // Busca o banco
            if (banco != null) {
                manager.remove(banco); // Remove o banco
                tx.commit(); // Confirma a exclusão
                return true;
            } else {
                System.err.println("Banco com o código " + codigo + " não encontrado.");
                return false;
            }
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback(); // Reverte a transação em caso de erro
            System.err.println("Erro ao excluir Banco: " + e.getMessage());
            throw new DaoException("Erro ao excluir Banco", e);
        } finally {
            JpaUtil.closeEntityManager(manager); // Fecha o EntityManager
        }
    }

    /**
     * Método para selecionar um banco específico pelo código
     * @param codigo Código do banco
     * @return BancoBean encontrado
     * @throws DaoException em caso de erro na seleção
     */
    public BancoBean selecionar(Integer codigo) throws DaoException {
        EntityManager manager = JpaUtil.getEntityManager();
        try {
            return manager.find(BancoBean.class, codigo); // Busca o banco pelo código
        } finally {
            JpaUtil.closeEntityManager(manager); // Fecha o EntityManager
        }
    }

    /**
     * Método para listar todos os bancos cadastrados
     * @return Coleção de BancoBean
     * @throws DaoException em caso de erro na listagem
     */
    public Collection<BancoBean> listar() throws DaoException {
        EntityManager manager = JpaUtil.getEntityManager();
        try {
            Query query = manager.createQuery("from BancoBean"); // Consulta para buscar todos os bancos
            return query.getResultList(); // Retorna a lista de bancos
        } finally {
            JpaUtil.closeEntityManager(manager); // Fecha o EntityManager
        }
    }

    /**
     * Método para buscar banco por nome
     * @param nome Nome do banco
     * @return Coleção de BancoBean que correspondem ao nome
     * @throws DaoException em caso de erro na busca
     */
    public Collection<BancoBean> buscarPorNome(String nome) throws DaoException {
        EntityManager manager = JpaUtil.getEntityManager();
        try {
            // Consulta JPQL para buscar bancos por nome (case-insensitive)
            Query query = manager.createQuery(
                "SELECT b FROM BancoBean b WHERE LOWER(b.nome) LIKE LOWER(:nome)"
            );
            query.setParameter("nome", "%" + nome + "%");
            return query.getResultList(); // Retorna lista de bancos
        } finally {
            JpaUtil.closeEntityManager(manager); // Fecha o EntityManager
        }
    }
}