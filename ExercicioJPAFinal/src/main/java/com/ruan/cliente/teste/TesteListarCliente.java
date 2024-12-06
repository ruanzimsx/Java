package com.ruan.cliente.teste;

import com.ruan.cliente.bean.ClienteBean;
import com.ruan.cliente.dao.ClienteDao;
import com.ruan.pessoa.bean.PessoaBean;
import com.ruan.pessoa.dao.PessoaDao;
import com.ruan.util.DaoException;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TesteListarCliente {
    public static void main(String[] args) {
        ClienteDao clienteDao = new ClienteDao();
        List<ClienteBean> clienteBeanList;
        try{
            clienteBeanList = (List<ClienteBean>) clienteDao.findAll();
            if(!clienteBeanList.isEmpty()){
                System.out.println("======== Lista de clientes ===========");
                System.out.println(clienteBeanList);
            }
        } catch (DaoException e) {
            Logger.getLogger(TesteListarCliente.class.getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }
}
