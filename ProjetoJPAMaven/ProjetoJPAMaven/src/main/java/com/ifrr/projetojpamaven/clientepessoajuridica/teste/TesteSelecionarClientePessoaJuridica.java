package com.ifrr.projetojpamaven.clientepessoajuridica.teste; // Declara o pacote para testes de Cliente Pessoa Jurídica

// Importações necessárias para manipulação de cliente pessoa jurídica e tratamento de exceções
import com.ifrr.projetojpamaven.clientepessoajuridica.bean.ClientePessoaJuridicaBean; // Importa classe de entidade Cliente Pessoa Jurídica
import com.ifrr.projetojpamaven.clientepessoajuridica.dao.ClientePessoaJuridicaDao; // Importa classe de acesso a dados de Cliente Pessoa Jurídica
import java.util.logging.Level; // Importa níveis de log para tratamento de erros
import java.util.logging.Logger; // Importa utilitário de log para registro de eventos
import util.DaoException; // Importa exceção personalizada para camada de persistência

public class TesteSelecionarClientePessoaJuridica { // Declara classe de teste para seleção de Cliente Pessoa Jurídica
    public static void main(String[] args) { // Método principal de execução do teste
        ClientePessoaJuridicaBean cliente; // Declara variável para armazenar cliente selecionado
        
        ClientePessoaJuridicaDao cd = new ClientePessoaJuridicaDao(); // Cria instância de DAO para persistência
        try { // Bloco de tratamento de exceções
            cliente = cd.selecionar(1); // Tenta selecionar cliente com código 1
            
            if (cliente != null) { // Verifica se cliente foi encontrado
                System.out.println("Detalhes do Cliente Pessoa Jurídica:"); // Cabeçalho dos detalhes
                System.out.println("-------------------");
                System.out.println("Código: " + cliente.getCodigo()); // Imprime código do cliente
                System.out.println("Nome: " + cliente.getNome()); // Imprime nome do cliente
                System.out.println("CNPJ: " + cliente.getCnpj()); // Imprime CNPJ do cliente
            } else {
                System.out.println("Cliente Pessoa Jurídica não encontrado."); // Mensagem caso cliente não exista
            }
        } catch (DaoException ex) { // Captura exceção específica de persistência
            // Registra erro de log com nível SEVERE
            Logger.getLogger(TesteSelecionarClientePessoaJuridica.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erro ao selecionar cliente pessoa jurídica: " + ex.getMessage()); // Imprime mensagem de erro detalhada
        }
    }
}