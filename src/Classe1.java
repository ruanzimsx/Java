/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TADS
 */
public class Classe1 {
    public static void main(String args[]){
        double gastoJan = 15000, gastoFev = 23000, gastoMar = 17000, gastoTotal;
        double media;
        gastoTotal = gastoJan + gastoFev + gastoMar;
        media = gastoTotal / 3;
        System.out.println("Gasto total trimestre = R$ " + gastoTotal);
        System.out.println("Media Trimestral = R$ " + media);
    }
}
