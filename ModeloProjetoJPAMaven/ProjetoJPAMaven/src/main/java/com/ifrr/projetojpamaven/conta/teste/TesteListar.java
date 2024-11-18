/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifrr.projetojpamaven.conta.teste;

import com.ifrr.projetojpamaven.conta.bean.ContaBean;
import com.ifrr.projetojpamaven.conta.dao.ContaDao;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DaoException;

/**
 *
 * @author mayunia
 */
public class TesteListar {
    public static void main(String[] args) {
        ArrayList<ContaBean> contas;
        ContaDao cd = new ContaDao();
        try {
            contas = (ArrayList<ContaBean>) cd.listar();
            for (ContaBean conta : contas) {
                System.out.println("O saldo é "+conta.getSaldo());
            }
        } catch (DaoException ex) {
            Logger.getLogger(TesteListar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
