/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente.dao;

import cliente.bean.ClienteBean;
import conta.bean.ContaBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.BaseDao;
import util.ConexaoPostGreSql;
import util.DaoException;

/**
 *
 * @author mayunia
 */
public class ClienteDao implements BaseDao {

    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

    @Override
    public Object inserir(Object obj) throws DaoException {
        ClienteBean clienteBean = (ClienteBean) obj;
        String sql = "insert into cliente(nome, salario) values(?, ?)";
        try {
            con = ConexaoPostGreSql.getConexao();
            pst = con.prepareStatement(sql);
            pst.setString(1, clienteBean.getNome());
            pst.setFloat(2, clienteBean.getSalario());
            pst.execute();
            return clienteBean;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexaoPostGreSql.fechar(pst);
            ConexaoPostGreSql.fechar(con);
        }
        return null;
    }

    @Override
    public Object alterar(Object obj) throws DaoException {
       ClienteBean cliente = (ClienteBean) obj;
       
       String sql = "update cliente set nome = ?, salario = ? where codigo = ?";
       
        try {
            con = ConexaoPostGreSql.getConexao();
            pst = con.prepareStatement(sql);
            pst.setString(1, cliente.getNome());
            pst.setFloat(2, cliente.getSalario());
            pst.setInt(3, cliente.getCodigo());
            pst.execute();
            
            return cliente;
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConexaoPostGreSql.fechar(pst);
            ConexaoPostGreSql.fechar(con);
        }
        return null;
    }

    @Override
    public Boolean excluir(Integer codigo) throws DaoException {
        String sql = "delete from cliente where codigo = ?";
        
        con = ConexaoPostGreSql.getConexao();
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, codigo);
            pst.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConexaoPostGreSql.fechar(pst);
            ConexaoPostGreSql.fechar(con);
        }
        return false;
    }

    @Override
    public Object selecionar(Integer codigo) throws DaoException {
        ClienteBean clienteBean;
        String sql = "select * from cliente where codigo = ?";
        try {
            con = ConexaoPostGreSql.getConexao();
            pst = con.prepareStatement(sql);
            pst.setInt(1, codigo);
            rs = pst.executeQuery();
            if (rs.next() == true) {
                clienteBean = new ClienteBean();
                clienteBean.setCodigo(rs.getInt(1));
                clienteBean.setNome(rs.getString(2));
                clienteBean.setSalario(rs.getFloat(3));
                return clienteBean;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexaoPostGreSql.fechar(rs);
            ConexaoPostGreSql.fechar(pst);
            ConexaoPostGreSql.fechar(con);
        }
        return null;
    }

    @Override
    public Collection listar() throws DaoException {
        ClienteBean clienteBean;
        ArrayList<ClienteBean> clientes = new ArrayList<ClienteBean>();
        String sql = "select * from cliente";
        
        try {
            con = ConexaoPostGreSql.getConexao();
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next() == true){
               clienteBean = new ClienteBean();
               clienteBean.setCodigo(rs.getInt(1));
               clienteBean.setNome(rs.getString(2));
               clienteBean.setSalario(rs.getFloat(3));
               clientes.add(clienteBean);
            }
            return clientes;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConexaoPostGreSql.fechar(rs);
            ConexaoPostGreSql.fechar(pst);
            ConexaoPostGreSql.fechar(con);
        }
        return null;
    }

}
