package com.ruan.carrinho.teste;

import com.ruan.carrinho.bean.CarrinhoBean;
import com.ruan.carrinho.dao.CarrinhoDao;
import com.ruan.categoria.bean.CategoriaBean;
import com.ruan.categoria.dao.CategoriaDao;
import com.ruan.util.DaoException;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TesteListarCarrinho {
    public static void main(String[] args) {
        CarrinhoDao carrinhoDao = new CarrinhoDao();
        List<CarrinhoBean> carrinhoBeanList;
        try{
            carrinhoBeanList = (List<CarrinhoBean>) carrinhoDao.findAll();
            if(!carrinhoBeanList.isEmpty()){
                System.out.println("=====Listas de carrinhos =====");
                System.out.println(carrinhoBeanList);
            }
        } catch (DaoException e) {
            Logger.getLogger(TesteListarCarrinho.class.getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }
}
