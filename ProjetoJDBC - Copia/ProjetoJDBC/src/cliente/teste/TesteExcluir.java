package cliente.teste;

import cliente.dao.ClienteDao;
import util.DaoException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TesteExcluir {
    public static void main(String[] args) {
        ClienteDao clienteDao = new ClienteDao();
        try{
            Boolean isRemove = clienteDao.excluir(2);
            System.out.println("Excluido: "+isRemove);
        }catch(DaoException e){
            Logger.getLogger(TesteExcluir.class.getName()).log(Level.SEVERE,null,e);
        }
    }
}
