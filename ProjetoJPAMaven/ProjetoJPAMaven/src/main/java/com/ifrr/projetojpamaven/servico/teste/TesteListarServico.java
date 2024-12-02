package com.ifrr.projetojpamaven.servico.teste; // Declara o pacote de teste para Servico.

import com.ifrr.projetojpamaven.servico.bean.ServicoBean; // Importa a classe ServicoBean para manipulação de serviços.
import com.ifrr.projetojpamaven.servico.dao.ServicoDao; // Importa a classe ServicoDao para persistência de serviços.
import com.ifrr.projetojpamaven.conta.bean.ContaBean; // Importa a classe ContaBean para manipulação de contas.
import java.util.ArrayList; // Importa a classe ArrayList para listas dinâmicas.
import java.util.logging.Level; // Importa nível de log para gerenciamento de logs.
import java.util.logging.Logger; // Importa utilitário de log para registrar mensagens de log.
import util.DaoException; // Importa exceção personalizada para tratamento de erros de persistência.

public class TesteListarServico { // Declara a classe de teste para listagem de Servicos.

    public static void main(String[] args) { // Método principal de execução do teste.
        ServicoDao servicoDao = new ServicoDao(); // Cria instância de ServicoDao para operações de serviço.
        try {
            ArrayList<ServicoBean> servicos = (ArrayList<ServicoBean>) servicoDao.listar(); // Recupera lista de serviços.
            for (ServicoBean servico : servicos) { // Itera sobre cada serviço na lista.
                System.out.println("Serviço: " + servico.getDescricao()); // Imprime a descrição do serviço.
                for (ContaBean conta : servico.getContas()) { // Itera sobre as contas associadas ao serviço.
                    System.out.println("  Conta associada: " + conta.getNome() + " com saldo " + conta.getSaldo()); // Imprime detalhes da conta.
                }
            }
        } catch (DaoException ex) { // Captura exceção de persistência.
            Logger.getLogger(TesteListarServico.class.getName()).log(Level.SEVERE, null, ex); // Registra erro de log.
        }
    }
}