package com.ifrr.projetojpamaven.clientepessoafisica.teste; // Declara o pacote para testes de Cliente Pessoa Física

// Importações necessárias para manipulação de cliente pessoa física e tratamento de exceções
import com.ifrr.projetojpamaven.clientepessoafisica.bean.ClientePessoaFisicaBean; // Importa classe de entidade Cliente Pessoa Física
import com.ifrr.projetojpamaven.clientepessoafisica.dao.ClientePessoaFisicaDao; // Importa classe de acesso a dados de Cliente Pessoa Física
import java.util.logging.Level; // Importa níveis de log para tratamento de erros
import java.util.logging.Logger; // Importa utilitário de log para registro de eventos
import util.DaoException; // Importa exceção personalizada para camada de persistência

public class TesteAlterarClientePessoaFisica { // Declara classe de teste para alteração de Cliente Pessoa Física
    public static void main(String[] args) { // Método principal de execução do teste
        ClientePessoaFisicaBean cliente = new ClientePessoaFisicaBean(); // Cria nova instância de Cliente Pessoa Física
        cliente.setCodigo(1); // Define código do cliente a ser alterado
        cliente.setNome("João da Silva Atualizado"); // Define novo nome para o cliente
        cliente.setCpf("987.654.321-00"); // Define novo CPF para o cliente

        ClientePessoaFisicaDao cd = new ClientePessoaFisicaDao(); // Cria instância de DAO para persistência
        try { // Bloco de tratamento de exceções
            cd.alterar(cliente); // Tenta alterar o cliente no banco de dados
            System.out.println("Cliente Pessoa Física alterado com sucesso!"); // Mensagem de sucesso
        } catch (DaoException ex) { // Captura exceção específica de persistência
            // Registra erro de log com nível SEVERE
            Logger.getLogger(TesteAlterarClientePessoaFisica.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erro ao alterar Cliente Pessoa Física: " + ex.getMessage()); // Imprime mensagem de erro detalhada
        }
    }
}