package com.ruan.pedido.teste;

import com.ruan.pedido.bean.PedidoBean;
import com.ruan.pedido.dao.PedidoDao;
import com.ruan.pessoa.bean.PessoaBean;
import com.ruan.pessoa.dao.PessoaDao;
import com.ruan.util.DaoException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TesteInserirPedido {
    public static void main(String[] args) {
        PedidoBean pedidoBean = new PedidoBean();
        pedidoBean.setDataPedido(LocalDateTime.of(2022,12,9
                ,15,30,0));
        pedidoBean.setStatus("CONCLUIDO");
        pedidoBean.setValorTotal(550F);
        PedidoDao pedidoDao = new PedidoDao();
        try{
            System.out.println(pedidoDao.save(pedidoBean));
        } catch (DaoException e) {
            Logger.getLogger(TesteInserirPedido.class.getName()).log(Level.SEVERE,null, e);
        }
    }
}
