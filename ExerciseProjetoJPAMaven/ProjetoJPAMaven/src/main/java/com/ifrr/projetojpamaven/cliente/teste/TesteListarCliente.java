/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifrr.projetojpamaven.cliente.teste; // Declara o pacote de teste para Cliente

import com.ifrr.projetojpamaven.cliente.bean.ClienteBean; // Importa classe de entidade Cliente
import com.ifrr.projetojpamaven.cliente.dao.ClienteDao; // Importa classe de acesso a dados de Cliente
import java.util.List; // Importa interface de lista
import java.util.logging.Level; // Importa nível de log
import java.util.logging.Logger; // Importa utilitário de log
import util.DaoException; // Importa exceção personalizada de persistência

public class TesteListarCliente { // Declara classe de teste para listagem de Clientes
    public static void main(String[] args) { // Método principal de execução
        ClienteDao cd = new ClienteDao(); // Cria instância de ClienteDao para persistência
        
        try {
            // Recupera lista de clientes
            List<ClienteBean> clientes = (List<ClienteBean>) cd.listar();
            
            // Verifica se há clientes
            if (!clientes.isEmpty()) {
                System.out.println("Listagem Completa de Clientes:");
                System.out.println("-------------------------------");
                
                // Cabeçalho da tabela
                System.out.printf("%-5s | %-20s | %-25s | %-15s%n", 
                    "Cód.", "Nome", "Conta", "Saldo Conta");
                System.out.println("-------------------------------------------------------------");
                
                // Itera sobre os clientes
                for (ClienteBean cliente : clientes) {
                    // Imprime detalhes do cliente
                    System.out.printf("%-5d | %-20s | ", 
                        cliente.getCodigo(), 
                        cliente.getNome());
                    
                    // Verifica se cliente possui conta
                    if (cliente.getContaBean() != null) {
                        System.out.printf("%-25s | R$ %-10.2f%n", 
                            cliente.getContaBean().getNome(), 
                            cliente.getContaBean().getSaldo());
                    } else {
                        System.out.printf("%-25s | %-15s%n", 
                            "Sem Conta", "N/A");
                    }
                }
                
                // Rodapé com total de clientes
                System.out.println("-------------------------------------------------------------");
                System.out.printf("Total de Clientes: %d%n", clientes.size());
                
            } else {
                System.out.println("Nenhum cliente encontrado.");
            }
        } catch (DaoException ex) { // Captura exceção de persistência
            // Registra erro de log em caso de falha na listagem
            Logger.getLogger(TesteListarCliente.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erro ao listar clientes: " + ex.getMessage());
        }
    }
}