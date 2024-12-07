package com.ruan.carrinho.teste;

import com.ruan.carrinho.dao.CarrinhoDao;
import com.ruan.categoria.dao.CategoriaDao;
import com.ruan.util.DaoException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TesteExcluirCarrinho {
    public static void main(String[] args) {
        CarrinhoDao carrinhoDao = new CarrinhoDao();
        try{
            if(carrinhoDao.removeById(1L)){
                System.out.println("Removido com sucesso!");
            }else{
                System.out.println("Erro ao remover!");
            }
        } catch (DaoException e) {
            Logger.getLogger(TesteExcluirCarrinho.class.getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }
}
