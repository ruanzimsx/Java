package com.ruan.itemCarrinho.teste;

import com.ruan.itemCarrinho.bean.ItemCarrinhoBean;
import com.ruan.itemCarrinho.dao.ItemCarrinhoDao;
import com.ruan.itemPedido.bean.ItemPedidoBean;
import com.ruan.itemPedido.dao.ItemPedidoDao;
import com.ruan.util.DaoException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TesteAlterarItemCarrinho {
    public static void main(String[] args) {
        ItemCarrinhoBean itemCarrinhoBean = new ItemCarrinhoBean();
        itemCarrinhoBean.setPrecoUnitario(10.50F);
        itemCarrinhoBean.setQuant(16);
        ItemCarrinhoDao itemCarrinhoDao = new ItemCarrinhoDao();
        try{
            System.out.println(itemCarrinhoDao.replace(itemCarrinhoBean));
            System.out.println("Alterado com sucesso!");
        } catch (DaoException e) {
            Logger.getLogger(TesteAlterarItemCarrinho.class.getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }
}
