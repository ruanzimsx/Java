package com.ifrr.projetojpamaven.cliente.teste;

import com.ifrr.projetojpamaven.cliente.bean.ClienteBean;
import com.ifrr.projetojpamaven.cliente.dao.ClienteDao;
import util.DaoException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TesteSelecionarCliente {
    public static void main(String[] args) {
        try {
            ClienteBean clienteBean = ClienteDao.selecionar(1);
            if(clienteBean != null){
                System.out.println(clienteBean);
            }else{
                System.err.println("Cliente não encontrado");
            }
        } catch (DaoException e) {
            Logger.getLogger(TesteInserirCliente.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
