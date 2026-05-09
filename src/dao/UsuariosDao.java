/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bean.Lfs_Usuarios;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;
import java.sql.PreparedStatement;


/**
 *
 * @author u10918857104
 */
public class UsuariosDao extends DaoAbstract {

    public UsuariosDao() {

    }

    @Override
    public void insert(Object object) {
        Lfs_Usuarios usuario = (Lfs_Usuarios) object;

        try {
            PreparedStatement pst = cnt.prepareStatement("insert into usuario values(?,?,?,?,?,?,?,?)");
            pst.setInt(1, usuario.getIdusuarios());
            pst.setString(2, usuario.getNome());//nome
            pst.setString(3, usuario.getApelido());//apelido
            pst.setString(4, usuario.getCpf());//cpf            
            pst.setDate(5, null);//data nas
            pst.setString(6, usuario.getSenha());//senha
            pst.setInt(7, usuario.getNivel());//nivel
            pst.setString(8, usuario.getAtivo());//ativo
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   }