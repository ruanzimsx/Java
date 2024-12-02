package com.ifrr.projetojpamaven.conta.dao; // Declara o pacote onde a classe ContaDao está localizada.

import com.ifrr.projetojpamaven.conta.bean.ContaBean; // Importa a classe ContaBean para representar a entidade Conta.
import java.util.Collection; // Importa Collection para retorno de listas.
import javax.persistence.EntityManager; // Importa EntityManager para gerenciar a persistência de dados.
import javax.persistence.EntityTransaction; // Importa EntityTransaction para manipular transações.
import javax.persistence.Query; // Importa Query para consultas JPQL.
import util.DaoException; // Importa DaoException para manipulação de exceções personalizadas.
import com.ifrr.projetojpamaven.util.JpaUtil; // Importa JpaUtil para acessar o EntityManager.

public class ContaDao { // Declara a classe ContaDao para gerenciar operações no banco de dados para a entidade ContaBean.

    // Método para inserir uma nova conta no banco de dados.
    public ContaBean inserir(ContaBean obj) throws DaoException {
        EntityManager manager = JpaUtil.getEntityManager(); // Obtém o EntityManager.
        EntityTransaction tx = manager.getTransaction(); // Inicia uma nova transação.
        try {
            tx.begin(); // Inicia a transação.
            manager.persist(obj); // Persiste o objeto ContaBean no banco de dados.
            tx.commit(); // Confirma a transação para salvar o objeto.
        } catch (Exception e) { // Captura qualquer exceção durante o processo.
            if (tx.isActive()) tx.rollback(); // Reverte a transação em caso de erro.
            // Imprime uma mensagem de erro detalhada sobre a falha de inserção.
            System.err.println("Erro ao inserir Conta: " + e.getMessage());
            throw new DaoException("Erro ao inserir Conta", e); // Lança exceção personalizada.
        } finally {
            JpaUtil.closeEntityManager(manager); // Fecha o EntityManager de forma segura.
        }
        return obj; // Retorna o objeto persistido.
    }

    // Método para alterar uma conta existente no banco de dados.
    public ContaBean alterar(ContaBean obj) throws DaoException {
        EntityManager manager = JpaUtil.getEntityManager(); // Obtém o EntityManager.
        EntityTransaction tx = manager.getTransaction(); // Inicia uma nova transação.
        try {
            tx.begin(); // Inicia a transação.
            obj = manager.merge(obj); // Atualiza o estado do objeto no banco de dados.
            tx.commit(); // Confirma a transação para salvar as mudanças.
        } catch (Exception e) { // Captura qualquer exceção durante o processo.
            if (tx.isActive()) tx.rollback(); // Reverte a transação em caso de erro.
            // Imprime uma mensagem de erro detalhada sobre a falha de alteração.
            System.err.println("Erro ao alterar Conta: " + e.getMessage());
            throw new DaoException("Erro ao alterar Conta", e); // Lança exceção personalizada.
        } finally {
            JpaUtil.closeEntityManager(manager); // Fecha o EntityManager de forma segura.
        }
        return obj; // Retorna o objeto atualizado.
    }

    // Método para excluir uma conta com base no código fornecido.
    public Boolean excluir(Integer codigo) throws DaoException {
        EntityManager manager = JpaUtil.getEntityManager(); // Obtém o EntityManager.
        EntityTransaction tx = manager.getTransaction(); // Inicia uma nova transação.
        try {
            tx.begin(); // Inicia a transação.
            ContaBean conta = manager.find(ContaBean.class, codigo); // Busca a conta pelo código.
            if (conta != null) { // Verifica se a conta existe.
                manager.remove(conta); // Remove a conta do banco de dados.
                tx.commit(); // Confirma a exclusão.
                return true; // Retorna true para indicar sucesso.
            } else {
                // Imprime mensagem se a conta não foi encontrada.
                System.err.println("Conta com o código " + codigo + " não encontrada.");
                return false; // Retorna false se a conta não foi encontrada.
            }
        } catch (Exception e) { // Captura qualquer exceção durante o processo.
            if (tx.isActive()) tx.rollback(); // Reverte a transação em caso de erro.
            // Imprime mensagem detalhada sobre a falha na exclusão.
            System.err.println("Erro ao excluir Conta: " + e.getMessage());
            throw new DaoException("Erro ao excluir Conta", e); // Lança exceção personalizada.
        } finally {
            JpaUtil.closeEntityManager(manager); // Fecha o EntityManager de forma segura.
        }
    }

    // Método para selecionar uma conta específica com base no código.
    public ContaBean selecionar(Integer codigo) throws DaoException {
        EntityManager manager = JpaUtil.getEntityManager(); // Obtém o EntityManager.
        try {
            return manager.find(ContaBean.class, codigo); // Busca e retorna a conta pelo código.
        } finally {
            JpaUtil.closeEntityManager(manager); // Fecha o EntityManager de forma segura.
        }
    }

    // Método para listar todas as contas do banco de dados.
    public Collection<ContaBean> listar() throws DaoException {
        EntityManager manager = JpaUtil.getEntityManager(); // Obtém o EntityManager.
        try {
            Query query = manager.createQuery("from ContaBean"); // Cria uma consulta para buscar todas as contas.
            return query.getResultList(); // Executa a consulta e retorna a lista de contas.
        } finally {
            JpaUtil.closeEntityManager(manager); // Fecha o EntityManager de forma segura.
        }
    }
}
