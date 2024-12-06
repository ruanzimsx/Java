package com.ruan.pessoa.teste;

import com.ruan.categoria.bean.CategoriaBean;
import com.ruan.pessoa.bean.PessoaBean;
import com.ruan.pessoa.dao.PessoaDao;
import com.ruan.produto.bean.ProdutoBean;
import com.ruan.produto.dao.ProdutoDao;
import com.ruan.util.DaoException;

import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TesteInserirPessoa {
    public static void main(String[] args) {
        PessoaBean pessoaBean = new PessoaBean();
        pessoaBean.setName("Ruan");
        pessoaBean.setCpf("059656789302");
        pessoaBean.setDataNascimento(LocalDate.of(2004,7,14));
        PessoaDao pessoaDao = new PessoaDao();
        try{
            System.out.println(pessoaDao.save(pessoaBean));
        } catch (DaoException e) {
            Logger.getLogger(TesteInserirPessoa.class.getName()).log(Level.SEVERE,null, e);
        }
    }
}
