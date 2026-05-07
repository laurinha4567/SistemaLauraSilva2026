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
public class Lfs_compraDao extends DaoAbstract {

    public Lfs_compraDao() {

    }

    @Override
    public void insert(Object object) {

        Lfs_venda venda = (Lfs_venda) object;

        try {

            PreparedStatement pst = cnt.prepareStatement(
                    "insert into lfs_venda values(?,?,?,?,?)");

            pst.setInt(1, 1);

            pst.setDate(2, null); // data venda

            pst.setDouble(3, 299.99);

            pst.setInt(4, 1);

            pst.setInt(5, 1);

            pst.executeUpdate();

            ResultSet rs = pst.executeQuery();

            while (rs.next() == true) {

                System.out.println("codigo:" + rs.getInt("lfs_idVenda"));
                System.out.println("total:" + rs.getDouble("lfs_total"));

            }

        } catch (SQLException ex) {

            Logger.getLogger(Lfs_compraDao.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

}

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
public class Lfs_compraDao extends DaoAbstract {

    public Lfs_compraDao() {

    }

    @Override
    public void insert(Object object) {

      @Override
public void insert(Object object) {

    Lfs_compras compra = (Lfs_compras) object;

    try {

        PreparedStatement pst = cnt.prepareStatement(
                "insert into lfs_compras values(?,?,?,?,?)");

        pst.setInt(1, compra.getLfs_idCompra());

        pst.setDate(2, null); // data compra

        pst.setDouble(3, compra.getLfs_total());

        pst.setInt(4, compra.getLfs_fk_fornecedor());

        pst.setInt(5, compra.getLfs_fk_usuarios());

        pst.executeUpdate();

    } catch (SQLException ex) {

        Logger.getLogger(Lfs_comprasDao.class.getName()).log(Level.SEVERE, null, ex);

    }
}
    