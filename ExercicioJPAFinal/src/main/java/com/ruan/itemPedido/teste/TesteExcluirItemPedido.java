package com.ruan.itemPedido.teste;

import com.ruan.itemPedido.dao.ItemPedidoDao;
import com.ruan.pedido.dao.PedidoDao;
import com.ruan.util.DaoException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TesteExcluirItemPedido {
    public static void main(String[] args) {
        ItemPedidoDao itemPedidoDao = new ItemPedidoDao();
        try{
            if(itemPedidoDao.removeById(1L)){
                System.out.println("Removido com sucesso!");
            }else{
                System.out.println("Erro ao remover!");
            }
        } catch (DaoException e) {
            Logger.getLogger(TesteExcluirItemPedido.class.getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }
}
