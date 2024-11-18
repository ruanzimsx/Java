package com.ifrr.projetojpamaven.cliente.teste;

import com.ifrr.projetojpamaven.cliente.bean.ClienteBean;
import com.ifrr.projetojpamaven.cliente.dao.ClienteDao;
import util.DaoException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TesteAlterarCliente {
    public static void main(String[] args) {
        ClienteBean clienteBean = new ClienteBean();
        clienteBean.setId(1);
        clienteBean.setNome("Ruan Alterado");
        clienteBean.setSalario(25000);

        try {
            ClienteBean alterared = ClienteDao.alterar(clienteBean);
            System.out.println(alterared);
        } catch (DaoException e) {
            Logger.getLogger(TesteInserirCliente.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
