package dao;

import bean.Lfs_Fornecedor;
import java.sql.PreparedStatement; 
import java.sql.SQLException;      
import java.util.logging.Level;    
import java.util.logging.Logger;   

public class Lfs_FornecedorDao extends DaoAbstract {


    public void insert(Object object) {

    Lfs_Fornecedor fornecedor = (Lfs_Fornecedor) object;

    String sql = "INSERT INTO lfs_fornecedor VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    try (PreparedStatement pst = cnt.prepareStatement(sql)) {

        pst.setInt(1, fornecedor.getLfs_jdFornecedor());

        pst.setString(2, fornecedor.getLfs_razao_social());

        pst.setString(3, fornecedor.getLfs_cnpj());

        pst.setString(4, fornecedor.getLfs_inscricao_estadual());

        pst.setString(5, fornecedor.getLfs_email());

        pst.setString(6, fornecedor.getLfs_telefone());

        pst.setString(7, fornecedor.getLfs_celular());

        pst.setString(8, fornecedor.getLfs_endereco());

        pst.setString(9, fornecedor.getLfs_bairro());

        pst.setString(10, fornecedor.getLfs_cidade());

        pst.setString(11, fornecedor.getLfs_estado());

        pst.setString(12, fornecedor.getLfs_cep());

        pst.setDate(13, null); // data cadastro

        pst.setString(14, fornecedor.getLfs_logradouro());

        pst.setString(15, fornecedor.getLfs_numero());

        pst.executeUpdate();

    } catch (SQLException ex) {

        Logger.getLogger(Lfs_FornecedorDao.class.getName())
                .log(Level.SEVERE, "Erro ao inserir dados no banco", ex);

    }

}

}


