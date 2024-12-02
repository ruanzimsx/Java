package com.ifrr.projetojpamaven.clientepessoajuridica.teste; // Declara o pacote para testes de Cliente Pessoa Jurídica

// Importações necessárias para manipulação de cliente pessoa jurídica e tratamento de exceções
import com.ifrr.projetojpamaven.clientepessoajuridica.bean.ClientePessoaJuridicaBean; // Importa classe de entidade Cliente Pessoa Jurídica
import com.ifrr.projetojpamaven.clientepessoajuridica.dao.ClientePessoaJuridicaDao; // Importa classe de acesso a dados de Cliente Pessoa Jurídica
import java.util.logging.Level; // Importa níveis de log para tratamento de erros
import java.util.logging.Logger; // Importa utilitário de log para registro de eventos
import util.DaoException; // Importa exceção personalizada para camada de persistência

public class TesteInserirClientePessoaJuridica { // Declara classe de teste para inserção de Cliente Pessoa Jurídica
    public static void main(String[] args) { // Método principal de execução do teste
        ClientePessoaJuridicaBean cliente = new ClientePessoaJuridicaBean(); // Cria nova instância de Cliente Pessoa Jurídica
        cliente.setNome("Empresa Exemplo LTDA"); // Define nome da empresa
        cliente.setCnpj("12.345.678/0001-90"); // Define CNPJ da empresa

        ClientePessoaJuridicaDao cd = new ClientePessoaJuridicaDao(); // Cria instância de DAO para persistência
        try { // Bloco de tratamento de exceções
            cd.inserir(cliente); // Tenta inserir o cliente no banco de dados
            System.out.println("Cliente Pessoa Jurídica inserido com sucesso!"); // Mensagem de sucesso
        } catch (DaoException ex) { // Captura exceção específica de persistência
            // Registra erro de log com nível SEVERE
            Logger.getLogger(TesteInserirClientePessoaJuridica.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erro ao inserir Cliente Pessoa Jurídica: " + ex.getMessage()); // Imprime mensagem de erro detalhada
        }
    }
}