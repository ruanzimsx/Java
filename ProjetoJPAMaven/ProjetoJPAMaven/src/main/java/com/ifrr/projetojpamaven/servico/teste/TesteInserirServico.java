package com.ifrr.projetojpamaven.servico.teste; // Declara o pacote de teste para Servico.

import com.ifrr.projetojpamaven.servico.bean.ServicoBean; // Importa a classe ServicoBean para manipulação de serviços.
import com.ifrr.projetojpamaven.servico.dao.ServicoDao; // Importa a classe ServicoDao para persistência de serviços.
import com.ifrr.projetojpamaven.conta.bean.ContaBean; // Importa a classe ContaBean para manipulação de contas.
import com.ifrr.projetojpamaven.conta.dao.ContaDao; // Importa a classe ContaDao para persistência de contas.
import java.util.logging.Level; // Importa nível de log para gerenciamento de logs.
import java.util.logging.Logger; // Importa utilitário de log para registrar mensagens de log.
import util.DaoException; // Importa exceção personalizada para tratamento de erros de persistência.

public class TesteInserirServico { // Declara a classe de teste para inserção de Servico.

    public static void main(String[] args) { // Método principal de execução do teste.
        ServicoBean servico = new ServicoBean(); // Cria uma nova instância de ServicoBean.
        servico.setDescricao("Novo Serviço"); // Define a descrição do serviço.

        ContaBean conta = new ContaBean(); // Cria uma nova instância de ContaBean.
        conta.setNome("Conta Associada"); // Define o nome da conta.
        conta.setSaldo(2500f); // Define o saldo da conta.
        conta.setLimite(1000f); // Define o limite da conta.

        ContaDao contaDao = new ContaDao(); // Cria instância de ContaDao para operações de conta.
        ServicoDao servicoDao = new ServicoDao(); // Cria instância de ServicoDao para operações de serviço.

        try { // Inicia bloco try para capturar exceções durante a persistência.
            contaDao.inserir(conta); // Insere a conta no banco de dados.
            servicoDao.inserir(servico); // Insere o serviço no banco de dados.
            
            // Estabelece o relacionamento após salvar ambos os objetos.
            conta.getServicos().add(servico); // Adiciona o serviço à lista de serviços da conta.

            // Atualiza ambos os objetos para refletir a associação.
            contaDao.alterar(conta); // Atualiza a conta com a nova associação.

        } catch (DaoException ex) { // Captura exceção de persistência.
            Logger.getLogger(TesteInserirServico.class.getName()).log(Level.SEVERE, null, ex); // Registra erro de log.
        }
    }
}