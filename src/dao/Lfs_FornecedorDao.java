package dao;

import bean.Lfs_cliente;
import java.sql.PreparedStatement; 
import java.sql.SQLException;      
import java.util.logging.Level;    
import java.util.logging.Logger;   

public class Lfs_FornecedorDao extends DaoAbstract {

    public Lfs_FornecedorDao() {
    }

    @Override
    public void insert(Object object) {
        Lfs_cliente cliente = (Lfs_cliente) object;
        String sql = "INSERT INTO lfs_cliente VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

       
        try (PreparedStatement pst = cnt.prepareStatement(sql)) {

            pst.setInt(1, cliente.getIdlfs_Cliente());
            pst.setString(2, cliente.getLfs_Nome_completo());
            pst.setInt(3, cliente.getLfs_genero());
            pst.setString(4, cliente.getLfs_cpf());

          
            pst.setDate(5, new java.sql.Date(cliente.getLfs_dataNascimento().getTime()));

            pst.setString(6, cliente.getLfs_RG());
            pst.setString(7, cliente.getLfs_Cep());
            pst.setString(8, cliente.getLfs_email());
            pst.setString(9, cliente.getLfs_telefone());
            pst.setInt(10, cliente.getLfs_forma_pagamento());
            pst.setString(11, cliente.getLfs_preferencias());
            pst.setString(12, cliente.getLfs_observacoes());
            
            pst.setDate(13, null);

            pst.setString(14, cliente.getLfs_bairro());
            pst.setString(15, cliente.getLfs_logradouro());

            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Lfs_FornecedorDao.class.getName())
                  .log(Level.SEVERE, "Erro ao inserir dados no banco", ex);
        }
    }
}

package dao;

import bean.Lfs_cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import testes.JdbcCrud;

public class Lfs_FornecedorDao extends DaoAbstract {

    public Lfs_FornecedorDao() {
    }

    @Override
    public void insert(Object object) {

        Lfs_cliente cliente = (Lfs_cliente) object;

        try {

            String sql = "insert into lfs_cliente values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement pst = cnt.prepareStatement(sql);

            pst.setInt(1, 100);
            pst.setString(2, "laura");
            pst.setInt(3, 1);
            pst.setString(4, "000.000.000-00");

            pst.setDate(5, null); // data nascimento

            pst.setString(6, "123456");
            pst.setString(7, "79990-000");
            pst.setString(8, "laura@gmail.com");
            pst.setString(9, "(67)99999-9999");

            pst.setInt(10, 1);

            pst.setString(11, "jogos");
            pst.setString(12, "cliente vip");

            pst.setDate(13, null); // data cadastro

            pst.setString(14, "Centro");
            pst.setString(15, "Rua A");

            pst.executeUpdate();

            ResultSet rs = pst.executeQuery();

            while (rs.next() == true) {

                System.out.println("codigo:" + rs.getInt("idlfs_Cliente"));
                System.out.println("nome:" + rs.getString("lfs_Nome_completo"));

            }

        } catch (SQLException ex) {

            Logger.getLogger(JdbcCrud.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    @Override
    public void update(Object objeto) {

    }

    @Override
    public void delete(Object objeto) {

    }

    @Override
    public Object list(int id) {
        return null;
    }

    @Override
    public Object listAll() {
        return null;
    }
}



