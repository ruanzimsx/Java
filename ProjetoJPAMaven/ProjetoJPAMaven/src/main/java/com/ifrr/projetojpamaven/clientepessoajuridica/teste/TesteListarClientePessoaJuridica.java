package com.ifrr.projetojpamaven.clientepessoajuridica.teste; // Declara o pacote para testes de Cliente Pessoa Jurídica

// Importações necessárias para manipulação de cliente pessoa jurídica e tratamento de exceções
import com.ifrr.projetojpamaven.clientepessoajuridica.bean.ClientePessoaJuridicaBean; // Importa classe de entidade Cliente Pessoa Jurídica
import com.ifrr.projetojpamaven.clientepessoajuridica.dao.ClientePessoaJuridicaDao; // Importa classe de acesso a dados de Cliente Pessoa Jurídica
import java.util.List; // Importa interface para listas
import java.util.logging.Level; // Importa níveis de log para tratamento de erros
import java.util.logging.Logger; // Importa utilitário de log para registro de eventos
import util.DaoException; // Importa exceção personalizada para camada de persistência

public class TesteListarClientePessoaJuridica { // Declara classe de teste para listagem de Clientes Pessoa Jurídica
    public static void main(String[] args) { // Método principal de execução do teste
        ClientePessoaJuridicaDao cd = new ClientePessoaJuridicaDao(); // Cria instância de DAO para persistência
        
        try { // Bloco de tratamento de exceções
            List<ClientePessoaJuridicaBean> clientes = (List<ClientePessoaJuridicaBean>) cd.listar(); // Recupera lista de clientes pessoa jurídica
            
            if (!clientes.isEmpty()) { // Verifica se há clientes na lista
                System.out.println("Listagem Completa de Clientes Pessoa Jurídica:"); // Cabeçalho da listagem
                System.out.println("-------------------------------");
                
                // Imprime cabeçalho da tabela com formatação
                System.out.printf("%-5s | %-30s | %-20s%n", 
                    "Cód.", "Nome", "CNPJ");
                System.out.println("-------------------------------------------------------------");
                
                // Itera sobre os clientes para impressão
                for (ClientePessoaJuridicaBean cliente : clientes) {
                    // Imprime detalhes de cada cliente com formatação
                    System.out.printf("%-5d | %-30s | %-20s%n", 
                        cliente.getCodigo(), 
                        cliente.getNome(),
                        cliente.getCnpj());
                }
                
                // Imprime rodapé com total de clientes
                System.out.println("-------------------------------------------------------------");
                System.out.printf("Total de Clientes Pessoa Jurídica: %d%n", clientes.size());
                
            } else {
                System.out.println("Nenhum cliente pessoa jurídica encontrado."); // Mensagem caso não haja clientes
            }
        } catch (DaoException ex) { // Captura exceção específica de persistência
            // Registra erro de log com nível SEVERE
            Logger.getLogger(TesteListarClientePessoaJuridica.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erro ao listar clientes pessoa jurídica: " + ex.getMessage()); // Imprime mensagem de erro detalhada
        }
    }
}