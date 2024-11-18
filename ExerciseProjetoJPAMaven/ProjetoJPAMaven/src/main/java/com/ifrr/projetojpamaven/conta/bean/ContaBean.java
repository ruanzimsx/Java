package com.ifrr.projetojpamaven.conta.bean; // Declaração do pacote da entidade Conta

import com.ifrr.projetojpamaven.banco.bean.BancoBean; // Importação da classe BancoBean para relacionamento
import com.ifrr.projetojpamaven.cliente.bean.ClienteBean; // Importação da classe ClienteBean para relacionamento
import java.io.Serializable; // Interface para permitir serialização de objetos
import java.util.Objects; // Utilitário para operações de comparação de objetos
import javax.persistence.Column; // Anotação para mapeamento de colunas no banco de dados
import javax.persistence.Entity; // Anotação para definir classe como entidade JPA
import javax.persistence.GeneratedValue; // Anotação para geração automática de valores
import javax.persistence.GenerationType; // Enum de estratégias de geração de valores
import javax.persistence.Id; // Anotação para identificar chave primária
import javax.persistence.JoinColumn; // Anotação para definição de chave estrangeira
import javax.persistence.ManyToOne; // Anotação para relacionamento muitos-para-um
import javax.persistence.OneToOne; // Anotação para relacionamento um-para-um
import javax.persistence.Table; // Anotação para definir nome da tabela

@Entity // Marca a classe como entidade JPA
@Table(name = "conta") // Define o nome da tabela no banco de dados
public class ContaBean implements Serializable { // Declaração da classe que representa uma conta

    @Id // Marca o campo como identificador primário
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define estratégia de geração automática do ID
    @Column(name = "codigo") // Mapeia para coluna 'codigo' no banco de dados
    private Integer codigo; // Atributo para armazenar código identificador da conta

    @Column(name = "nome") // Mapeia para coluna 'nome' no banco de dados
    private String nome; // Atributo para armazenar nome da conta

    @Column(name = "saldo") // Mapeia para coluna 'saldo' no banco de dados
    private Float saldo; // Atributo para armazenar saldo da conta

    @Column(name = "limite") // Mapeia para coluna 'limite' no banco de dados
    private Float limite; // Atributo para armazenar limite da conta
    
    @ManyToOne // Define relacionamento muitos-para-um
    @JoinColumn(name = "banco_codigo") // Define coluna de chave estrangeira para banco
    private BancoBean bancoBean; // Atributo de referência para o banco associado

    @OneToOne // Define relacionamento um-para-um
    @JoinColumn(name = "cliente_codigo") // Define coluna de chave estrangeira para cliente
    private ClienteBean clienteBean; // Atributo de referência para o cliente associado
    
    @Override
    public int hashCode() { // Método para geração de código hash
        int hash = 7; // Inicialização do valor de hash
        hash = 23 * hash + Objects.hashCode(this.codigo); // Cálculo do hash baseado no código
        return hash; // Retorno do valor de hash
    }

    @Override
    public boolean equals(Object obj) { // Método para comparação de igualdade
        if (this == obj) return true; // Verifica se são o mesmo objeto
        if (obj == null) return false; // Verifica se o objeto é nulo
        if (getClass() != obj.getClass()) return false; // Verifica se são da mesma classe
        final ContaBean other = (ContaBean) obj; // Conversão para ContaBean
        return Objects.equals(this.codigo, other.codigo); // Compara os códigos
    }

    @Override
    public String toString() { // Método para representação textual do objeto
        return this.codigo + "-" + this.nome; // Retorna código e nome da conta
    }
  
    public Integer getCodigo() { // Método getter para recuperar código da conta
        return codigo;
    }

    public void setCodigo(Integer codigo) { // Método setter para definir código da conta
        this.codigo = codigo;
    }

    public String getNome() { // Método getter para recuperar nome da conta
        return nome;
    }

    public void setNome(String nome) { // Método setter para definir nome da conta
        this.nome = nome;
    }

    public Float getSaldo() { // Método getter para recuperar saldo da conta
        return saldo;
    }

    public void setSaldo(Float saldo) { // Método setter para definir saldo da conta
        this.saldo = saldo;
    }

    public Float getLimite() { // Método getter para recuperar limite da conta
        return limite;
    }

    public void setLimite(Float limite) { // Método setter para definir limite da conta
        this.limite = limite;
    }

    public BancoBean getBancoBean() { // Método getter para recuperar banco associado
        return bancoBean;
    }

    public void setBancoBean(BancoBean bancoBean) { // Método setter para definir banco associado
        this.bancoBean = bancoBean;
    }

    public ClienteBean getClienteBean() { // Método getter para recuperar cliente associado
        return clienteBean;
    }

    public void setClienteBean(ClienteBean clienteBean) { // Método setter para definir cliente associado
        this.clienteBean = clienteBean;
    }
}