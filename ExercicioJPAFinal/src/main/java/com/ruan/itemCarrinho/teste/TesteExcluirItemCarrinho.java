package com.ruan.itemCarrinho.teste;

import com.ruan.itemCarrinho.dao.ItemCarrinhoDao;
import com.ruan.itemPedido.dao.ItemPedidoDao;
import com.ruan.util.DaoException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TesteExcluirItemCarrinho {
    public static void main(String[] args) {
        ItemCarrinhoDao itemCarrinhoDao = new ItemCarrinhoDao();
        try{
            if(itemCarrinhoDao.removeById(1L)){
                System.out.println("Removido com sucesso!");
            }else{
                System.out.println("Erro ao remover!");
            }
        } catch (DaoException e) {
            Logger.getLogger(TesteExcluirItemCarrinho.class.getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }
}
