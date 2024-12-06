package com.ruan.produto.teste;

import com.ruan.produto.bean.ProdutoBean;
import com.ruan.produto.dao.ProdutoDao;
import com.ruan.util.DaoException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TesteExcluirProduto {
    public static void main(String[] args) {
        ProdutoDao produtoDao = new ProdutoDao();
        try{
            if(produtoDao.removeById(1L)){
                System.out.println("Removido com sucesso!");
            }else{
                System.out.println("Erro ao remover!");
            }
        } catch (DaoException e) {
            Logger.getLogger(TesteExcluirProduto.class.getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }
}
