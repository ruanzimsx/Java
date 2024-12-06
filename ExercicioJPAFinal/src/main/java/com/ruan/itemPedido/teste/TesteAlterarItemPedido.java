package com.ruan.itemPedido.teste;

import com.ruan.itemPedido.bean.ItemPedidoBean;
import com.ruan.itemPedido.dao.ItemPedidoDao;
import com.ruan.pedido.bean.PedidoBean;
import com.ruan.pedido.dao.PedidoDao;
import com.ruan.util.DaoException;

import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TesteAlterarItemPedido {
    public static void main(String[] args) {
        ItemPedidoBean itemPedidoBean = new ItemPedidoBean();
        itemPedidoBean.setId(1L);
        itemPedidoBean.setPrecoUnitario(2.99F);

        ItemPedidoDao itemPedidoDao = new ItemPedidoDao();
        try{
            System.out.println(itemPedidoDao.replace(itemPedidoBean));
            System.out.println("Alterado com sucesso!");
        } catch (DaoException e) {
            Logger.getLogger(TesteAlterarItemPedido.class.getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }
}
