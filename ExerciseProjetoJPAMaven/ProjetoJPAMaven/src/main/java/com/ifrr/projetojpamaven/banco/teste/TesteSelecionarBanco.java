package com.ifrr.projetojpamaven.banco.teste;

import com.ifrr.projetojpamaven.banco.bean.BancoBean;
import com.ifrr.projetojpamaven.banco.dao.BancoDao;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DaoException;

/**
 * Classe de teste para selecionar um BancoBean
 * @author Pierre Jr
 */
public class TesteSelecionarBanco {
    public static void main(String[] args) {
        // Declaração da variável para armazenar o banco selecionado
        BancoBean banco;
        
        // Criando instância do BancoDao
        BancoDao bancoDao = new BancoDao();
        
        try {
            // Código do banco a ser selecionado
            Integer codigoBanco = 1;
            
            // Selecionando o banco
            banco = bancoDao.selecionar(codigoBanco);
            
            // Verificando se o banco foi encontrado
            if (banco != null) {
                // Imprimindo informações do banco
                System.out.println("Banco Selecionado:");
                System.out.println("Código: " + banco.getCodigo());
                System.out.println("Nome: " + banco.getNome());
                System.out.println("Contas: "+ banco.getContasBean());
            } else {
                System.out.println("Banco com código " + codigoBanco + " não encontrado.");
            }
        } catch (DaoException ex) {
            // Tratamento de exceção usando logger
            Logger.getLogger(TesteSelecionarBanco.class.getName()).log(
                Level.SEVERE, 
                "Erro ao selecionar banco", 
                ex
            );
        }
    }
}