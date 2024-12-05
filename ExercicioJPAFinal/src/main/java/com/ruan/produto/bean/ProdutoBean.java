package com.ruan.produto.bean;

import com.ruan.categoria.bean.CategoriaBean;
import com.ruan.itemCarrinho.bean.ItemCarrinhoBean;
import com.ruan.itemPedido.bean.ItemPedidoBean;
import com.ruan.pedido.bean.PedidoBean;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "produto")
public class ProdutoBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome")
    private String name;
    @Column(name = "descricao")
    private String description;
    @Column(name = "preco")
    private Float value;
    @ManyToMany(mappedBy = "produtoBeanList", fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST})
    private Set<PedidoBean> pedidoBeanList = new HashSet<>();

    @OneToMany(mappedBy = "produtoBean", fetch = FetchType.EAGER)
    private Set<ItemCarrinhoBean> itemCarrinhoBeanList;

    @OneToMany(mappedBy = "produtoBean", fetch = FetchType.EAGER)
    private Set<ItemPedidoBean> itemPedidoBeanList;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private CategoriaBean categoriaBean;
    public ProdutoBean() {
    }

    public ProdutoBean(Long id) {
        this.id = id;
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

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public Set<PedidoBean> getPedidoBeanList() {
        return pedidoBeanList;
    }

    public void setPedidoBeanList(Set<PedidoBean> pedidoBeanList) {
        this.pedidoBeanList = pedidoBeanList;
    }

    public Set<ItemCarrinhoBean> getItemCarrinhoBeanList() {
        return itemCarrinhoBeanList;
    }

    public void setItemCarrinhoBeanList(Set<ItemCarrinhoBean> itemCarrinhoBeanList) {
        this.itemCarrinhoBeanList = itemCarrinhoBeanList;
    }

    public Set<ItemPedidoBean> getItemPedidoBeanList() {
        return itemPedidoBeanList;
    }

    public void setItemPedidoBeanList(Set<ItemPedidoBean> itemPedidoBeanList) {
        this.itemPedidoBeanList = itemPedidoBeanList;
    }

    public CategoriaBean getCategoriaBean() {
        return categoriaBean;
    }

    public void setCategoriaBean(CategoriaBean categoriaBean) {
        this.categoriaBean = categoriaBean;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProdutoBean that = (ProdutoBean) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
