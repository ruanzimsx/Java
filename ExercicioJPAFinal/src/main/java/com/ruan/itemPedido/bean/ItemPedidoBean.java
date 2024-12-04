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
