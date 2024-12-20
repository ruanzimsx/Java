package com.ruan.carrinho.teste;

import com.ruan.carrinho.bean.CarrinhoBean;
import com.ruan.carrinho.dao.CarrinhoDao;
import com.ruan.util.DaoException;

import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TesteInserirCarrinho {
    public static void main(String[] args) {
        CarrinhoBean carrinhoBean = new CarrinhoBean();
        carrinhoBean.setDateCriacao(LocalDateTime.now());
        carrinhoBean.setStatus("CONCLUIDO");

        CarrinhoDao carrinhoDao = new CarrinhoDao();
        try{
            carrinhoDao.save(carrinhoBean);
        } catch (DaoException e) {
            Logger.getLogger(TesteInserirCarrinho.class.getName())
                    .log(Level.SEVERE, "Erro ao inserir carrinho", e);
        }
    }
}
