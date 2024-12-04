package com.ruan.pessoa.bean;
/*pendente relacionamentos:Herança
com Cliente*/

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "pessoa")
public class PessoaBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome")
    private String name;
    @Column(name = "CPF")
    private String cpf;
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;
}
