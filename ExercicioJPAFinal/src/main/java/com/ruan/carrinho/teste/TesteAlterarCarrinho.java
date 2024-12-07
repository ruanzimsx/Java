package com.ruan.carrinho.teste;

import com.ruan.carrinho.bean.CarrinhoBean;
import com.ruan.carrinho.dao.CarrinhoDao;
import com.ruan.util.DaoException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TesteAlterarCarrinho {
    public static void main(String[] args) {
        CarrinhoBean carrinhoBean = new CarrinhoBean();
        carrinhoBean.setId(1L);
        carrinhoBean.setStatus("PENDENTE?TEST");

        CarrinhoDao carrinhoDao = new CarrinhoDao();
        try{
            System.out.println(carrinhoDao.replace(carrinhoBean));
            System.out.println("Alterado com sucesso!");
        } catch (DaoException e) {
            Logger.getLogger(TesteAlterarCarrinho.class.getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }
}
