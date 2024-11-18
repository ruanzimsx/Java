/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifrr.projetojpamaven.conta.teste; // Declara o pacote de teste para Conta

import com.ifrr.projetojpamaven.banco.bean.BancoBean; // Importa classe de entidade Banco
import com.ifrr.projetojpamaven.cliente.bean.ClienteBean; // Importa classe de entidade Cliente
import com.ifrr.projetojpamaven.conta.bean.ContaBean; // Importa classe de entidade Conta
import com.ifrr.projetojpamaven.conta.dao.ContaDao; // Importa classe de acesso a dados de Conta
import java.util.logging.Level; // Importa nível de log
import java.util.logging.Logger; // Importa utilitário de log
import util.DaoException; // Importa exceção personalizada de persistência

public class TesteInserirConta { // Declara classe de teste para inserção de Conta

    public static void main(String[] args) { // Método principal de execução
        ContaBean conta = new ContaBean(); // Cria nova instância de ContaBean
        conta.setNome("Teste"); // Define nome da conta
        conta.setSaldo(1010f); // Define saldo da conta
        conta.setLimite((float)5050); // Define limite da conta
        conta.setBancoBean(new BancoBean(1)); // Associa banco com código 1
        conta.setClienteBean(new ClienteBean(1)); // Associa cliente com código 1

        ContaDao cd = new ContaDao(); // Cria instância de ContaDao para persistência
        try {
            cd.inserir(conta); // Tenta inserir a conta no banco de dados
        } catch (DaoException ex) { // Captura exceção de persistência
            // Registra erro de log em caso de falha na inserção
            Logger.getLogger(TesteInserirConta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}