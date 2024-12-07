package com.ruan.categoria.teste;

import com.ruan.categoria.bean.CategoriaBean;
import com.ruan.categoria.dao.CategoriaDao;
import com.ruan.produto.bean.ProdutoBean;
import com.ruan.produto.dao.ProdutoDao;
import com.ruan.util.DaoException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TesteAlterarCategoria {
    public static void main(String[] args) {
        CategoriaBean categoriaBean = new CategoriaBean();
        categoriaBean.setName("Testando");
        categoriaBean.setId(1L);
        categoriaBean.setDescription("Testando descriçao");

        CategoriaDao categoriaDao = new CategoriaDao();
        try{
            System.out.println(categoriaDao.replace(categoriaBean));
            System.out.println("Alterado com sucesso!");
        } catch (DaoException e) {
            Logger.getLogger(TesteAlterarCategoria.class.getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }
}
