package com.ruan.itemPedido.bean;

import com.ruan.pedido.bean.PedidoBean;
import com.ruan.produto.bean.ProdutoBean;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "item_pedido")
public class ItemPedidoBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "quantidade")
    private Integer quant;
    @Column(name = "preco")
    private Float precoUnitario;
    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private PedidoBean pedidoBean;
    @ManyToOne
    @JoinColumn(name = "id_produto")
    private ProdutoBean produtoBean;
    public ItemPedidoBean() {
    }

    public ItemPedidoBean(Long id){
        this.id = id;
    }

    @Override
    public String toString() {
        return "ItemPedidoBean{" +
                "id=" + id +
                ", quant=" + quant +
                ", precoUnitario=" + precoUnitario +
                ", pedidoBean=" + pedidoBean +
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

    public PedidoBean getPedidoBean() {
        return pedidoBean;
    }

    public void setPedidoBean(PedidoBean pedidoBean) {
        this.pedidoBean = pedidoBean;
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
        ItemPedidoBean that = (ItemPedidoBean) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
