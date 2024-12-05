package com.ruan.carrinho.bean;

import com.ruan.cliente.bean.ClienteBean;
import com.ruan.itemCarrinho.bean.ItemCarrinhoBean;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.Objects;

@Entity
@Table(name = "carrinho")
public class CarrinhoBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "data")
    private LocalDateTime dateCriacao;
    @Column(name = "status")
    private String status;
    @OneToOne(mappedBy = "carrinhoBean")
    private ClienteBean clienteBean;
    @OneToMany(mappedBy = "carrinhoBean", fetch = FetchType.EAGER)
    private Set<ItemCarrinhoBean> itemCarrinhoBeanList;

    public CarrinhoBean() {
    }

    public CarrinhoBean(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CarrinhoBean{" +
                "id=" + id +
                ", dateCriacao=" + dateCriacao +
                ", status='" + status + '\'' +
                ", clienteBean=" + clienteBean +
                ", itemCarrinhoBeanList=" + itemCarrinhoBeanList +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateCriacao() {
        return dateCriacao;
    }

    public void setDateCriacao(LocalDateTime dateCriacao) {
        this.dateCriacao = dateCriacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ClienteBean getClienteBean() {
        return clienteBean;
    }

    public void setClienteBean(ClienteBean clienteBean) {
        this.clienteBean = clienteBean;
    }

    public Set<ItemCarrinhoBean> getItemCarrinhoBeanList() {
        return itemCarrinhoBeanList;
    }

    public void setItemCarrinhoBeanList(Set<ItemCarrinhoBean> itemCarrinhoBeanList) {
        this.itemCarrinhoBeanList = itemCarrinhoBeanList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarrinhoBean that = (CarrinhoBean) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
