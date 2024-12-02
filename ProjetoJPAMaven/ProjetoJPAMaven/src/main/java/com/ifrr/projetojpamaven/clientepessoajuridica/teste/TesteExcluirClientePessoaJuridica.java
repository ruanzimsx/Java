package com.ifrr.projetojpamaven.clientepessoajuridica.teste; // Declara o pacote para testes de Cliente Pessoa Jurídica

// Importações necessárias para manipulação de cliente pessoa jurídica e tratamento de exceções
import com.ifrr.projetojpamaven.clientepessoajuridica.dao.ClientePessoaJuridicaDao; // Importa classe de acesso a dados de Cliente Pessoa Jurídica
import java.util.logging.Level; // Importa níveis de log para tratamento de erros
import java.util.logging.Logger; // Importa utilitário de log para registro de eventos
import util.DaoException; // Importa exceção personalizada para camada de persistência

public class TesteExcluirClientePessoaJuridica { // Declara classe de teste para exclusão de Cliente Pessoa Jurídica
    public static void main(String[] args) { // Método principal de execução do teste
        ClientePessoaJuridicaDao cd = new ClientePessoaJuridicaDao(); // Cria instância de DAO para persistência
        try { // Bloco de tratamento de exceções
            boolean clienteExcluido = cd.excluir(1); // Tenta excluir cliente com código 1 no banco de dados
            
            if (clienteExcluido) { // Verifica se a exclusão foi bem-sucedida
                System.out.println("Cliente Pessoa Jurídica excluído com sucesso!"); // Mensagem de sucesso
            } else {
                System.out.println("Cliente Pessoa Jurídica não encontrado ou não pode ser excluído."); // Mensagem de falha
            }
        } catch (DaoException ex) { // Captura exceção específica de persistência
            // Registra erro de log com nível SEVERE
            Logger.getLogger(TesteExcluirClientePessoaJuridica.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erro ao excluir Cliente Pessoa Jurídica: " + ex.getMessage()); // Imprime mensagem de erro detalhada
        }
    }
}