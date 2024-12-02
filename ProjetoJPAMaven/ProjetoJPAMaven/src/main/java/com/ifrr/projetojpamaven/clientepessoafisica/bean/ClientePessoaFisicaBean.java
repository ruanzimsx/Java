/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ifrr.projetojpamaven.clientepessoafisica.bean; // Declara o pacote para a classe de entidade Cliente Pessoa Física

import com.ifrr.projetojpamaven.cliente.bean.ClienteBean; // Importa a classe base de Cliente
import javax.persistence.DiscriminatorValue; // Importa anotação para definir valor discriminador em herança de entidades
import javax.persistence.Entity; // Importa anotação para marcar a classe como entidade JPA

/**
 *
 * @author mayunia-sti
 */
@Entity // Marca a classe como uma entidade persistente no banco de dados
@DiscriminatorValue("ClienteFisica") // Define o valor discriminador para esta subclasse na estratégia de herança
public class ClientePessoaFisicaBean extends ClienteBean { // Declara classe de Cliente Pessoa Física que herda de ClienteBean
    private String cpf; // Declara atributo privado para armazenar o CPF do cliente

    public String getCpf() { // Método getter para recuperar o CPF
        return cpf; // Retorna o valor do CPF
    }

    public void setCpf(String cpf) { // Método setter para definir o CPF
        this.cpf = cpf; // Atribui o valor do CPF ao atributo da classe
    }
}