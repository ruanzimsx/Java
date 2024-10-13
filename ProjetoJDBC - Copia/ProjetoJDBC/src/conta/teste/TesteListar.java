/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conta.teste;

import conta.bean.ContaBean;
import conta.dao.ContaDao;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DaoException;

/**
 *
 * @author stirr
 */
public class TesteListar {
    public static void main(String[] args) {
        ContaDao cd = new ContaDao();
        try {
            ArrayList<ContaBean> contas = (ArrayList<ContaBean>) cd.listar();
            for (ContaBean conta : contas) {
                System.out.println(conta.getCodigo()+"-"+conta.getNome());
            }
        } catch (DaoException ex) {
            Logger.getLogger(TesteListar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
