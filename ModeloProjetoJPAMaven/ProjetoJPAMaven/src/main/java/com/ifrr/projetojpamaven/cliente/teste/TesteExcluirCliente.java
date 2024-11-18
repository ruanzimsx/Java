package com.ifrr.projetojpamaven.cliente.teste;

import com.ifrr.projetojpamaven.cliente.dao.ClienteDao;
import util.DaoException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TesteExcluirCliente {
    public static void main(String[] args) {
        try {
            if (ClienteDao.excluir(2)) {
                System.out.println("Excluido com sucesso");
            } else {
                System.err.println("Erro ao excluir");
            }

        } catch (DaoException e) {
            Logger.getLogger(TesteInserirCliente.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
