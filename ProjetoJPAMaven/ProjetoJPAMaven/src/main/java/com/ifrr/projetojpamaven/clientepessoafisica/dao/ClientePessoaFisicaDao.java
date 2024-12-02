package com.ifrr.projetojpamaven.clientepessoafisica.dao; // Declaração do pacote para a classe de acesso a dados de Cliente Pessoa Física

// Importações das classes e interfaces necessárias
import com.ifrr.projetojpamaven.clientepessoafisica.bean.ClientePessoaFisicaBean; // Importa a classe de entidade Cliente Pessoa Física
import java.util.Collection; // Importa interface para coleções
import javax.persistence.EntityManager; // Importa gerenciador de entidades JPA
import javax.persistence.EntityTransaction; // Importa gerenciador de transações
import javax.persistence.Query; // Importa interface para consultas
import util.DaoException; // Importa exceção personalizada para camada de persistência
import com.ifrr.projetojpamaven.util.JpaUtil; // Importa utilitário para gerenciamento de EntityManager

public class ClientePessoaFisicaDao { // Declaração da classe de acesso a dados para Cliente Pessoa Física

    public ClientePessoaFisicaBean inserir(ClientePessoaFisicaBean obj) throws DaoException { // Método para inserir novo cliente pessoa física
        EntityManager manager = JpaUtil.getEntityManager(); // Obtém gerenciador de entidades utilizando a classe utilitária JpaUtil
        EntityTransaction tx = manager.getTransaction(); // Inicia uma transação com o banco de dados
        try {
            tx.begin(); // Inicia a transação
            manager.persist(obj); // Persiste o objeto no banco de dados
            tx.commit(); // Confirma a transação
        } catch (Exception e) { // Captura qualquer exceção
            if (tx.isActive()) tx.rollback(); // Se a transação ainda estiver ativa, faz rollback
            System.err.println("Erro ao inserir Cliente Pessoa Física: " + e.getMessage()); // Imprime mensagem de erro no console
            throw new DaoException("Erro ao inserir Cliente Pessoa Física", e); // Lança exceção personalizada com detalhes do erro
        } finally {
            JpaUtil.closeEntityManager(manager); // Fecha o gerenciador de entidades, independentemente do resultado
        }
        return obj; // Retorna o objeto inserido
    }

    public ClientePessoaFisicaBean alterar(ClientePessoaFisicaBean obj) throws DaoException { // Método para alterar um cliente pessoa física existente
        EntityManager manager = JpaUtil.getEntityManager(); // Obtém gerenciador de entidades
        EntityTransaction tx = manager.getTransaction(); // Inicia uma transação
        try {
            tx.begin(); // Inicia a transação
            obj = manager.merge(obj); // Atualiza o objeto no banco de dados usando merge
            tx.commit(); // Confirma a transação
        } catch (Exception e) { // Captura qualquer exceção
            if (tx.isActive()) tx.rollback(); // Se a transação ainda estiver ativa, faz rollback
            System.err.println("Erro ao alterar Cliente Pessoa Física: " + e.getMessage()); // Imprime mensagem de erro no console
            throw new DaoException("Erro ao alterar Cliente Pessoa Física", e); // Lança exceção personalizada com detalhes do erro
        } finally {
            JpaUtil.closeEntityManager(manager); // Fecha o gerenciador de entidades
        }
        return obj; // Retorna o objeto alterado
    }

    public Boolean excluir(Integer codigo) throws DaoException { // Método para excluir um cliente pessoa física
        EntityManager manager = JpaUtil.getEntityManager(); // Obtém gerenciador de entidades
        EntityTransaction tx = manager.getTransaction(); // Inicia uma transação
        try {
            tx.begin(); // Inicia a transação
            ClientePessoaFisicaBean cliente = manager.find(ClientePessoaFisicaBean.class, codigo); // Busca o cliente pelo código
            if (cliente != null) { // Verifica se o cliente existe
                manager.remove(cliente); // Remove o cliente do banco de dados
                tx.commit(); // Confirma a transação
                return true; // Retorna true indicando exclusão bem-sucedida
            } else {
                System.err.println("Cliente Pessoa Física com o código " + codigo + " não encontrado."); // Imprime mensagem se o cliente não for encontrado
                return false; // Retorna false indicando que a exclusão não foi realizada
            }
        } catch (Exception e) { // Captura qualquer exceção
            if (tx.isActive()) tx.rollback(); // Se a transação ainda estiver ativa, faz rollback
            System.err.println("Erro ao excluir Cliente Pessoa Física: " + e.getMessage()); // Imprime mensagem de erro no console
            throw new DaoException("Erro ao excluir Cliente Pessoa Física", e); // Lança exceção personalizada com detalhes do erro
        } finally {
            JpaUtil.closeEntityManager(manager); // Fecha o gerenciador de entidades
        }
    }

    public ClientePessoaFisicaBean selecionar(Integer codigo) throws DaoException { // Método para selecionar um cliente pessoa física pelo código
        EntityManager manager = JpaUtil.getEntityManager(); // Obtém gerenciador de entidades
        try {
            return manager.find(ClientePessoaFisicaBean.class, codigo); // Busca e retorna o cliente pelo código
        } catch (Exception e) { // Captura qualquer exceção
            System.err.println("Erro ao selecionar Cliente Pessoa Física: " + e.getMessage()); // Imprime mensagem de erro no console
            throw new DaoException("Erro ao selecionar Cliente Pessoa Física", e); // Lança exceção personalizada com detalhes do erro
        } finally {
            JpaUtil.closeEntityManager(manager); // Fecha o gerenciador de entidades
        }
    }

    public Collection<ClientePessoaFisicaBean> listar() throws DaoException { // Método para listar todos os clientes pessoa física
        EntityManager manager = JpaUtil.getEntityManager(); // Obtém gerenciador de entidades
        try {
            Query query = manager.createQuery("from ClientePessoaFisicaBean"); // Cria consulta para buscar todos os clientes pessoa física
            return query.getResultList(); // Retorna a lista de resultados
        } catch (Exception e) { // Captura qualquer exceção
            System.err.println("Erro ao listar Clientes Pessoa Física: " + e.getMessage()); // Imprime mensagem de erro no console
            throw new DaoException("Erro ao listar Clientes Pessoa Física", e); // Lança exceção personalizada com detalhes do erro
        } finally {
            JpaUtil.closeEntityManager(manager); // Fecha o gerenciador de entidades
        }
    }

    public ClientePessoaFisicaBean buscarPorCPF(String cpf) throws DaoException { // Método adicional para buscar cliente pessoa física por CPF
        EntityManager manager = JpaUtil.getEntityManager(); // Obtém gerenciador de entidades
        try {
            Query query = manager.createQuery("FROM ClientePessoaFisicaBean WHERE cpf = :cpf"); // Cria consulta para buscar cliente pelo CPF
            query.setParameter("cpf", cpf); // Define o parâmetro CPF na consulta
            
            return query.getResultList().isEmpty() ? null : (ClientePessoaFisicaBean) query.getSingleResult(); // Retorna null se nenhum resultado for encontrado, senão retorna o primeiro resultado
        } catch (Exception e) { // Captura qualquer exceção
            System.err.println("Erro ao buscar Cliente Pessoa Física por CPF: " + e.getMessage()); // Imprime mensagem de erro no console
            throw new DaoException("Erro ao buscar Cliente Pessoa Física por CPF", e); // Lança exceção personalizada com detalhes do erro
        } finally {
            JpaUtil.closeEntityManager(manager); // Fecha o gerenciador de entidades
        }
    }
}