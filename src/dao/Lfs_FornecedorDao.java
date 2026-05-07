package dao;

import bean.Lfs_cliente;
import java.sql.PreparedStatement; 
import java.sql.SQLException;      
import java.util.logging.Level;    
import java.util.logging.Logger;   

public class Lfs_FornecedorDao extends DaoAbstract {


    public void insert(Object object) {

    Lfs_fornecedor fornecedor = (Lfs_fornecedor) object;

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



