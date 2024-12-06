package com.ruan.itemCarrinho.teste;

import com.ruan.carrinho.bean.CarrinhoBean;
import com.ruan.itemCarrinho.bean.ItemCarrinhoBean;
import com.ruan.itemCarrinho.dao.ItemCarrinhoDao;
import com.ruan.itemPedido.bean.ItemPedidoBean;
import com.ruan.itemPedido.dao.ItemPedidoDao;
import com.ruan.pedido.bean.PedidoBean;
import com.ruan.produto.bean.ProdutoBean;
import com.ruan.util.DaoException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TesteInserirItemCarrinho {
    public static void main(String[] args) {
        ItemCarrinhoBean itemCarrinhoBean = new ItemCarrinhoBean();
        itemCarrinhoBean.setQuant(30);
        itemCarrinhoBean.setPrecoUnitario(5.89F);
        itemCarrinhoBean.setCarrinhoBean(new CarrinhoBean(1L));
        itemCarrinhoBean.setProdutoBean(new ProdutoBean(1L));


        ItemCarrinhoDao itemCarrinhoDao = new ItemCarrinhoDao();
        try{
            System.out.println(itemCarrinhoDao.save(itemCarrinhoBean));
        } catch (DaoException e) {
            Logger.getLogger(TesteInserirItemCarrinho.class.getName()).log(Level.SEVERE,null, e);
        }
    }
}
