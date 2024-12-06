package com.ruan.pessoa.teste;

import com.ruan.pessoa.bean.PessoaBean;
import com.ruan.pessoa.dao.PessoaDao;
import com.ruan.produto.bean.ProdutoBean;
import com.ruan.produto.dao.ProdutoDao;
import com.ruan.util.DaoException;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TesteListarPessoa {
    public static void main(String[] args) {
        PessoaDao pessoaDao = new PessoaDao();
        List<PessoaBean> pessoaBeanList;
        try{
            pessoaBeanList = (List<PessoaBean>) pessoaDao.findAll();
            if(!pessoaBeanList.isEmpty()){
                System.out.println("======== Lista de pessoas ===========");
                System.out.println(pessoaBeanList);
            }
        } catch (DaoException e) {
            Logger.getLogger(TesteListarPessoa.class.getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }
}
