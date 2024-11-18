package com.ifrr.projetojpamaven.cliente.teste;

import com.ifrr.projetojpamaven.cliente.bean.ClienteBean;
import com.ifrr.projetojpamaven.cliente.dao.ClienteDao;
import util.DaoException;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TesteListarCliente {
    public static void main(String[] args) {
        try {
            List<ClienteBean> listared = (List<ClienteBean>) ClienteDao.listar();
            if(!listared.isEmpty()){
                for(ClienteBean clienteBean : listared){
                    System.out.println(clienteBean);
                }
            }else{
                System.err.println("Erro ao listar clientes");
            }
        } catch (DaoException e) {
            Logger.getLogger(TesteInserirCliente.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
