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

public class TesteSelecionarConta { // Declara classe de teste para seleção de Conta
    public static void main(String[] args) { // Método principal de execução
        ContaBean conta; // Declara variável para armazenar conta
        
        ContaDao cd = new ContaDao(); // Cria instância de ContaDao para persistência
        try {
            conta = cd.selecionar(1); // Tenta selecionar conta com código 1
            System.out.println(conta.getSaldo()); // Imprime saldo da conta selecionada
        } catch (DaoException ex) { // Captura exceção de persistência
            // Registra erro de log em caso de falha na seleção
            Logger.getLogger(TesteSelecionarConta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}