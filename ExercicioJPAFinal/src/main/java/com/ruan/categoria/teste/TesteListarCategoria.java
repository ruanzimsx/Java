package com.ruan.categoria.teste;

import com.ruan.categoria.bean.CategoriaBean;
import com.ruan.categoria.dao.CategoriaDao;
import com.ruan.produto.bean.ProdutoBean;
import com.ruan.produto.dao.ProdutoDao;
import com.ruan.util.DaoException;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TesteListarCategoria {
    public static void main(String[] args) {
        CategoriaDao categoriaDao = new CategoriaDao();
        List<CategoriaBean> categoriaBeanList;
        try{
            categoriaBeanList = (List<CategoriaBean>) categoriaDao.findAll();
            if(!categoriaBeanList.isEmpty()){
                System.out.println("=====Listas de categorias =====");
                System.out.println(categoriaBeanList);
            }
        } catch (DaoException e) {
            Logger.getLogger(TesteListarCategoria.class.getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }
}
