package com.ruan.produto.teste;

import com.ruan.produto.bean.ProdutoBean;
import com.ruan.produto.dao.ProdutoDao;
import com.ruan.util.DaoException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TesteListarProduto {
    public static void main(String[] args) {
        ProdutoDao produtoDao= new ProdutoDao();
        List<ProdutoBean> produtoBeanList;
        try{
            produtoBeanList = (List<ProdutoBean>) produtoDao.findAll();
            if(!produtoBeanList.isEmpty()){
                System.out.println("=====Listas de produto =====");
                System.out.println(produtoBeanList);
            }
        } catch (DaoException e) {
            Logger.getLogger(TesteListarProduto.class.getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }
}
