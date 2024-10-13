/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conta.dao;

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
public class ContaDao implements BaseDao {

    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;


    @Override
    public Object inserir(Object obj) throws DaoException {
        ContaBean contaBean = (ContaBean) obj;
        String sql = "insert into conta(nome, saldo, limite) values(?, ?, ?)";
        try {
            con = ConexaoPostGreSql.getConexao();
            pst = con.prepareStatement(sql);
            pst.setString(1, contaBean.getNome());
            pst.setFloat(2, contaBean.getSaldo());
            pst.setFloat(3, contaBean.getLimite());
            pst.execute();
            return contaBean;
        } catch (SQLException ex) {
            Logger.getLogger(ContaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexaoPostGreSql.fechar(pst);
            ConexaoPostGreSql.fechar(con);
        }
        return null;
    }

    @Override
    public Object alterar(Object obj) throws DaoException {
       ContaBean conta = (ContaBean) obj;
       
       String sql = "update conta set nome = ?, saldo = ?, limite = ? where codigo = ?";
       
        try {
            con = ConexaoPostGreSql.getConexao();
            pst = con.prepareStatement(sql);
            pst.setString(1, conta.getNome());
            pst.setFloat(2, conta.getSaldo());
            pst.setFloat(3, conta.getLimite());
            pst.setInt(4, conta.getCodigo());
            pst.execute();
            
            return conta;
            
        } catch (SQLException ex) {
            Logger.getLogger(ContaDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConexaoPostGreSql.fechar(pst);
            ConexaoPostGreSql.fechar(con);
        }
        return null;
    }

    @Override
    public Boolean excluir(Integer codigo) throws DaoException {
        String sql = "delete from conta where codigo = ?";
        
        con = ConexaoPostGreSql.getConexao();
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, codigo);
            pst.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ContaDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConexaoPostGreSql.fechar(pst);
            ConexaoPostGreSql.fechar(con);
        }
        return false;
    }

    @Override
    public Object selecionar(Integer codigo) throws DaoException {
        ContaBean contaBean;
        String sql = "select * from conta where codigo = ?";
        try {
            con = ConexaoPostGreSql.getConexao();
            pst = con.prepareStatement(sql);
            pst.setInt(1, codigo);
            rs = pst.executeQuery();
            if (rs.next() == true) {
                contaBean = new ContaBean();
                contaBean.setCodigo(rs.getInt(1));
                contaBean.setNome(rs.getString(2));
                contaBean.setSaldo(rs.getFloat(3));
                contaBean.setLimite(rs.getFloat(4));
                return contaBean;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ContaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexaoPostGreSql.fechar(rs);
            ConexaoPostGreSql.fechar(pst);
            ConexaoPostGreSql.fechar(con);
        }
        return null;
    }

    @Override
    public Collection listar() throws DaoException {
        ContaBean contaBean;
        ArrayList<ContaBean> contas = new ArrayList<ContaBean>();
        String sql = "select * from conta";
        
        try {
            con = ConexaoPostGreSql.getConexao();
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next() == true){
               contaBean = new ContaBean();
               contaBean.setCodigo(rs.getInt(1));
               contaBean.setNome(rs.getString(2));
               contaBean.setSaldo(rs.getFloat(3));
               contaBean.setLimite(rs.getFloat(4));
               contas.add(contaBean);
            }
            return contas;
        } catch (SQLException ex) {
            Logger.getLogger(ContaDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConexaoPostGreSql.fechar(rs);
            ConexaoPostGreSql.fechar(pst);
            ConexaoPostGreSql.fechar(con);
        }
        return null;
    }

}
