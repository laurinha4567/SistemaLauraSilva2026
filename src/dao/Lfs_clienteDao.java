package dao;

import bean.Lfs_cliente;
import java.sql.PreparedStatement; 
import java.sql.SQLException;      
import java.util.logging.Level;    
import java.util.logging.Logger;   

public class Lfs_clienteDao extends DaoAbstract {

    public Lfs_clienteDao() {
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

          
            pst.setDate(5, null); //igual o da sala

            pst.setString(6, cliente.getLfs_RG());
            pst.setString(7, cliente.getLfs_Cep());
            pst.setString(8, cliente.getLfs_email());
            pst.setString(9, cliente.getLfs_telefone());
            pst.setInt(10, cliente.getLfs_forma_pagamento());
            pst.setString(11, cliente.getLfs_preferencias());
            pst.setString(12, cliente.getLfs_observacoes());
            
            pst.setDate(13, null); // igual o da sala

            pst.setString(14, cliente.getLfs_bairro());
            pst.setString(15, cliente.getLfs_logradouro());

            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Lfs_clienteDao.class.getName())
                  .log(Level.SEVERE, "Erro ao inserir dados no banco", ex);
        }
    }
}

