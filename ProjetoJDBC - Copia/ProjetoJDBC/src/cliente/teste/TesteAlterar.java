package cliente.teste;

import cliente.bean.ClienteBean;
import cliente.dao.ClienteDao;
import util.DaoException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TesteAlterar {
    public static void main(String[] args) {
        ClienteDao cd = new ClienteDao();
        try{
            ClienteBean clienteBean = (ClienteBean) cd.selecionar(3);
            clienteBean.setSalario(5500.00F);
            clienteBean.setNome("Fernando");

            cd.alterar(clienteBean);
        }catch(DaoException e){
            Logger.getLogger(TesteAlterar.class.getName()).log(Level.SEVERE,null,e);
        }
    }
}
