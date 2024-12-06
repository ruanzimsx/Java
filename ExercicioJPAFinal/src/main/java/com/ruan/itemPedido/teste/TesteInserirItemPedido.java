package com.ruan.itemPedido.teste;

import com.ruan.itemPedido.bean.ItemPedidoBean;
import com.ruan.itemPedido.dao.ItemPedidoDao;
import com.ruan.pedido.bean.PedidoBean;
import com.ruan.pedido.dao.PedidoDao;
import com.ruan.produto.bean.ProdutoBean;
import com.ruan.util.DaoException;

import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TesteInserirItemPedido {
    public static void main(String[] args) {
        ItemPedidoBean itemPedidoBean = new ItemPedidoBean();
        itemPedidoBean.setPrecoUnitario(12.50F);
        itemPedidoBean.setQuant(5);
        itemPedidoBean.setPedidoBean(new PedidoBean(1L));
        itemPedidoBean.setProdutoBean(new ProdutoBean(1L));
        ItemPedidoDao itemPedidoDao = new ItemPedidoDao();
        try{
            System.out.println(itemPedidoDao.save(itemPedidoBean));
        } catch (DaoException e) {
            Logger.getLogger(TesteInserirItemPedido.class.getName()).log(Level.SEVERE,null, e);
        }
    }
}
