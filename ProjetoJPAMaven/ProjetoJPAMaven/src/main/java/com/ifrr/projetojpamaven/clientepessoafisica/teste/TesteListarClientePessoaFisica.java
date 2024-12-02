package com.ifrr.projetojpamaven.clientepessoafisica.teste; // Declara o pacote para testes de Cliente Pessoa Física

// Importações necessárias para manipulação de cliente pessoa física e tratamento de exceções
import com.ifrr.projetojpamaven.clientepessoafisica.bean.ClientePessoaFisicaBean; // Importa classe de entidade Cliente Pessoa Física
import com.ifrr.projetojpamaven.clientepessoafisica.dao.ClientePessoaFisicaDao; // Importa classe de acesso a dados de Cliente Pessoa Física
import java.util.List; // Importa interface para listas
import java.util.logging.Level; // Importa níveis de log para tratamento de erros
import java.util.logging.Logger; // Importa utilitário de log para registro de eventos
import util.DaoException; // Importa exceção personalizada para camada de persistência

public class TesteListarClientePessoaFisica { // Declara classe de teste para listagem de Clientes Pessoa Física
    public static void main(String[] args) { // Método principal de execução do teste
        ClientePessoaFisicaDao cd = new ClientePessoaFisicaDao(); // Cria instância de DAO para persistência
        
        try { // Bloco de tratamento de exceções
            List<ClientePessoaFisicaBean> clientes = (List<ClientePessoaFisicaBean>) cd.listar(); // Recupera lista de clientes pessoa física
            
            if (!clientes.isEmpty()) { // Verifica se há clientes na lista
                System.out.println("Listagem Completa de Clientes Pessoa Física:"); // Cabeçalho da listagem
                System.out.println("-------------------------------");
                
                // Imprime cabeçalho da tabela com formatação
                System.out.printf("%-5s | %-20s | %-15s | %-25s%n", 
                    "Cód.", "Nome", "CPF", "Email");
                System.out.println("-------------------------------------------------------------");
                
                // Itera sobre os clientes para impressão
                for (ClientePessoaFisicaBean cliente : clientes) {
                    // Imprime detalhes de cada cliente com formatação
                    System.out.printf("%-5d | %-20s | %-15s | %-25s%n", 
                        cliente.getCodigo(), 
                        cliente.getNome(),
                        cliente.getCpf());
                }
                
                // Imprime rodapé com total de clientes
                System.out.println("-------------------------------------------------------------");
                System.out.printf("Total de Clientes Pessoa Física: %d%n", clientes.size());
                
            } else {
                System.out.println("Nenhum cliente pessoa física encontrado."); // Mensagem caso não haja clientes
            }
        } catch (DaoException ex) { // Captura exceção específica de persistência
            // Registra erro de log com nível SEVERE
            Logger.getLogger(TesteListarClientePessoaFisica.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erro ao listar clientes pessoa física: " + ex.getMessage()); // Imprime mensagem de erro detalhada
        }
    }
}