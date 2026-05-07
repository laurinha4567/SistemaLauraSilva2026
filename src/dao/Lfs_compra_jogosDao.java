/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bean.Lfs_vendas_jogos;
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
public class Lfs_compra_jogosDao extends DaoAbstract {

    public Lfs_compra_jogosDao() {

    }

    @Override

public void insert(Object object) {

    Lfs_compras_produtos compraProduto = (Lfs_compras_produtos) object;

    try {

        PreparedStatement pst = cnt.prepareStatement(
                "insert into lfs_compras_produtos values(?,?,?)");

        pst.setInt(1, compraProduto.getLfs_id_compra());

        pst.setInt(2, compraProduto.getLfs_quantidade());

        pst.setDouble(3, compraProduto.getLfs_preco_unitario());

        pst.executeUpdate();

    } catch (SQLException ex) {

        Logger.getLogger(Lfs_compras_produtosDao.class.getName()).log(Level.SEVERE, null, ex);

    }

}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bean.Lfs_vendas_jogos;
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
public class Lfs_compra_jogosDao extends DaoAbstract {

    public Lfs_compra_jogosDao() {

    }

    @Override
    public void insert(Object object) {

        Lfs_vendas_jogos vendaJogo = (Lfs_vendas_jogos) object;

        try {

            PreparedStatement pst = cnt.prepareStatement(
                    "insert into lfs_vendas_jogos values(?,?,?,?,?)");

            pst.setInt(1, 1);

            pst.setInt(2, 1);

            pst.setInt(3, 1);

            pst.setInt(4, 2);

            pst.setDouble(5, 199.99);

            pst.executeUpdate();

            ResultSet rs = pst.executeQuery();

            while (rs.next() == true) {

                System.out.println("codigo:" + rs.getInt("lfs_idVenda_jogos"));
                System.out.println("valor:" + rs.getDouble("lfs_valor_unitario"));

            }

        } catch (SQLException ex) {

            Logger.getLogger(Lfs_vendas_jogosDao.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

}