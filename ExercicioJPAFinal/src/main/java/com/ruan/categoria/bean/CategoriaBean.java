package com.ruan.categoria.bean;

import com.ruan.produto.bean.ProdutoBean;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "categoria")
public class CategoriaBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome")
    private String name;
    @Column(name = "descricao")
    private String description;

    @OneToMany(mappedBy = "categoriaBean",fetch = FetchType.EAGER)
    private List<ProdutoBean> produtoBeanList;

    public CategoriaBean() {
    }

    public CategoriaBean(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoriaBean that = (CategoriaBean) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
