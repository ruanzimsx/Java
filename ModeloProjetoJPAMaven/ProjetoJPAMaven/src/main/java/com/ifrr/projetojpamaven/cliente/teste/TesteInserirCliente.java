package com.ifrr.projetojpamaven.cliente.teste;

import com.ifrr.projetojpamaven.cliente.bean.ClienteBean;
import com.ifrr.projetojpamaven.cliente.dao.ClienteDao;
import util.DaoException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TesteInserirCliente {
    public static void main(String[] args) {
        ClienteBean clienteBean = new ClienteBean();
        clienteBean.setNome("Marcela");
        clienteBean.setSalario(254000);

        try {
            ClienteBean inserired = ClienteDao.inserir(clienteBean);
            System.out.println(inserired);
        } catch (DaoException e) {
            Logger.getLogger(TesteInserirCliente.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
