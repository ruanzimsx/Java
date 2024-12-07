package com.ruan.categoria.teste;

import com.ruan.categoria.dao.CategoriaDao;
import com.ruan.produto.dao.ProdutoDao;
import com.ruan.util.DaoException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TesteExcluirCategoria {
    public static void main(String[] args) {
        CategoriaDao categoriaDao = new CategoriaDao();
        try{
            if(categoriaDao.removeById(1L)){
                System.out.println("Removido com sucesso!");
            }else{
                System.out.println("Erro ao remover!");
            }
        } catch (DaoException e) {
            Logger.getLogger(TesteExcluirCategoria.class.getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }
}
