package com.ifrr.projetojpamaven.servico.dao; // Declara o pacote onde a classe ServicoDao está localizada.

import com.ifrr.projetojpamaven.servico.bean.ServicoBean; // Importa a classe ServicoBean para representar a entidade Servico.
import java.util.Collection; // Importa Collection para retorno de listas.
import javax.persistence.EntityManager; // Importa EntityManager para gerenciar a persistência de dados.
import javax.persistence.EntityTransaction; // Importa EntityTransaction para manipular transações.
import javax.persistence.Query; // Importa Query para consultas JPQL.
import util.DaoException; // Importa DaoException para manipulação de exceções personalizadas.
import com.ifrr.projetojpamaven.util.JpaUtil; // Importa JpaUtil para acessar o EntityManager.

public class ServicoDao { // Declara a classe ServicoDao para gerenciar operações no banco de dados para a entidade ServicoBean.

    public ServicoBean inserir(ServicoBean obj) throws DaoException { // Método para inserir um novo serviço no banco de dados.
        EntityManager manager = JpaUtil.getEntityManager(); // Obtém o EntityManager.
        EntityTransaction tx = manager.getTransaction(); // Inicia uma nova transação.
        try {
            tx.begin(); // Inicia a transação.
            manager.persist(obj); // Persiste o objeto ServicoBean no banco de dados.
            tx.commit(); // Confirma a transação para salvar o objeto.
        } catch (Exception e) { // Captura qualquer exceção durante o processo.
            if (tx.isActive()) tx.rollback(); // Reverte a transação em caso de erro.
            System.err.println("Erro ao inserir Serviço: " + e.getMessage()); // Imprime uma mensagem de erro detalhada sobre a falha de inserção.
            throw new DaoException("Erro ao inserir Serviço", e); // Lança exceção personalizada.
        } finally {
            JpaUtil.closeEntityManager(manager); // Fecha o EntityManager de forma segura.
        }
        return obj; // Retorna o objeto persistido.
    }

    public ServicoBean alterar(ServicoBean obj) throws DaoException { // Método para alterar um serviço existente no banco de dados.
        EntityManager manager = JpaUtil.getEntityManager(); // Obtém o EntityManager.
        EntityTransaction tx = manager.getTransaction(); // Inicia uma nova transação.
        try {
            tx.begin(); // Inicia a transação.
            obj = manager.merge(obj); // Atualiza o estado do objeto no banco de dados.
            tx.commit(); // Confirma a transação para salvar as mudanças.
        } catch (Exception e) { // Captura qualquer exceção durante o processo.
            if (tx.isActive()) tx.rollback(); // Reverte a transação em caso de erro.
            System.err.println("Erro ao alterar Serviço: " + e.getMessage()); // Imprime uma mensagem de erro detalhada sobre a falha de alteração.
            throw new DaoException("Erro ao alterar Serviço", e); // Lança exceção personalizada.
        } finally {
            JpaUtil.closeEntityManager(manager); // Fecha o EntityManager de forma segura.
        }
        return obj; // Retorna o objeto atualizado.
    }

    public Boolean excluir(Integer codigo) throws DaoException { // Método para excluir um serviço com base no código fornecido.
        EntityManager manager = JpaUtil.getEntityManager(); // Obtém o EntityManager.
        EntityTransaction tx = manager.getTransaction(); // Inicia uma nova transação.
        try {
            tx.begin(); // Inicia a transação.
            ServicoBean servico = manager.find(ServicoBean.class, codigo); // Busca o serviço pelo código.
            if (servico != null) { // Verifica se o serviço existe.
                manager.remove(servico); // Remove o serviço do banco de dados.
                tx.commit(); // Confirma a exclusão.
                return true; // Retorna true para indicar sucesso.
            } else {
                System.err.println("Serviço com o código " + codigo + " não encontrado."); // Imprime mensagem se o serviço não foi encontrado.
                return false; // Retorna false se o serviço não foi encontrado.
            }
        } catch (Exception e) { // Captura qualquer exceção durante o processo.
            if (tx.isActive()) tx.rollback(); // Reverte a transação em caso de erro.
            System.err.println("Erro ao excluir Serviço: " + e.getMessage()); // Imprime mensagem detalhada sobre a falha na exclusão.
            throw new DaoException("Erro ao excluir Serviço", e); // Lança exceção personalizada.
        } finally {
            JpaUtil.closeEntityManager(manager); // Fecha o EntityManager de forma segura.
        }
    }

    public ServicoBean selecionar(Integer codigo) throws DaoException { // Método para selecionar um serviço específico com base no código.
        EntityManager manager = JpaUtil.getEntityManager(); // Obtém o EntityManager.
        try {
            return manager.find(ServicoBean.class, codigo); // Busca e retorna o serviço pelo código.
        } finally {
            JpaUtil.closeEntityManager(manager); // Fecha o EntityManager de forma segura.
        }
    }

    public Collection<ServicoBean> listar() throws DaoException { // Método para listar todos os serviços do banco de dados.
        EntityManager manager = JpaUtil.getEntityManager(); // Obtém o EntityManager.
        try {
            Query query = manager.createQuery("from ServicoBean"); // Cria uma consulta para buscar todos os serviços.
            return query.getResultList(); // Executa a consulta e retorna a lista de serviços.
        } finally {
            JpaUtil.closeEntityManager(manager); // Fecha o EntityManager de forma segura.
        }
    }
}