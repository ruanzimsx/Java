/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifrr.projetojpamaven.conta.teste; // Declara o pacote de teste para Conta

import com.ifrr.projetojpamaven.conta.bean.ContaBean; // Importa classe de entidade Conta
import com.ifrr.projetojpamaven.conta.dao.ContaDao; // Importa classe de acesso a dados de Conta
import java.util.ArrayList; // Importa classe de lista dinâmica
import java.util.logging.Level; // Importa nível de log
import java.util.logging.Logger; // Importa utilitário de log
import util.DaoException; // Importa exceção personalizada de persistência

public class TesteListarConta { // Declara classe de teste para listagem de Contas
    public static void main(String[] args) { // Método principal de execução
        ArrayList<ContaBean> contas; // Declara lista para armazenar contas
        ContaDao cd = new ContaDao(); // Cria instância de ContaDao para persistência
        try {
            // Recupera lista de contas e faz cast para ArrayList
            contas = (ArrayList<ContaBean>) cd.listar();
            
            // Itera sobre cada conta na lista
            for (ContaBean conta : contas) {
                // Imprime o saldo de cada conta
                System.out.println("O saldo é " + conta.getSaldo());
            }
        } catch (DaoException ex) { // Captura exceção de persistência
            // Registra erro de log em caso de falha na listagem
            Logger.getLogger(TesteListarConta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}