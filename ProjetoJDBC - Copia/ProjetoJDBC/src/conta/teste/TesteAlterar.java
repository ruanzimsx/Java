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
public class TesteAlterar {
    public static void main(String[] args) {
        ContaBean conta = new ContaBean();
        conta.setNome("Maria");
        conta.setSaldo(6500f);
        conta.setLimite(3500f);
        conta.setCodigo(1);
        
        ContaDao cd = new ContaDao();
        try {
            cd.alterar(conta);
        } catch (DaoException ex) {
            Logger.getLogger(TesteAlterar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
