/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bean.Lfs_jogos;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;
import java.sql.PreparedStatement;


/**
 *
 * @author u10918857104
 */
public class Lfs_jogosDao extends DaoAbstract {

    public Lfs_jogosDao() {

    }

    @Override
public void insert(Object object) {
    Lfs_jogos jogo = (Lfs_jogos) object;

    try {

        PreparedStatement pst = cnt.prepareStatement(
                "insert into lfs_jogos values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

        pst.setInt(1, jogo.getLfs_id_jogo());
        pst.setString(2, jogo.getLfs_nome_jogo());
        pst.setString(3, jogo.getLfs_classificacao_indicativa());
        pst.setString(4, jogo.getLfs_genero());
        pst.setDouble(5, jogo.getLfs_preco());
        pst.setString(6, jogo.getLfs_descricao());
         pst.setDate(7, null); // data lançamento
        pst.setString(8, jogo.getLfs_idioma());
        pst.setDate(9, null); // data adicionado
        pst.setString(10, jogo.getLfs_desenvolvedora());
        pst.setString(11, jogo.getLfs_avaliacao_media());
        pst.setString(12, jogo.getLfs_modo_de_jogo());
        pst.setString(13, jogo.getLfs_plataforma());
        pst.setString(14, jogo.getLfs_status_disponibilidade());

        pst.executeUpdate();

    } catch (SQLException ex) {
        Logger.getLogger(Lfs_jogosDao.class.getName()).log(Level.SEVERE, null, ex);
    }
}
}

@Override
public void insert(Object object) {

    Lfs_jogos jogo = (Lfs_jogos) object;

    try {

        PreparedStatement pst = cnt.prepareStatement(
                "insert into lfs_jogos values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

        pst.setInt(1, 1);
        pst.setString(2, "GTA V");
        pst.setString(3, "18");
        pst.setString(4, "Acao");
        pst.setDouble(5, 199.99);
        pst.setString(6, "Jogo de mundo aberto");

        pst.setDate(7, null); // data lançamento

        pst.setString(8, "Portugues");

        pst.setDate(9, null); // data adicionado

        pst.setString(10, "Rockstar");
        pst.setString(11, "10");
        pst.setString(12, "Online");
        pst.setString(13, "PC");
        pst.setString(14, "Disponivel");

        pst.executeUpdate();

        ResultSet rs = pst.executeQuery();

        while (rs.next() == true) {

            System.out.println("codigo:" + rs.getInt("lfs_id_jogo"));
            System.out.println("nome:" + rs.getString("lfs_nome_jogo"));

        }

    } catch (SQLException ex) {

        Logger.getLogger(Lfs_jogosDao.class.getName()).log(Level.SEVERE, null, ex);

    }
}

