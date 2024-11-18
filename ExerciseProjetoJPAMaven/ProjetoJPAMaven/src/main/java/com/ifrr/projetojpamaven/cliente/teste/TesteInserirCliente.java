package com.ifrr.projetojpamaven.cliente.teste; // Declara o pacote de teste para Cliente

import com.ifrr.projetojpamaven.cliente.bean.ClienteBean; // Importa classe de entidade Cliente
import com.ifrr.projetojpamaven.cliente.dao.ClienteDao; // Importa classe de acesso a dados de Cliente
import java.util.logging.Level; // Importa nível de log
import java.util.logging.Logger; // Importa utilitário de log
import util.DaoException; // Importa exceção personalizada de persistência

public class TesteInserirCliente { // Declara classe de teste para inserção de Cliente

    public static void main(String[] args) { // Método principal de execução
        ClienteBean cliente = new ClienteBean(); // Cria nova instância de ClienteBean
        cliente.setNome("João da Silva"); // Define nome do cliente

        ClienteDao cd = new ClienteDao(); // Cria instância de ClienteDao para persistência
        try {
            cd.inserir(cliente); // Tenta inserir o cliente no banco de dados
        } catch (DaoException ex) { // Captura exceção de persistência
            // Registra erro de log em caso de falha na inserção
            Logger.getLogger(TesteInserirCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}