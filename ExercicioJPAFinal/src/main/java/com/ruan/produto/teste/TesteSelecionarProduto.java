package com.ruan.produto.teste;

import com.ruan.produto.bean.ProdutoBean;
import com.ruan.produto.dao.ProdutoDao;
import com.ruan.util.DaoException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TesteSelecionarProduto {
    public static void main(String[] args) {
        ProdutoDao produtoDao = new ProdutoDao();
        try{
            ProdutoBean produtoBean = produtoDao.findById(1L);
            if(produtoBean != null){
                System.out.println(produtoBean);
            }else{
                System.out.println("Erro ao encontrar produto!");
            }
        }catch(DaoException e){
            Logger.getLogger(TesteSelecionarProduto.class.getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }
}
