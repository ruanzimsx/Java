package com.ifrr.projetojpamaven.banco.teste;

import com.ifrr.projetojpamaven.banco.bean.BancoBean;
import com.ifrr.projetojpamaven.banco.dao.BancoDao;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DaoException;

/**
 * Classe de teste para listar BancoBean
 * @author [seu nome]
 */
public class TesteListarBanco {
    public static void main(String[] args) {
        // Declaração da lista de bancos
        ArrayList<BancoBean> bancos;
        
        // Criando instância do BancoDao
        BancoDao bancoDao = new BancoDao();
        
        try {
            // Listando todos os bancos
            bancos = (ArrayList<BancoBean>) bancoDao.listar();
            
            // Verificando se há bancos cadastrados
            if (bancos.isEmpty()) {
                System.out.println("Nenhum banco cadastrado.");
            } else {
                // Cabeçalho da listagem
                System.out.println("===== LISTA DE BANCOS =====");
                System.out.printf("%-5s | %-20s\n", 
                    "Código", "Nome");
                System.out.println("-----------------------------------");
                
                // Iterando sobre os bancos
                for (BancoBean banco : bancos) {
                    // Formatando a saída
                    System.out.printf("%-5d | %-20s\n", 
                        banco.getCodigo(), 
                        banco.getNome());
                }
                
                // Rodapé com total de bancos
                System.out.println("-----------------------------------");
                System.out.println("Total de Bancos: " + bancos.size());
            }
        } catch (DaoException ex) {
            // Tratamento de exceção usando logger
            Logger.getLogger(TesteListarBanco.class.getName()).log(
                Level.SEVERE, 
                "Erro ao listar bancos", 
                ex
            );
        }
    }
}