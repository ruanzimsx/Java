package com.ruan.pedido.teste;

import com.ruan.pedido.bean.PedidoBean;
import com.ruan.pedido.dao.PedidoDao;
import com.ruan.pessoa.bean.PessoaBean;
import com.ruan.pessoa.dao.PessoaDao;
import com.ruan.util.DaoException;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TesteListarPedido {
    public static void main(String[] args) {
        PedidoDao pedidoDao = new PedidoDao();
        List<PedidoBean> pedidoBeanList;
        try{
            pedidoBeanList = (List<PedidoBean>) pedidoDao.findAll();
            if(!pedidoBeanList.isEmpty()){
                System.out.println("======== Lista de pedidos ===========");
                System.out.println(pedidoBeanList);
            }
        } catch (DaoException e) {
            Logger.getLogger(TesteListarPedido.class.getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }
}
