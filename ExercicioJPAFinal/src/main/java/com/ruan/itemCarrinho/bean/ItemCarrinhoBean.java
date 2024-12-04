package com.ruan.itemCarrinho.bean;

import com.ruan.carrinho.bean.CarrinhoBean;
import com.ruan.produto.bean.ProdutoBean;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "item_carrinho")
public class ItemCarrinhoBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "quantidade")
    private Integer quant;
    @Column(name = "preco_unitario")
    private Float precoUnitario;
    @ManyToOne()
    @JoinColumn(name = "id_carrinho")
    private CarrinhoBean carrinhoBean;
    @ManyToOne
    @JoinColumn(name = "id_produto")
    private ProdutoBean produtoBean;

    public ItemCarrinhoBean() {

    }

    public ItemCarrinhoBean(Long id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "ItemCarrinhoBean{" +
                "id=" + id +
                ", quant=" + quant +
                ", precoUnitario=" + precoUnitario +
                ", carrinhoBean=" + carrinhoBean +
                ", produtoBean=" + produtoBean +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuant() {
        return quant;
    }

    public void setQuant(Integer quant) {
        this.quant = quant;
    }

    public Float getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(Float precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public CarrinhoBean getCarrinhoBean() {
        return carrinhoBean;
    }

    public void setCarrinhoBean(CarrinhoBean carrinhoBean) {
        this.carrinhoBean = carrinhoBean;
    }

    public ProdutoBean getProdutoBean() {
        return produtoBean;
    }

    public void setProdutoBean(ProdutoBean produtoBean) {
        this.produtoBean = produtoBean;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemCarrinhoBean that = (ItemCarrinhoBean) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
