package com.ruan.itemPedido.teste;

import com.ruan.itemPedido.bean.ItemPedidoBean;
import com.ruan.itemPedido.dao.ItemPedidoDao;
import com.ruan.pedido.bean.PedidoBean;
import com.ruan.pedido.dao.PedidoDao;
import com.ruan.util.DaoException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TesteSelecionarItemPedido {
    public static void main(String[] args) {
        ItemPedidoDao itemPedidoDao = new ItemPedidoDao();
        try{
            ItemPedidoBean itemPedidoBean = itemPedidoDao.findById(1L);
            if(itemPedidoBean != null){
                System.out.println(itemPedidoBean);
            }else{
                System.out.println("Erro ao encontrar item pedido!");
            }
        }catch(DaoException e){
            Logger.getLogger(TesteSelecionarItemPedido.class.getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }
}
