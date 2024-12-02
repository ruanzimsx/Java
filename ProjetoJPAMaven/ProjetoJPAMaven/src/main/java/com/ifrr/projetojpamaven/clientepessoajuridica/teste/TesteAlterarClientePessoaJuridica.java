package com.ifrr.projetojpamaven.clientepessoajuridica.teste; // Declara o pacote para testes de Cliente Pessoa Jurídica

// Importações necessárias para manipulação de cliente pessoa jurídica e tratamento de exceções
import com.ifrr.projetojpamaven.clientepessoajuridica.bean.ClientePessoaJuridicaBean; // Importa classe de entidade Cliente Pessoa Jurídica
import com.ifrr.projetojpamaven.clientepessoajuridica.dao.ClientePessoaJuridicaDao; // Importa classe de acesso a dados de Cliente Pessoa Jurídica
import java.util.logging.Level; // Importa níveis de log para tratamento de erros
import java.util.logging.Logger; // Importa utilitário de log para registro de eventos
import util.DaoException; // Importa exceção personalizada para camada de persistência

public class TesteAlterarClientePessoaJuridica { // Declara classe de teste para alteração de Cliente Pessoa Jurídica
    public static void main(String[] args) { // Método principal de execução do teste
        ClientePessoaJuridicaBean cliente = new ClientePessoaJuridicaBean(); // Cria nova instância de Cliente Pessoa Jurídica
        cliente.setCodigo(1); // Define código do cliente a ser alterado
        cliente.setNome("Empresa Exemplo LTDA - Atualizada"); // Define novo nome para o cliente
        cliente.setCnpj("12.345.678/0001-91"); // Define novo CNPJ para o cliente

        ClientePessoaJuridicaDao cd = new ClientePessoaJuridicaDao(); // Cria instância de DAO para persistência
        try { // Bloco de tratamento de exceções
            cd.alterar(cliente); // Tenta alterar o cliente no banco de dados
            System.out.println("Cliente Pessoa Jurídica alterado com sucesso!"); // Mensagem de sucesso
        } catch (DaoException ex) { // Captura exceção específica de persistência
            // Registra erro de log com nível SEVERE
            Logger.getLogger(TesteAlterarClientePessoaJuridica.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erro ao alterar Cliente Pessoa Jurídica: " + ex.getMessage()); // Imprime mensagem de erro detalhada
        }
    }
}