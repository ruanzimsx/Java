import javax.swing.JOptionPane;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TADS
 */
public class Classe3 {
    public static void main(String args[]){
        String dados = JOptionPane.showInputDialog("Informe o valor: ");
        JOptionPane.showMessageDialog(null, "O valor informado foi: " +dados);
    }
}
