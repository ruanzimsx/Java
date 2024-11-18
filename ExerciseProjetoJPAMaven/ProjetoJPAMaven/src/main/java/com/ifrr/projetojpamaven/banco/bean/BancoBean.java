package com.ifrr.projetojpamaven.banco.bean; // Declaração do pacote onde a classe está localizada

import com.ifrr.projetojpamaven.conta.bean.ContaBean; // Importação da classe ContaBean para relacionamento
import java.io.Serializable; // Importação para suporte à serialização
import java.util.List; // Importação de lista para armazenar contas
import java.util.Objects; // Importação de utilitário para comparação de objetos
import javax.persistence.Column; // Importação de anotação para mapeamento de coluna
import javax.persistence.Entity; // Importação de anotação para definir entidade JPA
import javax.persistence.FetchType; // Importação de estratégias de carregamento
import javax.persistence.GeneratedValue; // Importação de anotação para geração automática de valor
import javax.persistence.GenerationType; // Importação de estratégias de geração de valor
import javax.persistence.Id; // Importação de anotação para identificador
import javax.persistence.OneToMany; // Importação de anotação para relacionamento um-para-muitos
import javax.persistence.Table; // Importação de anotação para definição de tabela

@Entity // Anotação que define a classe como uma entidade JPA
@Table(name = "banco") // Anotação que especifica o nome da tabela no banco de dados
public class BancoBean implements Serializable { // Declaração da classe que implementa Serializable

    public BancoBean() { // Construtor padrão sem argumentos
       
    }
    
    public BancoBean(Integer codigo) { // Construtor que recebe código como parâmetro
        this.codigo = codigo;
    }
    
    @Id // Anotação que identifica o campo como chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Anotação que define estratégia de geração automática do ID
    @Column(name = "codigo") // Anotação que mapeia a coluna no banco de dados
    private Integer codigo; // Atributo que armazena o código do banco
    
    @Column(name = "nome") // Anotação para mapeamento da coluna nome
    private String nome; // Atributo que armazena o nome do banco
    
    @OneToMany(mappedBy = "bancoBean", fetch = FetchType.EAGER) // Anotação que define relacionamento um-para-muitos com carregamento imediato
    private List<ContaBean> contasBean; // Lista que armazena as contas associadas ao banco

    public Integer getCodigo() { // Método getter para recuperar o código do banco
        return codigo;
    }

    public void setCodigo(Integer codigo) { // Método setter para definir o código do banco
        this.codigo = codigo;
    }

    public String getNome() { // Método getter para recuperar o nome do banco
        return nome;
    }

    public void setNome(String nome) { // Método setter para definir o nome do banco
        this.nome = nome;
    }

    @Override
    public int hashCode() { // Sobrescrita do método hashCode para geração de código hash
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.codigo); // Gera o hash baseado no código do banco
        return hash;
    }

    @Override
    public boolean equals(Object obj) { // Sobrescrita do método equals para comparação de objetos
        if (this == obj) { // Verifica se é o mesmo objeto
            return true;
        }
        if (obj == null) { // Verifica se o objeto é nulo
            return false;
        }
        if (getClass() != obj.getClass()) { // Verifica se as classes são diferentes
            return false;
        }
        final BancoBean other = (BancoBean) obj; // Converte o objeto para comparação
        return Objects.equals(this.codigo, other.codigo); // Compara os códigos dos bancos
    }

    public List<ContaBean> getContasBean() { // Método getter para recuperar a lista de contas
        return contasBean;
    }

    public void setContasBean(List<ContaBean> contasBean) { // Método setter para definir a lista de contas
        this.contasBean = contasBean;
    }
}