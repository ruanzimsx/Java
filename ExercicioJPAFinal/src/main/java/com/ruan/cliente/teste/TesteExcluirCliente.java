package com.ruan.cliente.teste;

import com.ruan.cliente.dao.ClienteDao;
import com.ruan.pessoa.dao.PessoaDao;
import com.ruan.util.DaoException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TesteExcluirCliente {
    public static void main(String[] args) {
        ClienteDao clienteDao = new ClienteDao();
        try{
            if(clienteDao.removeById(1L)){
                System.out.println("Removido com sucesso!");
            }else{
                System.out.println("Erro ao remover!");
            }
        } catch (DaoException e) {
            Logger.getLogger(TesteExcluirCliente.class.getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }
}
