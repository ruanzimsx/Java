package com.ruan.cliente.teste;

import com.ruan.cliente.bean.ClienteBean;
import com.ruan.cliente.dao.ClienteDao;
import com.ruan.pessoa.bean.PessoaBean;
import com.ruan.pessoa.dao.PessoaDao;
import com.ruan.util.DaoException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TesteSelecionarCliente {
    public static void main(String[] args) {
        ClienteDao clienteDao = new ClienteDao();
        try{
            ClienteBean clienteBean = clienteDao.findById(1L);
            if(clienteBean != null){
                System.out.println(clienteBean);
            }else{
                System.out.println("Erro ao encontrar cliente!");
            }
        }catch(DaoException e){
            Logger.getLogger(TesteSelecionarCliente.class.getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }
}
