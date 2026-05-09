/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bean.Lfs_vendedor;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;
import java.sql.PreparedStatement;


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

            PreparedStatement pst = cnt.prepareStatement(
                    "insert into lfs_vendedor values(?,?,?,?,?,?,?)");

            pst.setInt(1, vendedor.getIdlfs_vendedor());

            pst.setString(2, vendedor.getLfs_descricao());

            pst.setString(3, vendedor.getLfs_nome());

            pst.setString(4, vendedor.getLfs_cpf());

            pst.setDate(5, null); // data nascimento

            pst.setString(6, vendedor.getLfs_telefone());

            pst.setDouble(7, vendedor.getLfs_salario());

            pst.executeUpdate();

        } catch (SQLException ex) {

            Logger.getLogger(Lfs_vendedorDao.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

}

