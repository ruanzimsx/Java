package com.ruan.carrinho.teste;

import com.ruan.carrinho.bean.CarrinhoBean;
import com.ruan.carrinho.dao.CarrinhoDao;
import com.ruan.categoria.bean.CategoriaBean;
import com.ruan.categoria.dao.CategoriaDao;
import com.ruan.util.DaoException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TesteSelecionarCarrinho {
    public static void main(String[] args) {
        CarrinhoDao carrinhoDao = new CarrinhoDao();
        try{
            CarrinhoBean carrinhoBean = carrinhoDao.findById(1L);
            if(carrinhoBean != null){
                System.out.println(carrinhoBean);
            }else{
                System.out.println("Erro ao encontrar carrinho!");
            }
        }catch(DaoException e){
            Logger.getLogger(TesteSelecionarCarrinho.class.getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }
}
