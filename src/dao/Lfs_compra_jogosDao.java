/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bean.Lfs_compras_jogos;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;
import java.sql.PreparedStatement;


/**
 *
 * @author u10918857104
 */
public class Lfs_compra_jogosDao extends DaoAbstract {

    public Lfs_compra_jogosDao() {

    }

    @Override

public void insert(Object object) {

    Lfs_compras_jogos comprasJogo= (Lfs_compras_jogos) object;

    try {

        PreparedStatement pst = cnt.prepareStatement(
                "insert into lfs_compras_produtos values(?,?,?)");

        pst.setInt(1, comprasJogo.getLfs_id_compra());

        pst.setInt(2, comprasJogo.getLfs_quantidade());

        pst.setDouble(3, comprasJogo.getLfs_preco_unitario());

        pst.executeUpdate();

    } catch (SQLException ex) {

        Logger.getLogger(Lfs_compra_jogosDao.class.getName()).log(Level.SEVERE, null, ex);

    }

}
}