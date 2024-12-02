package com.ifrr.projetojpamaven.servico.bean; // Pacote onde a classe ServicoBean está localizada

import com.ifrr.projetojpamaven.conta.bean.ContaBean; // Importa a classe ContaBean para o relacionamento many-to-many
import java.io.Serializable; // Interface que permite a serialização da classe, útil para persistência ou transmissão
import java.util.HashSet; // Implementação de Set que não permite duplicatas, usada para armazenar contas associadas
import java.util.Objects; // Classe utilitária para métodos hashCode e equals
import java.util.Set; // Interface que define um conjunto, usada aqui para representar uma coleção de contas
import javax.persistence.CascadeType; // Importa CascadeType para definir o comportamento de operações em cascata nos relacionamentos
import javax.persistence.Entity; // Indica que a classe é uma entidade JPA, que será mapeada para uma tabela no banco de dados
import javax.persistence.FetchType; // Define estratégias de carregamento (lazy ou eager) para os relacionamentos
import javax.persistence.GeneratedValue; // Indica que o valor do ID será gerado automaticamente pelo provedor de persistência
import javax.persistence.GenerationType; // Enumeração que especifica diferentes estratégias de geração de ID
import javax.persistence.Id; // Marca um campo como chave primária da entidade
import javax.persistence.ManyToMany; // Define um relacionamento many-to-many entre entidades
import javax.persistence.Table; // Especifica a tabela no banco de dados que corresponde à entidade

@Entity // Marca a classe como uma entidade JPA
@Table(name = "servico") // Define o nome da tabela no banco de dados como "servico"
public class ServicoBean implements Serializable { // Implementa Serializable para permitir que instâncias sejam serializadas
    @Id // Anota o campo como chave primária da entidade
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define a estratégia de geração de ID como IDENTITY, onde o banco de dados gera automaticamente o ID
    private Integer codigo; // Campo que serve como identificador único do serviço

    private String descricao; // Campo que armazena a descrição do serviço

    @ManyToMany(mappedBy = "servicos", fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}) // Define um relacionamento many-to-many com ContaBean
    // mappedBy = "servicos": Indica que o lado proprietário do relacionamento é a entidade ContaBean, que gerencia a associação
    // fetch = FetchType.EAGER: Define que a coleção de contas será carregada imediatamente com a entidade ServicoBean
    // cascade = {...}: Especifica que as operações PERSIST, MERGE e REMOVE devem ser propagadas para as entidades relacionadas
    private Set<ContaBean> contas = new HashSet<>(); // Conjunto de contas associadas ao serviço, inicializado como HashSet para evitar duplicatas

    // Construtores, getters e setters

    public ServicoBean() {} // Construtor padrão sem argumentos

    public ServicoBean(String descricao) { // Construtor que inicializa a descrição do serviço
        this.descricao = descricao;
    }

    public Integer getCodigo() { // Getter para o campo ID
        return codigo;
    }

    public void setCodigo(Integer codigo) { // Setter para o campo ID
        this.codigo = codigo;
    }

    public String getDescricao() { // Getter para o campo descrição
        return descricao;
    }

    public void setDescricao(String descricao) { // Setter para o campo descrição
        this.descricao = descricao;
    }

    public Set<ContaBean> getContas() { // Getter para o conjunto de contas associadas
        return contas;
    }

    public void setContas(Set<ContaBean> contas) { // Setter para o conjunto de contas associadas
        this.contas = contas;
    }

    @Override
    public int hashCode() { // Método para calcular o código hash da entidade
        int hash = 7; // Inicializa o hash com um valor arbitrário
        hash = 67 * hash + Objects.hashCode(this.codigo); // Calcula o hash usando o campo código
        return hash; // Retorna o valor do hash
    }

    @Override
    public boolean equals(Object obj) { // Método para verificar a igualdade entre objetos
        if (this == obj) { // Verifica se o objeto atual é o mesmo que o objeto passado
            return true; // Retorna true se forem o mesmo objeto
        }
        if (obj == null) { // Verifica se o objeto passado é nulo
            return false; // Retorna false se o objeto for nulo
        }
        if (getClass() != obj.getClass()) { // Verifica se os objetos são da mesma classe
            return false; // Retorna false se não forem da mesma classe
        }
        final ServicoBean other = (ServicoBean) obj; // Faz um cast para ServicoBean
        return Objects.equals(this.codigo, other.codigo); // Compara os códigos dos serviços para determinar igualdade
    }
}