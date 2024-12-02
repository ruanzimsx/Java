/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ifrr.projetojpamaven.clientepessoajuridica.bean; // Declara o pacote para a classe de entidade Cliente Pessoa Jurídica

import com.ifrr.projetojpamaven.cliente.bean.ClienteBean; // Importa a classe base de Cliente
import javax.persistence.DiscriminatorValue; // Importa anotação para definir valor discriminador em herança de entidades
import javax.persistence.Entity; // Importa anotação para marcar a classe como entidade JPA

/**
 *
 * @author mayunia-sti
 */
@Entity // Marca a classe como uma entidade persistente no banco de dados
@DiscriminatorValue("ClienteJuridica") // Define o valor discriminador para esta subclasse na estratégia de herança
public class ClientePessoaJuridicaBean extends ClienteBean { // Declara classe de Cliente Pessoa Jurídica que herda de ClienteBean
    private String cnpj; // Declara atributo privado para armazenar o CNPJ do cliente

    public String getCnpj() { // Método getter para recuperar o CNPJ
        return cnpj; // Retorna o valor do CNPJ
    }

    public void setCnpj(String cnpj) { // Método setter para definir o CNPJ
        this.cnpj = cnpj; // Atribui o valor do CNPJ ao atributo da classe
    }
}