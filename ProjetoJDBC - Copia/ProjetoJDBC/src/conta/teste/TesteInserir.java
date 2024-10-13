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
public class TesteInserir {
    public static void main(String[] args) {
        ContaBean conta = new ContaBean();
        conta.setNome("Ruan");
        conta.setSaldo(1000f);
        conta.setLimite(2000f);
        
        ContaDao cd = new ContaDao();
       
        try {
            cd.inserir(conta);
        } catch (DaoException ex) {
            Logger.getLogger(TesteInserir.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
}
