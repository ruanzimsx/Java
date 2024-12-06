package com.ruan.itemPedido.teste;

import com.ruan.itemPedido.bean.ItemPedidoBean;
import com.ruan.itemPedido.dao.ItemPedidoDao;
import com.ruan.pedido.bean.PedidoBean;
import com.ruan.pedido.dao.PedidoDao;
import com.ruan.util.DaoException;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TesteListarItemPedido {
    public static void main(String[] args) {
        ItemPedidoDao itemPedidoDao = new ItemPedidoDao();
        List<ItemPedidoBean> itemPedidoBeanList;
        try{
            itemPedidoBeanList = (List<ItemPedidoBean>) itemPedidoDao.findAll();
            if(!itemPedidoBeanList.isEmpty()){
                System.out.println("======== Lista de item pedido ===========");
                System.out.println(itemPedidoBeanList);
            }
        } catch (DaoException e) {
            Logger.getLogger(TesteListarItemPedido.class.getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }
}
