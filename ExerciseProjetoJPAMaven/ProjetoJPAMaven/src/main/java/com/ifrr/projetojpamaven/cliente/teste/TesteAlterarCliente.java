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

public class TesteAlterarCliente { // Declara classe de teste para alteração de Cliente
    public static void main(String[] args) { // Método principal de execução
        ClienteBean cliente = new ClienteBean(); // Cria nova instância de ClienteBean
        cliente.setCodigo(1); // Define código do cliente a ser alterado
        cliente.setNome("João da Silva Atualizado"); // Define novo nome para o cliente
        
        ClienteDao cd = new ClienteDao(); // Cria instância de ClienteDao para persistência
        try {
            cd.alterar(cliente); // Tenta alterar o cliente no banco de dados
        } catch (DaoException ex) { // Captura exceção de persistência
            // Registra erro de log em caso de falha na alteração
            Logger.getLogger(TesteAlterarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}