package com.ifrr.projetojpamaven.banco.teste;

import com.ifrr.projetojpamaven.banco.dao.BancoDao;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DaoException;

/**
 * Classe de teste para exclusão de um BancoBean
 * @author Pierre Jr
 */
public class TesteExcluirBanco {
    public static void main(String[] args) {
        // Criando instância do BancoDao
        BancoDao bancoDao = new BancoDao();
        
        try {
            // Código do banco a ser excluído
            Integer codigoBanco = 2;
            
            // Tentando excluir o banco
            Boolean exclusaoRealizada = bancoDao.excluir(codigoBanco);
            
            // Verificando o resultado da exclusão
            if (exclusaoRealizada) {
                System.out.println("Banco com código " + codigoBanco + " excluído com sucesso!");
            } else {
                System.out.println("Não foi possível excluir o banco com código " + codigoBanco + 
                                   ". Verifique se o banco existe.");
            }
        } catch (DaoException ex) {
            // Tratamento de exceção usando logger
            Logger.getLogger(TesteExcluirBanco.class.getName()).log(
                Level.SEVERE, 
                "Erro ao tentar excluir banco", 
                ex
            );
        }
    }
}