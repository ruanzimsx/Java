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
public class TesteAlterar {
        public static void main(String[] args) {
        ContaBean conta = new ContaBean();
        conta.setCodigo(1);
        conta.setNome("Teste1");
        conta.setSaldo(200f);
        conta.setLimite(1000f);
        
        ContaDao cd = new ContaDao();
        try {
            cd.alterar(conta);
        } catch (DaoException ex) {
            Logger.getLogger(TesteInserir.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
