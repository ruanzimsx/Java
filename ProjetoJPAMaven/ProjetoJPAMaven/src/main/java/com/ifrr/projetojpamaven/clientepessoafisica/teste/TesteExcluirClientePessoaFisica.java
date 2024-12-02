package com.ifrr.projetojpamaven.clientepessoafisica.teste; // Declara o pacote para testes de Cliente Pessoa Física

// Importações necessárias para manipulação de cliente pessoa física e tratamento de exceções
import com.ifrr.projetojpamaven.clientepessoafisica.dao.ClientePessoaFisicaDao; // Importa classe de acesso a dados de Cliente Pessoa Física
import java.util.logging.Level; // Importa níveis de log para tratamento de erros
import java.util.logging.Logger; // Importa utilitário de log para registro de eventos
import util.DaoException; // Importa exceção personalizada para camada de persistência

public class TesteExcluirClientePessoaFisica { // Declara classe de teste para exclusão de Cliente Pessoa Física
    public static void main(String[] args) { // Método principal de execução do teste
        ClientePessoaFisicaDao cd = new ClientePessoaFisicaDao(); // Cria instância de DAO para persistência
        try { // Bloco de tratamento de exceções
            boolean clienteExcluido = cd.excluir(1); // Tenta excluir cliente com código 1 no banco de dados
            
            if (clienteExcluido) { // Verifica se a exclusão foi bem-sucedida
                System.out.println("Cliente Pessoa Física excluído com sucesso!"); // Mensagem de sucesso
            } else {
                System.out.println("Cliente Pessoa Física não encontrado ou não pode ser excluído."); // Mensagem de falha
            }
        } catch (DaoException ex) { // Captura exceção específica de persistência
            // Registra erro de log com nível SEVERE
            Logger.getLogger(TesteExcluirClientePessoaFisica.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erro ao excluir Cliente Pessoa Física: " + ex.getMessage()); // Imprime mensagem de erro detalhada
        }
    }
}