package com.ruan.itemCarrinho.teste;

import com.ruan.itemCarrinho.bean.ItemCarrinhoBean;
import com.ruan.itemCarrinho.dao.ItemCarrinhoDao;
import com.ruan.itemPedido.bean.ItemPedidoBean;
import com.ruan.itemPedido.dao.ItemPedidoDao;
import com.ruan.util.DaoException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TesteSelecionarItemCarrinho {
    public static void main(String[] args) {
        ItemCarrinhoDao itemCarrinhoDao = new ItemCarrinhoDao();
        try{
            ItemCarrinhoBean itemCarrinhoBean = itemCarrinhoDao.findById(1L);
            if(itemCarrinhoBean != null){
                System.out.println(itemCarrinhoBean);
            }else{
                System.out.println("Erro ao encontrar item carrinho!");
            }
        }catch(DaoException e){
            Logger.getLogger(TesteSelecionarItemCarrinho.class.getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }
}
