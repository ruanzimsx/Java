package com.ruan.pedido.bean;

import com.ruan.cliente.bean.ClienteBean;
import com.ruan.itemPedido.bean.ItemPedidoBean;
import com.ruan.produto.bean.ProdutoBean;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "pedido")
public class PedidoBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "data")
    private LocalDateTime dataPedido;
    @Column(name = "status")
    private String status;
    @Column(name = "valor_total")
    private Float valorTotal;
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.REMOVE, CascadeType.PERSIST})
    @JoinTable(
            name = "pedido_produto",
            joinColumns = @JoinColumn(name = "id_pedido"),
            inverseJoinColumns = @JoinColumn(name = "id_produto")
    )
    private Set<ProdutoBean> produtoBeanList = new HashSet<>();
    @OneToMany(mappedBy = "pedidoBean",fetch = FetchType.EAGER)
    private Set<ItemPedidoBean> itemPedidoBeanList;
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private ClienteBean clienteBean;
    public PedidoBean() {
    }

    public PedidoBean(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "PedidoBean{" +
                "id=" + id +
                ", dataPedido=" + dataPedido +
                ", status='" + status + '\'' +
                ", valorTotal=" + valorTotal +
                ", produtoBeanList=" + produtoBeanList +
                ", itemPedidoBeanList=" + itemPedidoBeanList +
                ", clienteBean=" + clienteBean +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDateTime dataPedido) {
        this.dataPedido = dataPedido;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Set<ProdutoBean> getProdutoBeanList() {
        return produtoBeanList;
    }

    public void setProdutoBeanList(Set<ProdutoBean> produtoBeanList) {
        this.produtoBeanList = produtoBeanList;
    }

    public Set<ItemPedidoBean> getItemPedidoBeanList() {
        return itemPedidoBeanList;
    }

    public void setItemPedidoBeanList(Set<ItemPedidoBean> itemPedidoBeanList) {
        this.itemPedidoBeanList = itemPedidoBeanList;
    }

    public ClienteBean getClienteBean() {
        return clienteBean;
    }

    public void setClienteBean(ClienteBean clienteBean) {
        this.clienteBean = clienteBean;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PedidoBean that = (PedidoBean) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
