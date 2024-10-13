package cliente.teste;

import cliente.bean.ClienteBean;
import cliente.dao.ClienteDao;
import util.DaoException;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TesteListar {
    public static void main(String[] args) {
        ClienteDao cd = new ClienteDao();
        try{
            ArrayList<ClienteBean> clientes= (ArrayList<ClienteBean>) cd.listar();
            for(ClienteBean clienteBean : clientes){
                System.out.println(clienteBean);
            }
        }catch(DaoException e){
            Logger.getLogger(TesteListar.class.getName()).log(Level.SEVERE,null,e);
        }
    }
}
