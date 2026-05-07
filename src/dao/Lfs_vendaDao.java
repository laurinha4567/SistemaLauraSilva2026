
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

            PreparedStatement pst = cnt.prepareStatement(
                    "insert into lfs_venda values(?,?,?,?,?)");

            pst.setInt(1, venda.getLfs_idVenda());

            pst.setDate(2, null); // data venda

            pst.setDouble(3, venda.getLfs_total());

            pst.setInt(4, venda.getLfs_fk_vendedor());

            pst.setInt(5, venda.getLfs_fk_cliente());

            pst.executeUpdate();

        } catch (SQLException ex) {

            Logger.getLogger(Lfs_vendaDao.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

}