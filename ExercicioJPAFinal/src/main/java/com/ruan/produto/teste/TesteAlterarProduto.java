package com.ruan.produto.teste;

import com.ruan.produto.bean.ProdutoBean;
import com.ruan.produto.dao.ProdutoDao;
import com.ruan.util.DaoException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TesteAlterarProduto {
    public static void main(String[] args) {
        ProdutoBean produto = new ProdutoBean();
        produto.setId(1L);
        produto.setName("Ruan");
        ProdutoDao produtoDao = new ProdutoDao();
        try{
            System.out.println(produtoDao.replace(produto));
            System.out.println("Alterado com sucesso!");
        } catch (DaoException e) {
            Logger.getLogger(TesteAlterarProduto.class.getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }
}
