package com.ifrr.projetojpamaven.clientepessoajuridica.dao; // Declaração do pacote para a classe de acesso a dados de Cliente Pessoa Jurídica

// Importações das classes e interfaces necessárias
import com.ifrr.projetojpamaven.clientepessoajuridica.bean.ClientePessoaJuridicaBean; // Importa a classe de entidade Cliente Pessoa Jurídica
import java.util.Collection; // Importa interface para coleções
import javax.persistence.EntityManager; // Importa gerenciador de entidades JPA
import javax.persistence.EntityTransaction; // Importa gerenciador de transações
import javax.persistence.Query; // Importa interface para consultas
import util.DaoException; // Importa exceção personalizada para camada de persistência
import com.ifrr.projetojpamaven.util.JpaUtil; // Importa utilitário para gerenciamento de EntityManager

public class ClientePessoaJuridicaDao { // Declaração da classe de acesso a dados para Cliente Pessoa Jurídica

    public ClientePessoaJuridicaBean inserir(ClientePessoaJuridicaBean obj) throws DaoException { // Método para inserir novo cliente pessoa jurídica
        EntityManager manager = JpaUtil.getEntityManager(); // Obtém gerenciador de entidades utilizando a classe utilitária JpaUtil
        EntityTransaction tx = manager.getTransaction(); // Inicia uma transação com o banco de dados
        try {
            tx.begin(); // Inicia a transação
            manager.persist(obj); // Persiste o objeto no banco de dados
            tx.commit(); // Confirma a transação
        } catch (Exception e) { // Captura qualquer exceção
            if (tx.isActive()) tx.rollback(); // Se a transação ainda estiver ativa, faz rollback
            System.err.println("Erro ao inserir Cliente Pessoa Jurídica: " + e.getMessage()); // Imprime mensagem de erro no console
            throw new DaoException("Erro ao inserir Cliente Pessoa Jurídica", e); // Lança exceção personalizada com detalhes do erro
        } finally {
            JpaUtil.closeEntityManager(manager); // Fecha o gerenciador de entidades, independentemente do resultado
        }
        return obj; // Retorna o objeto inserido
    }

    public ClientePessoaJuridicaBean alterar(ClientePessoaJuridicaBean obj) throws DaoException { // Método para alterar um cliente pessoa jurídica existente
        EntityManager manager = JpaUtil.getEntityManager(); // Obtém gerenciador de entidades
        EntityTransaction tx = manager.getTransaction(); // Inicia uma transação
        try {
            tx.begin(); // Inicia a transação
            obj = manager.merge(obj); // Atualiza o objeto no banco de dados usando merge
            tx.commit(); // Confirma a transação
        } catch (Exception e) { // Captura qualquer exceção
            if (tx.isActive()) tx.rollback(); // Se a transação ainda estiver ativa, faz rollback
            System.err.println("Erro ao alterar Cliente Pessoa Jurídica: " + e.getMessage()); // Imprime mensagem de erro no console
            throw new DaoException("Erro ao alterar Cliente Pessoa Jurídica", e); // Lança exceção personalizada com detalhes do erro
        } finally {
            JpaUtil.closeEntityManager(manager); // Fecha o gerenciador de entidades
        }
        return obj; // Retorna o objeto alterado
    }

    public Boolean excluir(Integer codigo) throws DaoException { // Método para excluir um cliente pessoa jurídica
        EntityManager manager = JpaUtil.getEntityManager(); // Obtém gerenciador de entidades
        EntityTransaction tx = manager.getTransaction(); // Inicia uma transação
        try {
            tx.begin(); // Inicia a transação
            ClientePessoaJuridicaBean cliente = manager.find(ClientePessoaJuridicaBean.class, codigo); // Busca o cliente pelo código
            if (cliente != null) { // Verifica se o cliente existe
                manager.remove(cliente); // Remove o cliente do banco de dados
                tx.commit(); // Confirma a transação
                return true; // Retorna true indicando exclusão bem-sucedida
            } else {
                System.err.println("Cliente Pessoa Jurídica com o código " + codigo + " não encontrado."); // Imprime mensagem se o cliente não for encontrado
                return false; // Retorna false indicando que a exclusão não foi realizada
            }
        } catch (Exception e) { // Captura qualquer exceção
            if (tx.isActive()) tx.rollback(); // Se a transação ainda estiver ativa, faz rollback
            System.err.println("Erro ao excluir Cliente Pessoa Jurídica: " + e.getMessage()); // Imprime mensagem de erro no console
            throw new DaoException("Erro ao excluir Cliente Pessoa Jurídica", e); // Lança exceção personalizada com detalhes do erro
        } finally {
            JpaUtil.closeEntityManager(manager); // Fecha o gerenciador de entidades
        }
    }

