/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bean.Lfs_cliente;
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
public class Lfs_clienteDao extends DaoAbstract {

    public Lfs_clienteDao() {

    }

    @Override
    public void insert(Object object) {
        Lfs_cliente cliente = (Lfs_cliente) object;

        try {
            PreparedStatement pst = cnt.prepareStatement("insert into lfs_cliente values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, cliente.getIdlfs_Cliente());
            pst.setString(2, cliente.getLfs_Nome_completo());
            pst.setString(3, cliente.getLfs_genero());
            pst.setString(4, cliente.getLfs_cpf());
            java.sql.Date dataNas = new java.sql.Date(cliente.getLfs_dataNascimento().getTime());
            pst.setDate(5, dataNas);
            pst.setString(6, cliente.getLfs_senha());
            pst.setString(7, cliente.getLfs_RG());
            pst.setString(8, cliente.getLfs_Cep());
            pst.setString(9, cliente.getLfs_email());
            pst.setString(10, cliente.getLfs_telefone());
            pst.setString(11, cliente.getLfs_forma_pagamento());
            java.sql.Date dataUltimoLogin = new java.sql.Date(cliente.getLfs_dataUltimoLogin().getTime());
            pst.setDate(12, dataUltimoLogin);
            pst.setString(13, cliente.getLfs_preferencias());
            pst.setString(14, cliente.getLfs_observacoes());
            java.sql.Date dataCadastro = new java.sql.Date(cliente.getLfs_dataCadastro().getTime());
            pst.setDate(15, dataCadastro);

            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Lfs_clienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Object object) {
        Lfs_cliente cliente = (Lfs_cliente) object;

        try {
            PreparedStatement pst = cnt.prepareStatement("update lfs_cliente set lfs_Nome_completo=?, lfs_genero=?, lfs_cpf=?, lfs_dataNascimento=?, lfs_senha=?, lfs_RG=?, lfs_Cep=?, lfs_email=?, lfs_telefone=?, lfs_forma_pagamento=?, lfs_dataUltimoLogin=?, lfs_preferencias=?, lfs_observacoes=?, lfs_dataCadastro=? where idlfs_Cliente=?");

            pst.setString(1, cliente.getLfs_Nome_completo());
            pst.setString(2, cliente.getLfs_genero());
            pst.setString(3, cliente.getLfs_cpf());
            java.sql.Date dataNas = new java.sql.Date(cliente.getLfs_dataNascimento().getTime());
            pst.setDate(4, dataNas);
            pst.setString(5, cliente.getLfs_senha());
            pst.setString(6, cliente.getLfs_RG());
            pst.setString(7, cliente.getLfs_Cep());
            pst.setString(8, cliente.getLfs_email());
            pst.setString(9, cliente.getLfs_telefone());
            pst.setString(10, cliente.getLfs_forma_pagamento());
            java.sql.Date dataUltimoLogin = new java.sql.Date(cliente.getLfs_dataUltimoLogin().getTime());
            pst.setDate(11, dataUltimoLogin);
            pst.setString(12, cliente.getLfs_preferencias());
            pst.setString(13, cliente.getLfs_observacoes());
            java.sql.Date dataCadastro = new java.sql.Date(cliente.getLfs_dataCadastro().getTime());
            pst.setDate(14, dataCadastro);
            pst.setInt(15, cliente.getIdlfs_Cliente());

            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Lfs_clienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Object object) {
        Lfs_cliente cliente = (Lfs_cliente) object;

        try {
            PreparedStatement pst = cnt.prepareStatement("delete from lfs_cliente where idlfs_Cliente=?");
            pst.setInt(1, cliente.getIdlfs_Cliente());

            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Lfs_clienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object list(int id) {
        try {
            PreparedStatement pst = cnt.prepareStatement("select * from lfs_cliente where idlfs_Cliente=?");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                Lfs_cliente cliente = new Lfs_cliente();

                cliente.setIdlfs_Cliente(rs.getInt("idlfs_Cliente"));
                cliente.setLfs_Nome_completo(rs.getString("lfs_Nome_completo"));
                cliente.setLfs_genero(rs.getString("lfs_genero"));
                cliente.setLfs_cpf(rs.getString("lfs_cpf"));
                cliente.setLfs_dataNascimento(rs.getDate("lfs_dataNascimento"));
                cliente.setLfs_senha(rs.getString("lfs_senha"));
                cliente.setLfs_RG(rs.getString("lfs_RG"));
                cliente.setLfs_Cep(rs.getString("lfs_Cep"));
                cliente.setLfs_email(rs.getString("lfs_email"));
                cliente.setLfs_telefone(rs.getString("lfs_telefone"));
                cliente.setLfs_forma_pagamento(rs.getString("lfs_forma_pagamento"));
                cliente.setLfs_dataUltimoLogin(rs.getDate("lfs_dataUltimoLogin"));
                cliente.setLfs_preferencias(rs.getString("lfs_preferencias"));
                cliente.setLfs_observacoes(rs.getString("lfs_observacoes"));
                cliente.setLfs_dataCadastro(rs.getDate("lfs_dataCadastro"));
                System.out.println("cadastro: "+cliente.getLfs_dataCadastro());
                System.out.println("nascimento: "+cliente.getLfs_dataNascimento());
                System.out.println("login: "+cliente.getLfs_dataUltimoLogin());
                return cliente;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Lfs_clienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Object listaAll() {
        List lista;

        try {
            PreparedStatement pst = cnt.prepareStatement("SELECT * FROM lfs_cliente");
            lista = new ArrayList();
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Lfs_cliente cliente = new Lfs_cliente();
                cliente.setIdlfs_Cliente(rs.getInt("idlfs_Cliente"));
                cliente.setLfs_Nome_completo(rs.getString("lfs_Nome_completo"));
                cliente.setLfs_genero(rs.getString("lfs_genero"));
                cliente.setLfs_cpf(rs.getString("lfs_cpf"));
                cliente.setLfs_dataNascimento(rs.getDate("lfs_dataNascimento"));
                cliente.setLfs_senha(rs.getString("lfs_senha"));
                cliente.setLfs_RG(rs.getString("lfs_RG"));
                cliente.setLfs_Cep(rs.getString("lfs_Cep"));
                cliente.setLfs_email(rs.getString("lfs_email"));
                cliente.setLfs_telefone(rs.getString("lfs_telefone"));
                cliente.setLfs_forma_pagamento(rs.getString("lfs_forma_pagamento"));
                cliente.setLfs_dataUltimoLogin(rs.getDate("lfs_dataUltimoLogin"));
                cliente.setLfs_preferencias(rs.getString("lfs_preferencias"));
                cliente.setLfs_observacoes(rs.getString("lfs_observacoes"));
                cliente.setLfs_dataCadastro(rs.getDate("lfs_dataCadastro"));

                lista.add(cliente);
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(Lfs_clienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void main(String[] args) {
        Lfs_clienteDao clienteDao = new Lfs_clienteDao();
        Lfs_cliente cliente = new Lfs_cliente();

        cliente.setIdlfs_Cliente(1);
        cliente.setLfs_Nome_completo("João da Silva");
        cliente.setLfs_genero("Masculino");
        cliente.setLfs_cpf("12345678900");
        cliente.setLfs_senha("senha123");
        cliente.setLfs_RG("123456789");
        cliente.setLfs_Cep("12345678");
        cliente.setLfs_email("joao@email.com");
        cliente.setLfs_telefone("(11) 98765-4321");
        cliente.setLfs_forma_pagamento("Cartão de Crédito");
        cliente.setLfs_preferencias("Produtos eletrônicos");
        cliente.setLfs_observacoes("Cliente preferencial");

        clienteDao.insert(cliente);
    }

}
