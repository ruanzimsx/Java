package com.ruan.pessoa.teste;

import com.ruan.pessoa.dao.PessoaDao;
import com.ruan.produto.dao.ProdutoDao;
import com.ruan.util.DaoException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TesteExcluirPessoa {
    public static void main(String[] args) {
        PessoaDao pessoaDao = new PessoaDao();
        try{
            if(pessoaDao.removeById(1L)){
                System.out.println("Removido com sucesso!");
            }else{
                System.out.println("Erro ao remover!");
            }
        } catch (DaoException e) {
            Logger.getLogger(TesteExcluirPessoa.class.getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }
}
