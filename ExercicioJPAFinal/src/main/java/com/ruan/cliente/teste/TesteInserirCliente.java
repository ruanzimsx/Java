package com.ruan.cliente.teste;

import com.ruan.cliente.bean.ClienteBean;
import com.ruan.cliente.dao.ClienteDao;
import com.ruan.pessoa.bean.PessoaBean;
import com.ruan.pessoa.dao.PessoaDao;
import com.ruan.util.DaoException;

import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TesteInserirCliente {
    public static void main(String[] args) {
        ClienteBean clienteBean = new ClienteBean();
        clienteBean.setName("Eduardo");
        clienteBean.setCpf("0594321311");
        clienteBean.setDataNascimento(LocalDate.now());

        ClienteDao clienteDao = new ClienteDao();
        try{
            System.out.println(clienteDao.save(clienteBean));
        } catch (DaoException e) {
            Logger.getLogger(TesteInserirCliente.class.getName()).log(Level.SEVERE,null, e);
        }
    }
}
