package com.ruan.pedido.teste;

import com.ruan.pedido.bean.PedidoBean;
import com.ruan.pedido.dao.PedidoDao;
import com.ruan.pessoa.bean.PessoaBean;
import com.ruan.pessoa.dao.PessoaDao;
import com.ruan.util.DaoException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TesteSelecionarPedido {
    public static void main(String[] args) {
        PedidoDao pedidoDao = new PedidoDao();
        try{
            PedidoBean pedidoBean = pedidoDao.findById(1L);
            if(pedidoBean != null){
                System.out.println(pedidoBean);
            }else{
                System.out.println("Erro ao encontrar pedido!");
            }
        }catch(DaoException e){
            Logger.getLogger(TesteSelecionarPedido.class.getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }
}
