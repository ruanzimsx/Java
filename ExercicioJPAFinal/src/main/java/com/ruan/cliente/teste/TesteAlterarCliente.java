package com.ruan.cliente.teste;

import com.ruan.cliente.bean.ClienteBean;
import com.ruan.cliente.dao.ClienteDao;
import com.ruan.pessoa.bean.PessoaBean;
import com.ruan.pessoa.dao.PessoaDao;
import com.ruan.util.DaoException;

import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TesteAlterarCliente {
    public static void main(String[] args) {
        ClienteBean clienteBean = new ClienteBean();
        clienteBean.setId(1L);
        clienteBean.setName("Teste");
        clienteBean.setCpf("Testando");
        clienteBean.setDataNascimento(LocalDate.of(2021,2,10));

        ClienteDao clienteDao = new ClienteDao();
        try{
            System.out.println(clienteDao.replace(clienteBean));
            System.out.println("Alterado com sucesso!");
        } catch (DaoException e) {
            Logger.getLogger(TesteAlterarCliente.class.getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }
}
