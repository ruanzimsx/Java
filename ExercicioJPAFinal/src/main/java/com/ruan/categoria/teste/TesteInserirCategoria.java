package com.ruan.categoria.teste;

import com.ruan.categoria.bean.CategoriaBean;
import com.ruan.categoria.dao.CategoriaDao;
import com.ruan.util.DaoException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TesteInserirCategoria {
    public static void main(String[] args) {
        CategoriaBean categoriaBean = new CategoriaBean();
        categoriaBean.setName("Limpeza");
        categoriaBean.setDescription("Produtos de limpeza");
        CategoriaDao categoriaDao = new CategoriaDao();
        try{
            categoriaDao.save(categoriaBean);
        } catch (DaoException e) {
            Logger.getLogger(TesteInserirCategoria.class.getName()).log(Level.SEVERE, "erro ao inserir categoria", e);
        }
    }
}
