
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
public class Classe5 {
     public static void main(String args[]){
        String dado = JOptionPane.showInputDialog("Informe o preco: ");
        float valor = Float.parseFloat(dado);
        valor += 100;
        JOptionPane.showMessageDialog(null, "O preco novo é =  " +valor);
    }
}
