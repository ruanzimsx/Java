package com.ruan.cliente.bean;

import com.ruan.carrinho.bean.CarrinhoBean;
import com.ruan.pedido.bean.PedidoBean;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "cliente")
public class ClienteBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long id;
    @Column(name = "nome")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "telefone")
    private String phone;
    @OneToOne
    @JoinColumn(name = "id_carrinho")
    private CarrinhoBean carrinhoBean;
    @OneToMany(mappedBy = "clienteBean", fetch = FetchType.EAGER)
    private List<PedidoBean> pedidoBeanList;

    public ClienteBean() {

    }

    public ClienteBean(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ClienteBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", carrinhoBean=" + carrinhoBean +
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public CarrinhoBean getCarrinhoBean() {
        return carrinhoBean;
    }

    public void setCarrinhoBean(CarrinhoBean carrinhoBean) {
        this.carrinhoBean = carrinhoBean;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClienteBean that = (ClienteBean) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
