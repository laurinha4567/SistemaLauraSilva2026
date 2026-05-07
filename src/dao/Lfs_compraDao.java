
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bean.Lfs_compra;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;
import java.sql.PreparedStatement;


/**
 *
 * @author u10918857104
 */
public class Lfs_compraDao extends DaoAbstract {

    public Lfs_compraDao() {

    }

      @Override
public void insert(Object object) {

    Lfs_compra compra = (Lfs_compra) object;

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

        Logger.getLogger(Lfs_compraDao.class.getName()).log(Level.SEVERE, null, ex);

    }
}
}