/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ifrr.projetojpamaven.cliente.bean; // Declaração do pacote da entidade Cliente

import com.ifrr.projetojpamaven.conta.bean.ContaBean; // Importação da classe ContaBean para relacionamento
import java.io.Serializable; // Interface para serialização de objetos
import java.util.Objects; // Utilitário para comparação de objetos
import javax.persistence.Column; // Anotação para mapeamento de colunas
import javax.persistence.Entity; // Anotação para definir entidade JPA
import javax.persistence.GeneratedValue; // Anotação para geração automática de ID
import javax.persistence.GenerationType; // Enum de estratégias de geração de ID
import javax.persistence.Id; // Anotação para definir chave primária
import javax.persistence.OneToOne; // Anotação para relacionamento um-para-um
import javax.persistence.Table; // Anotação para definir nome da tabela

@Entity // Marca a classe como entidade JPA
@Table(name = "cliente") // Define o nome da tabela no banco de dados
public class ClienteBean implements Serializable { 

    // Declaração da classe Cliente
    public ClienteBean(Integer codigo) {
        this.codigo = codigo;
    }

    public ClienteBean() {
        
    }
   
    @Id // Marca o campo como chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define geração automática do ID
    @Column(name = "codigo") // Mapeia para coluna 'codigo' no banco de dados
    private Integer codigo; // Atributo que armazena o código do cliente
    
    @Column(name = "nome") // Mapeia para coluna 'nome' no banco de dados
    private String nome; // Atributo que armazena o nome do cliente
    
    @OneToOne(mappedBy = "clienteBean") // Define relacionamento um-para-um com ContaBean
    private ContaBean contaBean; // Atributo que representa a conta do cliente
    
    public Integer getCodigo() { // Método getter para recuperar o código do cliente
        return codigo;
    }

    public void setCodigo(Integer codigo) { // Método setter para definir o código do cliente
        this.codigo = codigo;
    }

    public String getNome() { // Método getter para recuperar o nome do cliente
        return nome;
    }

    public void setNome(String nome) { // Método setter para definir o nome do cliente
        this.nome = nome;
    }

    public ContaBean getContaBean() { // Método getter para recuperar a conta do cliente
        return contaBean;
    }

    public void setContaBean(ContaBean contaBean) { // Método setter para definir a conta do cliente
        this.contaBean = contaBean;
    }
    
    @Override
    public int hashCode() { // Sobrescrita do método hashCode
        int hash = 3; // Inicialização do valor de hash
        hash = 89 * hash + Objects.hashCode(this.codigo); // Cálculo do hash baseado no código
        return hash; // Retorno do valor de hash
    }

    @Override
    public boolean equals(Object obj) { // Sobrescrita do método equals
        if (this == obj) { // Verifica se é o mesmo objeto
            return true;
        }
        if (obj == null) { // Verifica se o objeto é nulo
            return false;
        }
        if (getClass() != obj.getClass()) { // Verifica se as classes são diferentes
            return false;
        }
        final ClienteBean other = (ClienteBean) obj; // Conversão para ClienteBean
        return Objects.equals(this.codigo, other.codigo); // Compara os códigos
    }
}