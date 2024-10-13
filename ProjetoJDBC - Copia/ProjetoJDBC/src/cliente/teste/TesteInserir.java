package cliente.teste;

import cliente.bean.ClienteBean;
import cliente.dao.ClienteDao;
import util.DaoException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TesteInserir {
    public static void main(String[] args) {
        ClienteBean clienteBean = new ClienteBean();
        clienteBean.setNome("Oliviera");
        clienteBean.setSalario(4500F);

        ClienteDao cd = new ClienteDao();

        try{
            cd.inserir(clienteBean);
        }catch(DaoException e){
            Logger.getLogger(TesteInserir.class.getName()).log(Level.SEVERE,null,e);
        }
    }
}
