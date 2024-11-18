/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifrr.projetojpamaven.cliente.teste; // Declara o pacote de teste para Cliente

import com.ifrr.projetojpamaven.cliente.dao.ClienteDao; // Importa classe de acesso a dados de Cliente
import java.util.logging.Level; // Importa nível de log
import java.util.logging.Logger; // Importa utilitário de log
import util.DaoException; // Importa exceção personalizada de persistência

public class TesteExcluirCliente { // Declara classe de teste para exclusão de Cliente
    public static void main(String[] args) { // Método principal de execução
        ClienteDao cd = new ClienteDao(); // Cria instância de ClienteDao para persistência
        try {
            // Tenta excluir cliente com código 1 no banco de dados
            boolean clienteExcluido = cd.excluir(1);
            
            // Verifica se a exclusão foi bem-sucedida
            if (clienteExcluido) {
                System.out.println("Cliente excluído com sucesso!"); // Mensagem de sucesso
            } else {
                System.out.println("Cliente não encontrado ou não pode ser excluído."); // Mensagem de falha
            }
        } catch (DaoException ex) { // Captura exceção de persistência
            // Registra erro de log em caso de falha na exclusão
            Logger.getLogger(TesteExcluirCliente.class.getName()).log(Level.SEVERE, null, ex);
            
            // Opcional: Imprimir mensagem mais detalhada
            System.err.println("Erro ao excluir cliente: " + ex.getMessage());
        }
    }
}