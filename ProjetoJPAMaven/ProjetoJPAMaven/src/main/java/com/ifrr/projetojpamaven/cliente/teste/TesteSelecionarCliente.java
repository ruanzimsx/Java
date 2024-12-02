/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifrr.projetojpamaven.cliente.teste; // Declara o pacote de teste para Cliente

import com.ifrr.projetojpamaven.cliente.bean.ClienteBean; // Importa classe de entidade Cliente
import com.ifrr.projetojpamaven.cliente.dao.ClienteDao; // Importa classe de acesso a dados de Cliente
import java.util.logging.Level; // Importa nível de log
import java.util.logging.Logger; // Importa utilitário de log
import util.DaoException; // Importa exceção personalizada de persistência

public class TesteSelecionarCliente { // Declara classe de teste para seleção de Cliente
    public static void main(String[] args) { // Método principal de execução
        ClienteBean cliente; // Declara variável para armazenar cliente
        
        ClienteDao cd = new ClienteDao(); // Cria instância de ClienteDao para persistência
        try {
            cliente = cd.selecionar(1); // Tenta selecionar cliente com código 1
            
            // Verificação de nulidade
            if (cliente != null) {
                // Impressão de detalhes completos do cliente
                System.out.println("Detalhes do Cliente:");
                System.out.println("-------------------");
                System.out.println("Código: " + cliente.getCodigo());
                System.out.println("Nome: " + cliente.getNome());
                
                // Verificação de conta associada
                if (cliente.getContaBean() != null) {
                    System.out.println("\nDetalhes da Conta:");
                    System.out.println("Nome da Conta: " + cliente.getContaBean().getNome());
                    System.out.println("Saldo: R$ " + cliente.getContaBean().getSaldo());
                    System.out.println("Limite: R$ " + cliente.getContaBean().getLimite());
                } else {
                    System.out.println("\nCliente não possui conta associada.");
                }
            } else {
                System.out.println("Cliente não encontrado.");
            }
        } catch (DaoException ex) { // Captura exceção de persistência
            // Registra erro de log em caso de falha na seleção
            Logger.getLogger(TesteSelecionarCliente.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erro ao selecionar cliente: " + ex.getMessage());
        }
    }
}