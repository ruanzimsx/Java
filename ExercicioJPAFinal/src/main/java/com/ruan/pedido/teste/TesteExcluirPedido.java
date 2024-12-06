package com.ruan.pedido.teste;

import com.ruan.pedido.dao.PedidoDao;
import com.ruan.pessoa.dao.PessoaDao;
import com.ruan.util.DaoException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TesteExcluirPedido {
    public static void main(String[] args) {
        PedidoDao pedidoDao = new PedidoDao();
        try{
            if(pedidoDao.removeById(1L)){
                System.out.println("Removido com sucesso!");
            }else{
                System.out.println("Erro ao remover!");
            }
        } catch (DaoException e) {
            Logger.getLogger(TesteExcluirPedido.class.getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }
}
