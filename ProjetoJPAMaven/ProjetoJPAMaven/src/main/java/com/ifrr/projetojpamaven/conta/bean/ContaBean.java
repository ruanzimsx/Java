package com.ifrr.projetojpamaven.conta.bean; // Declaração do pacote da entidade Conta

import com.ifrr.projetojpamaven.banco.bean.BancoBean; // Importação da classe BancoBean para relacionamento many-to-one
import com.ifrr.projetojpamaven.cliente.bean.ClienteBean; // Importação da classe ClienteBean para relacionamento one-to-one
import com.ifrr.projetojpamaven.servico.bean.ServicoBean; // Importação da classe ServicoBean para relacionamento many-to-many
import java.io.Serializable; // Interface que permite serializar a classe, útil para persistência
import java.util.HashSet; // Implementação de Set que não permite duplicatas, usada para armazenar serviços associados
import java.util.Objects; // Utilitário para operações de comparação de objetos
import java.util.Set; // Interface que define um conjunto
import javax.persistence.CascadeType; // Importa CascadeType para definir operações em cascata nos relacionamentos
import javax.persistence.Column; // Anotação para mapeamento de colunas no banco de dados
import javax.persistence.Entity; // Anotação para definir classe como entidade JPA
import javax.persistence.FetchType; // Define estratégias de carregamento (lazy ou eager)
import javax.persistence.GeneratedValue; // Anotação para geração automática de valores
import javax.persistence.GenerationType; // Enum de estratégias de geração de valores
import javax.persistence.Id; // Anotação para identificar chave primária
import javax.persistence.JoinColumn; // Anotação para definição de chave estrangeira
import javax.persistence.JoinTable; // Anotação para definir tabela de junção em relacionamentos many-to-many
import javax.persistence.ManyToMany; // Define um relacionamento many-to-many
import javax.persistence.ManyToOne; // Anotação para relacionamento muitos-para-um
import javax.persistence.OneToOne; // Anotação para relacionamento um-para-um
import javax.persistence.Table; // Anotação para definir nome da tabela

@Entity // Marca a classe como entidade JPA
@Table(name = "conta") // Define o nome da tabela no banco de dados como "conta"
public class ContaBean implements Serializable { // Declaração da classe que representa uma conta e implementa Serializable

    @Id // Marca o campo como identificador primário
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define estratégia de geração automática do ID como IDENTITY
    @Column(name = "codigo") // Mapeia o campo para a coluna 'codigo' no banco de dados
    private Integer codigo; // Atributo para armazenar código identificador da conta

    @Column(name = "nome") // Mapeia o campo para a coluna 'nome' no banco de dados
    private String nome; // Atributo para armazenar nome da conta

    @Column(name = "saldo") // Mapeia o campo para a coluna 'saldo' no banco de dados
    private Float saldo; // Atributo para armazenar saldo da conta

    @Column(name = "limite") // Mapeia o campo para a coluna 'limite' no banco de dados
    private Float limite; // Atributo para armazenar limite da conta
    
    @ManyToOne // Define relacionamento muitos-para-um com BancoBean
    @JoinColumn(name = "banco_codigo") // Define a coluna de chave estrangeira para banco, referenciando a coluna 'codigo' da tabela 'banco'
    private BancoBean bancoBean; // Atributo de referência para o banco associado

    @OneToOne // Define relacionamento um-para-um com ClienteBean
    @JoinColumn(name = "cliente_codigo") // Define a coluna de chave estrangeira para cliente, referenciando a coluna 'codigo' da tabela 'cliente'
    private ClienteBean clienteBean; // Atributo de referência para o cliente associado
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}) // Define o relacionamento many-to-many com ServicoBean
    @JoinTable(
        name = "conta_servico", // Nome da tabela de junção que armazena as relações entre contas e serviços
        joinColumns = @JoinColumn(name = "conta_id"), // Coluna de junção referente à conta, armazenando a chave primária de ContaBean
        inverseJoinColumns = @JoinColumn(name = "servico_id") // Coluna de junção referente ao serviço, armazenando a chave primária de ServicoBean
    )
    private Set<ServicoBean> servicos = new HashSet<>(); // Conjunto de serviços associados à conta, inicializado como HashSet para evitar duplicatas

    @Override
    public String toString() { // Método para representação textual do objeto
        return this.codigo + "-" + this.nome; // Retorna uma string que combina código e nome da conta
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
    
    public Set<ServicoBean> getServicos() { // Getter para o conjunto de serviços associados à conta
        return servicos;
    }

    public void setServicos(Set<ServicoBean> servicos) { // Setter para o conjunto de serviços associados à conta
        this.servicos = servicos;
    }
    
    @Override
    public int hashCode() { // Método para geração de código hash
        int hash = 7; // Inicializa o valor de hash com um número arbitrário
        hash = 23 * hash + Objects.hashCode(this.codigo); // Cálculo do hash baseado no código da conta
        return hash; // Retorna o valor de hash calculado
    }

    @Override
    public boolean equals(Object obj) { // Método para comparação de igualdade entre objetos
        if (this == obj) return true; // Verifica se são o mesmo objeto
        if (obj == null) return false; // Verifica se o objeto a comparar é nulo
        if (getClass() != obj.getClass()) return false; // Verifica se os objetos são da mesma classe
        final ContaBean other = (ContaBean) obj; // Conversão do objeto para ContaBean
        return Objects.equals(this.codigo, other.codigo); // Compara os códigos das contas para determinar igualdade
    }
}