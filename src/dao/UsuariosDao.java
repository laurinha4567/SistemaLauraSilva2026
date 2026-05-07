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
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
            java.sql.Date dataNas = new java.sql.Date(usuario.getDataNascimento().getTime());
            pst.setDate(5, dataNas);//data nas
            pst.setString(6, usuario.getSenha());//senha
            pst.setInt(7, usuario.getNivel());//nivel
            pst.setString(8, usuario.getAtivo());//ativo
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Object object) {
        Lfs_Usuarios usuario = (Lfs_Usuarios) object;

        try {
            PreparedStatement pst = cnt.prepareStatement("update usuario set nome=?, apelido=?, cpf=?, dataNascimento=?, senha=?, nivel=?,ativo=? where idusuario=?");
            pst.setInt(8, usuario.getIdusuarios());
            pst.setString(1, usuario.getNome());//nome
            pst.setString(2, usuario.getApelido());//apelido
            pst.setString(3, usuario.getCpf());//cpf
            java.sql.Date dataNas = new java.sql.Date(usuario.getDataNascimento().getTime());
            pst.setDate(4, dataNas);//data nas
            pst.setString(5, usuario.getSenha());//senha
            pst.setInt(6, usuario.getNivel());//nivel
            pst.setString(7, usuario.getAtivo());//ativo
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Object object) {
        Lfs_Usuarios usuario = (Lfs_Usuarios) object;

        try {
            PreparedStatement pst = cnt.prepareStatement("delete from usuario where idusuario=?");
            pst.setInt(1, usuario.getIdusuarios());

            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object list(int id) {

        try {
            PreparedStatement pst = cnt.prepareStatement("select * from usuario where idusuario=?");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next() == true) {
                Lfs_Usuarios usuario = new Lfs_Usuarios();

                usuario.setIdusuarios(rs.getInt("idusuario"));
                usuario.setNome(rs.getString("nome"));
                usuario.setApelido(rs.getString("apelido"));
                usuario.setCpf(rs.getString("cpf"));
                usuario.setDataNascimento(rs.getDate("dataNascimento"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setNivel(rs.getInt("nivel"));
                usuario.setAtivo(rs.getString("ativo"));

                return usuario;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean listLogin(String apelido, String senha) {
        try {
            PreparedStatement pst = cnt.prepareStatement("select * from usuario where apelido=? and senha=?");
            pst.setString(1, apelido    );
            pst.setString(2, senha);
            ResultSet rs = pst.executeQuery();
            if (rs.next() == true) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Object listaAll() {
        List lista;

        try {
            PreparedStatement pst = cnt.prepareStatement("select * from usuario ");
            lista = new ArrayList();
            ResultSet rs = pst.executeQuery();
            while (rs.next() == true) {
                Lfs_Usuarios usuarios = new Lfs_Usuarios();
                usuarios.setIdusuarios(rs.getInt("idusuario"));
                usuarios.setNome(rs.getString("nome"));
                usuarios.setApelido(rs.getString("apelido"));
                usuarios.setCpf(rs.getString("cpf"));
                usuarios.setDataNascimento(rs.getDate("dataNascimento"));
                usuarios.setSenha(rs.getString("senha"));
                usuarios.setNivel(rs.getInt("nivel"));
                usuarios.setAtivo(rs.getString("ativo"));

                lista.add(usuarios);
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public static void main(String[] args) {
        UsuariosDao usuarioDao = new UsuariosDao();
        Lfs_Usuarios usuario = new Lfs_Usuarios();

        usuario.setIdusuarios(1);
        usuario.setNome("Maria Silva");
        usuario.setApelido("marias");
        usuario.setCpf("111.222.333-44");
        usuario.setSenha("senhaSegura123");
        usuario.setNivel(2);
        usuario.setAtivo("S");

        usuarioDao.insert(usuario);
    }

}
