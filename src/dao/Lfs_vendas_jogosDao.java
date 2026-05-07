/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bean.Lfs_vendas_jogos;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author u10918857104
 */
public class Lfs_vendas_jogosDao extends DaoAbstract {

    public Lfs_vendas_jogosDao() {

    }

    @Override
    public void insert(Object object) {
        Lfs_vendas_jogos vendaJogo = (Lfs_vendas_jogos) object;

        try {
            PreparedStatement pst = cnt.prepareStatement("insert into lfs_vendas_jogos values(?,?,?,?,?,?)");
            pst.setInt(1, vendaJogo.getLfs_idVenda_jogos());
            pst.setInt(2, vendaJogo.getLfs_fk_jogos());
            pst.setInt(3, vendaJogo.getLfs_fks_idVenda());
            pst.setInt(4, vendaJogo.getLfs_quantidade());
            pst.setDouble(5, vendaJogo.getLfs_valor_unitario());
            pst.setString(6, vendaJogo.getLfs_observacoes());

            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Lfs_vendas_jogosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Object object) {
        Lfs_vendas_jogos vendaJogo = (Lfs_vendas_jogos) object;

        try {
            PreparedStatement pst = cnt.prepareStatement("update lfs_vendas_jogos set lfs_fk_jogos=?, lfs_fks_idVenda=?, lfs_quantidade=?, lfs_valor_unitario=?, lfs_observacoes=? where lfs_idVenda_jogos=?");

            pst.setInt(1, vendaJogo.getLfs_fk_jogos());
            pst.setInt(2, vendaJogo.getLfs_fks_idVenda());
            pst.setInt(3, vendaJogo.getLfs_quantidade());
            pst.setDouble(4, vendaJogo.getLfs_valor_unitario());
            pst.setString(5, vendaJogo.getLfs_observacoes());
            pst.setInt(6, vendaJogo.getLfs_idVenda_jogos());

            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Lfs_vendas_jogosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Object object) {
        Lfs_vendas_jogos vendaJogo = (Lfs_vendas_jogos) object;

        try {
            PreparedStatement pst = cnt.prepareStatement("delete from lfs_vendas_jogos where lfs_idVenda_jogos=?");
            pst.setInt(1, vendaJogo.getLfs_idVenda_jogos());

            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Lfs_vendas_jogosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object list(int id) {
        try {
            PreparedStatement pst = cnt.prepareStatement("select * from lfs_vendas_jogos where lfs_idVenda_jogos=?");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                Lfs_vendas_jogos vendaJogo = new Lfs_vendas_jogos();

                vendaJogo.setLfs_idVenda_jogos(rs.getInt("lfs_idVenda_jogos"));
                vendaJogo.setLfs_fk_jogos(rs.getInt("lfs_fk_jogos"));
                vendaJogo.setLfs_fks_idVenda(rs.getInt("lfs_fks_idVenda"));
                vendaJogo.setLfs_quantidade(rs.getInt("lfs_quantidade"));
                vendaJogo.setLfs_valor_unitario(rs.getDouble("lfs_valor_unitario"));
                vendaJogo.setLfs_observacoes(rs.getString("lfs_observacoes"));

                return vendaJogo;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Lfs_vendas_jogosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Object listaAll() {
        List lista;

        try {
            PreparedStatement pst = cnt.prepareStatement("select * from usuario ");
            lista = new ArrayList();
            ResultSet rs = pst.executeQuery();
            while (rs.next() == true) {
                Lfs_vendas_jogos vendaJogo = new Lfs_vendas_jogos();
                vendaJogo.setLfs_idVenda_jogos(rs.getInt("lfs_idVenda_jogos"));
                vendaJogo.setLfs_fk_jogos(rs.getInt("lfs_fk_jogos"));
                vendaJogo.setLfs_fks_idVenda(rs.getInt("lfs_fks_idVenda"));
                vendaJogo.setLfs_quantidade(rs.getInt("lfs_quantidade"));
                vendaJogo.setLfs_valor_unitario(rs.getDouble("lfs_valor_unitario"));
                vendaJogo.setLfs_observacoes(rs.getString("lfs_observacoes"));

                lista.add(vendaJogo);
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public static void main(String[] args) {
        Lfs_vendas_jogosDao vendasJogosDao = new Lfs_vendas_jogosDao();
        Lfs_vendas_jogos vendaJogo = new Lfs_vendas_jogos();

        vendaJogo.setLfs_idVenda_jogos(1);
        vendaJogo.setLfs_fk_jogos(1);
        vendaJogo.setLfs_fks_idVenda(1);
        vendaJogo.setLfs_quantidade(2);
        vendaJogo.setLfs_valor_unitario(199.90);
        vendaJogo.setLfs_observacoes("Venda realizada com sucesso");

        vendasJogosDao.insert(vendaJogo);
    }
}
