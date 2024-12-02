package com.ifrr.projetojpamaven.servico.teste; // Declara o pacote de teste para Servico.

import com.ifrr.projetojpamaven.servico.dao.ServicoDao; // Importa a classe ServicoDao para persistência de serviços.
import com.ifrr.projetojpamaven.conta.bean.ContaBean; // Importa a classe ContaBean para manipulação de contas.
import com.ifrr.projetojpamaven.conta.dao.ContaDao; // Importa a classe ContaDao para persistência de contas.
import java.util.logging.Level; // Importa nível de log para gerenciamento de logs.
import java.util.logging.Logger; // Importa utilitário de log para registrar mensagens de log.
import util.DaoException; // Importa exceção personalizada para tratamento de erros de persistência.

public class TesteExcluirServico { // Declara a classe de teste para exclusão de Servico.

    public static void main(String[] args) { // Método principal de execução do teste.
        ServicoDao servicoDao = new ServicoDao(); // Cria instância de ServicoDao para operações de serviço.
        ContaDao contaDao = new ContaDao(); // Cria instância de ContaDao para operações de conta.

        try {
            boolean servicoExcluido = servicoDao.excluir(1); // Tenta excluir o serviço com código 1.
            if (servicoExcluido) { // Verifica se o serviço foi excluído.
                System.out.println("Serviço excluído com sucesso.");
            }
            
            boolean contaExcluida = contaDao.excluir(2); // Tenta excluir a conta com código 2.
            if (contaExcluida) { // Verifica se a conta foi excluída.
                System.out.println("Conta excluída com sucesso.");
            }
        } catch (DaoException ex) { // Captura exceção de persistência.
            Logger.getLogger(TesteExcluirServico.class.getName()).log(Level.SEVERE, null, ex); // Registra erro de log.
        }
    }
}