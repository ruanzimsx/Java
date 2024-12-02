package com.ifrr.projetojpamaven.clientepessoafisica.teste; // Declara o pacote para testes de Cliente Pessoa Física

// Importações necessárias para manipulação de cliente pessoa física e tratamento de exceções
import com.ifrr.projetojpamaven.clientepessoafisica.bean.ClientePessoaFisicaBean; // Importa classe de entidade Cliente Pessoa Física
import com.ifrr.projetojpamaven.clientepessoafisica.dao.ClientePessoaFisicaDao; // Importa classe de acesso a dados de Cliente Pessoa Física
import java.util.logging.Level; // Importa níveis de log para tratamento de erros
import java.util.logging.Logger; // Importa utilitário de log para registro de eventos
import util.DaoException; // Importa exceção personalizada para camada de persistência

public class TesteInserirClientePessoaFisica { // Declara classe de teste para inserção de Cliente Pessoa Física
    public static void main(String[] args) { // Método principal de execução do teste
        ClientePessoaFisicaBean cliente = new ClientePessoaFisicaBean(); // Cria nova instância de Cliente Pessoa Física
        cliente.setNome("João da Silva"); // Define nome do cliente
        cliente.setCpf("123.456.789-00"); // Define CPF do cliente

        ClientePessoaFisicaDao cd = new ClientePessoaFisicaDao(); // Cria instância de DAO para persistência
        try { // Bloco de tratamento de exceções
            cd.inserir(cliente); // Tenta inserir o cliente no banco de dados
            System.out.println("Cliente Pessoa Física inserido com sucesso!"); // Mensagem de sucesso
        } catch (DaoException ex) { // Captura exceção específica de persistência
            // Registra erro de log com nível SEVERE
            Logger.getLogger(TesteInserirClientePessoaFisica.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erro ao inserir Cliente Pessoa Física: " + ex.getMessage()); // Imprime mensagem de erro detalhada
        }
    }
}