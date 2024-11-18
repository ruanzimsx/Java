/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifrr.projetojpamaven.conta.teste;

import com.ifrr.projetojpamaven.conta.bean.ContaBean;
import com.ifrr.projetojpamaven.conta.dao.ContaDao;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DaoException;

/**
 *
 * @author mayunia
 */
public class TesteInserir {

    public static void main(String[] args) {
        ContaBean conta = new ContaBean();
        conta.setNome("Teste");
        conta.setSaldo(888f);
        conta.setLimite(66666f);

        ContaDao cd = new ContaDao();
        try {
            cd.inserir(conta);
        } catch (DaoException ex) {
            Logger.getLogger(TesteInserir.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