    public ClientePessoaJuridicaBean selecionar(Integer codigo) throws DaoException { // Método para selecionar um cliente pessoa jurídica pelo código
        EntityManager manager = JpaUtil.getEntityManager(); // Obtém gerenciador de entidades
        try {
            return manager.find(ClientePessoaJuridicaBean.class, codigo); // Busca e retorna o cliente pelo código
        } catch (Exception e) { // Captura qualquer exceção
            System.err.println("Erro ao selecionar Cliente Pessoa Jurídica: " + e.getMessage()); // Imprime mensagem de erro no console
            throw new DaoException("Erro ao selecionar Cliente Pessoa Jurídica", e); // Lança exceção personalizada com detalhes do erro
        } finally {
            JpaUtil.closeEntityManager(manager); // Fecha o gerenciador de entidades
        }
    }

    public Collection<ClientePessoaJuridicaBean> listar() throws DaoException { // Método para listar todos os clientes pessoa jurídica
        EntityManager manager = JpaUtil.getEntityManager(); // Obtém gerenciador de entidades
        try {
            Query query = manager.createQuery("from ClientePessoaJuridicaBean"); // Cria consulta para buscar todos os clientes pessoa jurídica
            return query.getResultList(); // Retorna a lista de resultados
        } catch (Exception e) { // Captura qualquer exceção
            System.err.println("Erro ao listar Clientes Pessoa Jurídica: " + e.getMessage()); // Imprime mensagem de erro no console
            throw new DaoException("Erro ao listar Clientes Pessoa Jurídica", e); // Lança exceção personalizada com detalhes do erro
        } finally {
            JpaUtil.closeEntityManager(manager); // Fecha o gerenciador de entidades
        }
    }

    public ClientePessoaJuridicaBean buscarPorCNPJ(String cnpj) throws DaoException { // Método adicional para buscar cliente pessoa jurídica por CNPJ
        EntityManager manager = JpaUtil.getEntityManager(); // Obtém gerenciador de entidades
        try {
            Query query = manager.createQuery("FROM ClientePessoaJuridicaBean WHERE cnpj = :cnpj"); // Cria consulta para buscar cliente pelo CNPJ
            query.setParameter("cnpj", cnpj); // Define o parâmetro CNPJ na consulta
            
            return query.getResultList().isEmpty() ? null : (ClientePessoaJuridicaBean) query.getSingleResult(); // Retorna null se nenhum resultado for encontrado, senão retorna o primeiro resultado
        } catch (Exception e) { // Captura qualquer exceção
            System.err.println("Erro ao buscar Cliente Pessoa Jurídica por CNPJ: " + e.getMessage()); // Imprime mensagem de erro no console
            throw new DaoException("Erro ao buscar Cliente Pessoa Jurídica por CNPJ", e); // Lança exceção personalizada com detalhes do erro
        } finally {
            JpaUtil.closeEntityManager(manager); // Fecha o gerenciador de entidades
        }
    }

    public Collection<ClientePessoaJuridicaBean> buscarPorRazaoSocial(String razaoSocial) throws DaoException { // Método adicional para buscar cliente pessoa jurídica por Razão Social
        EntityManager manager = JpaUtil.getEntityManager(); // Obtém gerenciador de entidades
        try {
            Query query = manager.createQuery("FROM ClientePessoaJuridicaBean WHERE razaoSocial LIKE :razaoSocial"); // Cria consulta para buscar clientes pela razão social (usando like para busca parcial)
            query.setParameter("razaoSocial", "%" + razaoSocial + "%"); // Define o parâmetro razão social na consulta, permitindo busca parcial
            
            return query.getResultList(); // Retorna a lista de resultados
        } catch (Exception e) { // Captura qualquer exceção
            System.err.println("Erro ao buscar Cliente Pessoa Jurídica por Razão Social: " + e.getMessage()); // Imprime mensagem de erro no console
            throw new DaoException("Erro ao buscar Cliente Pessoa Jurídica por Razão Social", e); // Lança exceção personalizada com detalhes do erro
        } finally {
            JpaUtil.closeEntityManager(manager); // Fecha o gerenciador de entidades
        }
    }
}