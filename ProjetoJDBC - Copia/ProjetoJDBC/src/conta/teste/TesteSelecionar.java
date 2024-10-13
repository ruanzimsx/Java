/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conta.teste;

import conta.bean.ContaBean;
import conta.dao.ContaDao;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DaoException;

/**
 *
 * @author stirr
 */
public class TesteSelecionar {
    
    public static void main(String[] args) {
        ContaDao cd = new ContaDao();
        try {
            ContaBean conta = (ContaBean) cd.selecionar(1);
            System.out.println(conta.getCodigo()+"-"+conta.getNome());
        } catch (DaoException ex) {
            Logger.getLogger(TesteSelecionar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
