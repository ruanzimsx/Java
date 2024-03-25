
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
public class PrincipalConta {

    public static void main(String agrs[]) {
        Conta c1;
        c1 = new Conta();
        c1.setNumero(1545);
        c1.setSaldo(25000);
        c1.setLimite(10000);
        c1.setNome("Arrascaeta");
        
        String dataAbertura = "14/07/2004";
        c1.setDataDeAbertura(dataAbertura);
        
        System.out.println(c1.getRecuperaDadosParaImpressao());
        //c1.calculoRendimento();        c1.getRecuperaDadosParaImpressao();

       
//        c1.deposita(1500);   
//        JOptionPane.showMessageDialog(null,"O novo saldo de c1 = "+c1.saldo);
//        if(c1.saca(50000) == true){
//            JOptionPane.showMessageDialog(null, "Saque Ok");
//        }else{
//            JOptionPane.showMessageDialog(null, "saque Nok");
//        }
//        Conta c2 = new Conta();
//        c2.numero = 2312;
//        c2.saldo = 13000;
//        c2.limite = 2500;
//        c2.nome = "Pablo";
//
//        c1.transfere1(c2, 5000);
//        JOptionPane.showMessageDialog(null, "O novo saldo de c1 = " + c1.saldo);
//        JOptionPane.showMessageDialog(null, "O novo saldo de c1 = " + c2.saldo);
//
//      
//        double total = c1.saldo + c2.saldo;
//        JOptionPane.showMessageDialog(null, " Saldo total = "+total);
//        double totalGeral = c1.saldo + c1.limite + c2.saldo + c2.limite;
//        JOptionPane.showMessageDialog(null, " Total geral = "+totalGeral);
    }
}
