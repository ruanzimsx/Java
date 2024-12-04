package com.ruan.pedido.bean;

import com.ruan.cliente.bean.ClienteBean;
import com.ruan.itemPedido.bean.ItemPedidoBean;
import com.ruan.produto.bean.ProdutoBean;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
    private List<ProdutoBean> produtoBeanList = new ArrayList<>();
    @OneToMany(mappedBy = "pedidoBean",fetch = FetchType.EAGER)
    private List<ItemPedidoBean> itemPedidoBeanList;
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private ClienteBean clienteBean;
    public PedidoBean() {
    }

    public PedidoBean(Long id) {
        this.id = id;
    }
}
