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
public class TesteSelecionar {
    public static void main(String[] args) {
        ContaBean conta;
        
        ContaDao cd = new ContaDao();
        try {
            conta = cd.selecionar(1);
            System.out.println(conta.getSaldo());
        } catch (DaoException ex) {
            Logger.getLogger(TesteSelecionar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
