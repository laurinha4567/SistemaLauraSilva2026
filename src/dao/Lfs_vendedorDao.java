/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bean.Lfs_vendedor;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author u10918857104
 */
public class Lfs_vendedorDao extends DaoAbstract {

    public Lfs_vendedorDao() {

    }

    @Override
    public void insert(Object object) {
        Lfs_vendedor vendedor = (Lfs_vendedor) object;

        try {
            PreparedStatement pst = cnt.prepareStatement("insert into lfs_vendedor values(?,?,?,?,?,?,?)");
            pst.setInt(1, vendedor.getIdlfs_vendedor());
            pst.setString(2, vendedor.getLfs_descricao());
            pst.setString(3, vendedor.getLfs_nome());
            pst.setString(4, vendedor.getLfs_cpf());
            java.sql.Date dataNas = new java.sql.Date(vendedor.getLfs_data_nascimento().getTime());
            pst.setDate(5, dataNas);
            pst.setString(6, vendedor.getLfs_telefone());
            pst.setDouble(7, vendedor.getLfs_salario());

            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Lfs_vendedorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Object object) {
        Lfs_vendedor vendedor = (Lfs_vendedor) object;

        try {
            PreparedStatement pst = cnt.prepareStatement("update lfs_vendedor set lfs_descricao=?, lfs_nome=?, lfs_cpf=?, lfs_data_nascimento=?, lfs_telefone=?, lfs_salario=? where idlfs_vendedor=?");

            pst.setString(1, vendedor.getLfs_descricao());
            pst.setString(2, vendedor.getLfs_nome());
            pst.setString(3, vendedor.getLfs_cpf());
            java.sql.Date dataNas = new java.sql.Date(vendedor.getLfs_data_nascimento().getTime());
            pst.setDate(4, dataNas);
            pst.setString(5, vendedor.getLfs_telefone());
            pst.setInt(6, vendedor.getIdlfs_vendedor());
            pst.setDouble(7, vendedor.getLfs_salario());

            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Lfs_vendedorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Object object) {
        Lfs_vendedor vendedor = (Lfs_vendedor) object;

        try {
            PreparedStatement pst = cnt.prepareStatement("delete from lfs_vendedor where idlfs_vendedor=?");
            pst.setInt(1, vendedor.getIdlfs_vendedor());

            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Lfs_vendedorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object list(int id) {
        try {
            PreparedStatement pst = cnt.prepareStatement("select * from lfs_vendedor where idlfs_vendedor=?");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                Lfs_vendedor vendedor = new Lfs_vendedor();

                vendedor.setIdlfs_vendedor(rs.getInt("idlfs_vendedor"));
                vendedor.setLfs_descricao(rs.getString("lfs_descricao"));
                vendedor.setLfs_nome(rs.getString("lfs_nome"));
                vendedor.setLfs_cpf(rs.getString("lfs_cpf"));
                vendedor.setLfs_data_nascimento(rs.getDate("lfs_data_nascimento"));
                vendedor.setLfs_telefone(rs.getString("lfs_telefone"));
                vendedor.setLfs_salario(rs.getDouble("lfs_salario"));

                return vendedor;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Lfs_vendedorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Object listaAll() {
        List lista;

        try {
            PreparedStatement pst = cnt.prepareStatement("SELECT * FROM lfs_vendedor");
            lista = new ArrayList();
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Lfs_vendedor vendedor = new Lfs_vendedor();
                vendedor.setIdlfs_vendedor(rs.getInt("idlfs_vendedor"));
                vendedor.setLfs_descricao(rs.getString("lfs_descricao"));
                vendedor.setLfs_nome(rs.getString("lfs_nome"));
                vendedor.setLfs_cpf(rs.getString("lfs_cpf"));
                vendedor.setLfs_data_nascimento(rs.getDate("lfs_data_nascimento"));
                vendedor.setLfs_telefone(rs.getString("lfs_telefone"));
                vendedor.setLfs_salario(rs.getDouble("lfs_salario"));

                lista.add(vendedor);
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(Lfs_vendedorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void main(String[] args) {
        Lfs_vendedorDao vendedorDao = new Lfs_vendedorDao();
        Lfs_vendedor vendedor = new Lfs_vendedor();

        vendedor.setIdlfs_vendedor(2);
        vendedor.setLfs_descricao("Venda de jogos de aventura");
        vendedor.setLfs_nome("Carlos Mendes");
        vendedor.setLfs_cpf("98765432100");
        vendedor.setLfs_telefone("(11)987654321");
        vendedor.setLfs_salario(1200.32);

        vendedorDao.insert(vendedor);
    }
}
