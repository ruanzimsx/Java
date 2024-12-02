package com.ifrr.projetojpamaven.servico.teste; // Declara o pacote de teste para Servico.

import com.ifrr.projetojpamaven.servico.bean.ServicoBean; // Importa a classe ServicoBean para manipulação de serviços.
import com.ifrr.projetojpamaven.servico.dao.ServicoDao; // Importa a classe ServicoDao para persistência de serviços.
import com.ifrr.projetojpamaven.conta.bean.ContaBean; // Importa a classe ContaBean para manipulação de contas.
import com.ifrr.projetojpamaven.conta.dao.ContaDao; // Importa a classe ContaDao para persistência de contas.
import java.util.logging.Level; // Importa nível de log para gerenciamento de logs.
import java.util.logging.Logger; // Importa utilitário de log para registrar mensagens de log.
import util.DaoException; // Importa exceção personalizada para tratamento de erros de persistência.

public class TesteAlterarServico { // Declara a classe de teste para alteração de Servico.

    public static void main(String[] args) { // Método principal de execução do teste.

        ContaDao contaDao = new ContaDao(); // Cria instância de ContaDao para operações de conta.
        ServicoDao servicoDao = new ServicoDao(); // Cria instância de ServicoDao para operações de serviço.

        try {
            ServicoBean servico = servicoDao.selecionar(1); // Seleciona o serviço pelo ID.
            if (servico == null) { // Verifica se o serviço foi encontrado.
                System.out.println("Serviço não encontrado.");
                return; // Sai do método se o serviço não for encontrado.
            }

            ContaBean conta = contaDao.selecionar(2); // Seleciona a conta pelo ID.
            if (conta == null) { // Verifica se a conta foi encontrada.
                System.out.println("Conta não encontrada.");
                return; // Sai do método se a conta não for encontrada.
            }

            servico.getContas().add(conta); // Adiciona a conta ao serviço.
            conta.getServicos().add(servico); // Adiciona o serviço à conta para manter a sincronização.

            servicoDao.alterar(servico); // Altera o serviço no banco de dados.
            contaDao.alterar(conta); // Altera a conta no banco de dados para garantir a persistência do relacionamento.

        } catch (DaoException ex) { // Captura exceção de persistência.
            Logger.getLogger(TesteAlterarServico.class.getName()).log(Level.SEVERE, null, ex); // Registra erro de log.
        }
    }
}