package com.ruan.categoria.teste;

import com.ruan.categoria.bean.CategoriaBean;
import com.ruan.categoria.dao.CategoriaDao;
import com.ruan.produto.bean.ProdutoBean;
import com.ruan.produto.dao.ProdutoDao;
import com.ruan.util.DaoException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TesteSelecionarCategoria {
    public static void main(String[] args) {
        CategoriaDao categoriaDao = new CategoriaDao();
        try{
            CategoriaBean categoriaBean = categoriaDao.findById(1L);
            if(categoriaBean != null){
                System.out.println(categoriaBean);
            }else{
                System.out.println("Erro ao encontrar categoria!");
            }
        }catch(DaoException e){
            Logger.getLogger(TesteSelecionarCategoria.class.getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }
}
