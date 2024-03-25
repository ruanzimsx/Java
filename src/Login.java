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
public class Login {
    public static void main(String[] args) {
        String dado = JOptionPane.showInputDialog("Informe seu nome? ");
        String dado1 = JOptionPane.showInputDialog("Digite sua idade: ");
        int idade = Integer.parseInt(dado1);
        JOptionPane.showMessageDialog(null, "Ola "+dado+" sua idade "+idade);
    }
}
