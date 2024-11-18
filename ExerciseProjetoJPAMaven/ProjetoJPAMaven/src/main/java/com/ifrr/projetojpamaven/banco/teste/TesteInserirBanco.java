/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ifrr.projetojpamaven.banco.teste; // Declaração do pacote de teste

// Importação da classe BancoBean para criação do objeto
import com.ifrr.projetojpamaven.banco.bean.BancoBean;
// Importação da classe BancoDao para persistência
import com.ifrr.projetojpamaven.banco.dao.BancoDao;
// Importações para tratamento de logs de exceção
import java.util.logging.Level;
import java.util.logging.Logger;
// Importação de exceção personalizada para camada de persistência
import util.DaoException;

/**
 * Classe de teste para inserção de Banco
 * @author Pierre
 */
public class TesteInserirBanco { // Definição da classe de teste
    public static void main(String[] args) { // Método principal de execução
        BancoBean bancoBean = new BancoBean(); // Instanciação de um novo objeto BancoBean
        bancoBean.setNome("Banco do Brasil"); // Definição do nome do banco
        
        BancoDao bancoDao = new BancoDao(); // Criação de objeto para acesso a dados
        try { // Bloco de tratamento de exceções
            bancoDao.inserir(bancoBean); // Chamada do método de inserção do banco
        } catch (DaoException ex) { // Captura de exceção específica de persistência
            // Log de erro em caso de falha na inserção
            Logger.getLogger(TesteInserirBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}