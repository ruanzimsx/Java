package com.ruan.produto.teste;

import com.ruan.categoria.bean.CategoriaBean;
import com.ruan.produto.bean.ProdutoBean;
import com.ruan.produto.dao.ProdutoDao;
import com.ruan.util.DaoException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TesteInserirProduto {
    public static void main(String[] args) {
        ProdutoBean produtoBean = new ProdutoBean();
        produtoBean.setCategoriaBean(new CategoriaBean(1L));
        produtoBean.setDescription("Produto para esfregar!");
        produtoBean.setName("Esponja");
        produtoBean.setValue(5.4F);
        ProdutoDao produtoDao = new ProdutoDao();
        try{
            System.out.println(produtoDao.save(produtoBean));
        } catch (DaoException e) {
            Logger.getLogger(TesteInserirProduto.class.getName()).log(Level.SEVERE,null, e);
        }
    }
}
