package com.ruan.pessoa.teste;

import com.ruan.pessoa.bean.PessoaBean;
import com.ruan.pessoa.dao.PessoaDao;
import com.ruan.produto.bean.ProdutoBean;
import com.ruan.produto.dao.ProdutoDao;
import com.ruan.util.DaoException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TesteSelecionarPessoa {
    public static void main(String[] args) {
        PessoaDao produtoDao = new PessoaDao();
        try{
            PessoaBean pessoaBean = produtoDao.findById(1L);
            if(pessoaBean != null){
                System.out.println(pessoaBean);
            }else{
                System.out.println("Erro ao encontrar pessoa!");
            }
        }catch(DaoException e){
            Logger.getLogger(TesteSelecionarPessoa.class.getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }
}
