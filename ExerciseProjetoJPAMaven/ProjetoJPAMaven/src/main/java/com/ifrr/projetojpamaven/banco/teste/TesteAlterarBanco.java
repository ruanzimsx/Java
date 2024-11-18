package com.ifrr.projetojpamaven.banco.teste;

import com.ifrr.projetojpamaven.banco.bean.BancoBean;
import com.ifrr.projetojpamaven.banco.dao.BancoDao;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DaoException;

/**
 * Classe de teste para alterar um BancoBean
 *
 * @author [seu nome]
 */
public class TesteAlterarBanco {

    public static void main(String[] args) {
        // Criando um novo objeto BancoBean
        BancoBean banco = new BancoBean();

        // Definindo os atributos do banco
        banco.setCodigo(1); // Código do banco a ser alterado
        banco.setNome("Banco Exemplo Alterado"); // Novo nome

        // Criando instância do BancoDao
        BancoDao bancoDao = new BancoDao();

        try {
            // Tentando alterar o banco
            banco = bancoDao.alterar(banco);

            // Mensagem de sucesso
            System.out.println("Banco alterado com sucesso!");
            System.out.println("Código: " + banco.getCodigo());
            System.out.println("Nome: " + banco.getNome());
        } catch (DaoException ex) {
            // Tratamento de exceção usando logger
            Logger.getLogger(TesteAlterarBanco.class.getName()).log(Level.SEVERE, "Erro ao alterar banco", ex);
        }
    }
}
