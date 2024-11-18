/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifrr.projetojpamaven.conta.teste; // Declara o pacote de teste para Conta

import com.ifrr.projetojpamaven.conta.bean.ContaBean; // Importa classe de entidade Conta
import com.ifrr.projetojpamaven.conta.dao.ContaDao; // Importa classe de acesso a dados de Conta
import java.util.logging.Level; // Importa nível de log
import java.util.logging.Logger; // Importa utilitário de log
import util.DaoException; // Importa exceção personalizada de persistência

public class TesteAlterarConta { // Declara classe de teste para alteração de Conta
    public static void main(String[] args) { // Método principal de execução
        ContaBean conta = new ContaBean(); // Cria nova instância de ContaBean
        conta.setCodigo(11); // Define código da conta a ser alterada
        conta.setNome("Teste1"); // Define novo nome para a conta
        conta.setSaldo(200f); // Define novo saldo para a conta
        conta.setLimite(1000f); // Define novo limite para a conta
        
        ContaDao cd = new ContaDao(); // Cria instância de ContaDao para persistência
        try {
            cd.alterar(conta); // Tenta alterar a conta no banco de dados
        } catch (DaoException ex) { // Captura exceção de persistência
            // Registra erro de log em caso de falha na alteração
            Logger.getLogger(TesteInserirConta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}