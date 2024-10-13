package cliente.teste;

import cliente.bean.ClienteBean;
import cliente.dao.ClienteDao;
import util.DaoException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TesteSelecionar {
    public static void main(String[] args) {
        ClienteDao clienteDao = new ClienteDao();
        try{
            ClienteBean clienteBean = (ClienteBean) clienteDao.selecionar(3);
            System.out.println(clienteBean);
        }catch(DaoException e){
            Logger.getLogger(TesteSelecionar.class.getName()).log(Level.SEVERE,null,e);
        }
    }
}
