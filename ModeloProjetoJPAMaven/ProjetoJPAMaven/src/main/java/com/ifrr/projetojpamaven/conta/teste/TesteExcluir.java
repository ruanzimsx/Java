/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifrr.projetojpamaven.conta.teste;

import com.ifrr.projetojpamaven.conta.dao.ContaDao;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DaoException;

/**
 *
 * @author mayunia
 */
public class TesteExcluir {
    public static void main(String[] args) {
        ContaDao cd = new ContaDao();
        try {
            cd.excluir(1);
        } catch (DaoException ex) {
            Logger.getLogger(TesteExcluir.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
