/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bean.Lfs_venda;
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
public class Lfs_vendaDao extends DaoAbstract {

    public Lfs_vendaDao() {
       
    }

    @Override
    public void insert(Object object) {
        Lfs_venda venda = (Lfs_venda) object;

        try {
            PreparedStatement pst = cnt.prepareStatement("insert into lfs_venda values(?,?,?,?,?,?,?)");
            pst.setInt(1, venda.getLfs_idVenda());
            java.sql.Date dataVenda = new java.sql.Date(venda.getLfs_dataVenda().getTime());
            pst.setDate(2, dataVenda);//data venda
            pst.setDouble(3, venda.getLfs_total());
            pst.setString(4, venda.getLfs_status_Venda());
            pst.setString(5, venda.getLfs_observacoes());
            pst.setInt(6, 1);
            pst.setInt(7, 1);

            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Lfs_vendaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Object object) {
        Lfs_venda venda = (Lfs_venda) object;

        try {
            PreparedStatement pst = cnt.prepareStatement("update lfs_venda set lfs_dataVenda=?, lfs_total=?, lfs_status_Venda=?, lfs_observacoes=?, lfs_fk_vendedor=?, lfs_fk_cliente=? where lfs_idVenda=?");

            java.sql.Date dataVenda = new java.sql.Date(venda.getLfs_dataVenda().getTime());
            pst.setDate(1, dataVenda);//data venda
            pst.setDouble(2, venda.getLfs_total());
            pst.setString(3, venda.getLfs_status_Venda());
            pst.setString(4, venda.getLfs_observacoes());
            pst.setInt(5, 1);
            pst.setInt(6, 1);
            pst.setInt(7, venda.getLfs_idVenda());

            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Lfs_vendaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Object object) {
        Lfs_venda venda = (Lfs_venda) object;

        try {
            PreparedStatement pst = cnt.prepareStatement("delete from lfs_venda where lfs_idVenda=?");
            pst.setInt(1, venda.getLfs_idVenda());

            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Lfs_vendaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object list(int id) {
        try {
            PreparedStatement pst = cnt.prepareStatement("select * from lfs_venda where lfs_idVenda=?");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                Lfs_venda venda = new Lfs_venda();

                venda.setLfs_idVenda(rs.getInt("lfs_idVenda"));
                venda.setLfs_dataVenda(rs.getDate("lfs_dataVenda"));
                venda.setLfs_total(rs.getDouble("lfs_total"));
                venda.setLfs_status_Venda(rs.getString("lfs_status_Venda"));
                venda.setLfs_observacoes(rs.getString("lfs_observacoes"));
                venda.setLfs_fk_vendedor(rs.getInt("lfs_fk_vendedor"));
                venda.setLfs_fk_cliente(rs.getInt("lfs_fk_cliente"));

                return venda;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Lfs_vendaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Object listaAll() {
          List lista;

        try {
            PreparedStatement pst = cnt.prepareStatement("select * from lfs_venda ");
            lista = new ArrayList();
            ResultSet rs = pst.executeQuery();
            while (rs.next() == true) {
                Lfs_venda venda = new Lfs_venda();
                venda.setLfs_idVenda(rs.getInt("lfs_idVenda"));
                venda.setLfs_dataVenda(rs.getDate("lfs_dataVenda"));
                venda.setLfs_total(rs.getDouble("lfs_total"));
                venda.setLfs_status_Venda(rs.getString("lfs_status_Venda"));
                venda.setLfs_observacoes(rs.getString("lfs_observacoes"));
                venda.setLfs_fk_vendedor(rs.getInt("lfs_fk_vendedor"));
                venda.setLfs_fk_cliente(rs.getInt("lfs_fk_cliente"));

                lista.add(venda);
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public static void main(String[] args) {
        Lfs_vendaDao vendaDao = new Lfs_vendaDao();
        Lfs_venda venda = new Lfs_venda();

        venda.setLfs_idVenda(1);
        venda.setLfs_dataVenda(null);
        venda.setLfs_total(199.90);
        venda.setLfs_status_Venda("Concluída");
        venda.setLfs_observacoes("Pagamento via cartão");
        venda.setLfs_fk_vendedor(1);
        venda.setLfs_fk_cliente(1);

        vendaDao.insert(venda);
    }
}
