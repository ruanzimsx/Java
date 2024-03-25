/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TADS
 */
public class Conta {

    private int numero;
    private double saldo;
    private double limite;
    private String nome;
    private  String dataDeAbertura;

    public void deposita(double valor) {
        this.setSaldo(this.getSaldo() + valor);
    }

    public boolean saca(double valor) {
        if (valor <= this.getSaldo() + getLimite()) {
            setSaldo(getSaldo() - valor);
            return true;
        } else {
            return false;
        }
    }

    public boolean transfere(Conta destino, double valor) {
        if (valor <= getSaldo() + getLimite()) {
            setSaldo(getSaldo() - valor);
            destino.setSaldo(getSaldo() + valor);
            return true;
        } else {
            return false;
        }
    }
    public boolean transfere1(Conta destino, double valor) {
        if (saca(valor) == true) {
            destino.deposita(valor);
            return true;
        } else {
            return false;
        }
    }
    public String getRecuperaDadosParaImpressao(){
        String dados = "Nome: "+this.getNome();
        dados += "\nData: "+this.getDataDeAbertura();
        dados += "\nSaldo: "+this.getSaldo();
        dados += "\nLimite: "+this.getLimite();
        dados += "\nNumero: "+this.getNumero();
        return dados;
    }
    public void calculoRendimento(){
        System.out.println("Rendimento: "+this.getSaldo()*0.1);
    }

    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * @return the saldo
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * @param saldo the saldo to set
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /**
     * @return the limite
     */
    public double getLimite() {
        return limite;
    }

    /**
     * @param limite the limite to set
     */
    public void setLimite(double limite) {
        this.limite = limite;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the dataDeAbertura
     */
    public String getDataDeAbertura() {
        return dataDeAbertura;
    }

    /**
     * @param dataDeAbertura the dataDeAbertura to set
     */
    public void setDataDeAbertura(String dataDeAbertura) {
        this.dataDeAbertura = dataDeAbertura;
    }
}
