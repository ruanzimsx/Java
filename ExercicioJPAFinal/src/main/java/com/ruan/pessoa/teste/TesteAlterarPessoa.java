package com.ruan.pessoa.teste;

import com.ruan.pessoa.bean.PessoaBean;
import com.ruan.pessoa.dao.PessoaDao;
import com.ruan.produto.bean.ProdutoBean;
import com.ruan.produto.dao.ProdutoDao;
import com.ruan.util.DaoException;

import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TesteAlterarPessoa {
    public static void main(String[] args) {
        PessoaBean pessoa = new PessoaBean();
        pessoa.setId(1L);
        pessoa.setName("Teste");
        pessoa.setCpf("Testando");
        pessoa.setDataNascimento(LocalDate.now());
        PessoaDao pessoaDao = new PessoaDao();
        try{
            System.out.println(pessoaDao.replace(pessoa));
            System.out.println("Alterado com sucesso!");
        } catch (DaoException e) {
            Logger.getLogger(TesteAlterarPessoa.class.getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }
}
