package com.ruan.itemCarrinho.teste;

import com.ruan.itemCarrinho.bean.ItemCarrinhoBean;
import com.ruan.itemCarrinho.dao.ItemCarrinhoDao;
import com.ruan.itemPedido.bean.ItemPedidoBean;
import com.ruan.itemPedido.dao.ItemPedidoDao;
import com.ruan.util.DaoException;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TesteListarItemCarrinho {
    public static void main(String[] args) {
        ItemCarrinhoDao itemCarrinhoDao = new ItemCarrinhoDao();
        List<ItemCarrinhoBean> itemCarrinhoBeanList;
        try{
            itemCarrinhoBeanList = (List<ItemCarrinhoBean>) itemCarrinhoDao.findAll();
            if(!itemCarrinhoBeanList.isEmpty()){
                System.out.println("======== Lista de item carrinho ===========");
                System.out.println(itemCarrinhoBeanList);
            }
        } catch (DaoException e) {
            Logger.getLogger(TesteListarItemCarrinho.class.getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }
}
