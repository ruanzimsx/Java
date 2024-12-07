package com.ruan.categoria.bean;

import com.ruan.produto.bean.ProdutoBean;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
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
    private Set<ProdutoBean> produtoBeanList;

    public CategoriaBean() {
    }

    public CategoriaBean(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CategoriaBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", produtoBeanList=" + produtoBeanList +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<ProdutoBean> getProdutoBeanList() {
        return produtoBeanList;
    }

    public void setProdutoBeanList(Set<ProdutoBean> produtoBeanList) {
        this.produtoBeanList = produtoBeanList;
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
