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
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
            PreparedStatement pst = cnt.prepareStatement("insert into lfs_jogos values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, jogo.getLfs_id_jogo());
            pst.setString(2, jogo.getLfs_nome_jogo());
            pst.setString(3, jogo.getLfs_classificacao_indicativa());
            pst.setString(4, jogo.getLfs_genero());
            pst.setDouble(5, jogo.getLfs_preco());
            pst.setString(6, jogo.getLfs_descricao());
            java.sql.Date data_lancamento = new java.sql.Date(jogo.getLfs_data_lancamento().getTime());
            pst.setDate(7, data_lancamento);
            pst.setInt(8, jogo.getLfs_estoque());
            pst.setString(9, jogo.getLfs_idioma());
            java.sql.Date data_adicionado = new java.sql.Date(jogo.getLfs_data_adicionado().getTime());
            pst.setDate(10, data_adicionado);
            pst.setString(11, jogo.getLfs_desenvolvedora());
            pst.setDouble(12, jogo.getLfs_avaliacao_media());
            pst.setString(13, jogo.getLfs_modo_de_jogo());
            pst.setString(14, jogo.getLfs_plataforma());
            pst.setString(15, jogo.getLfs_status_disponibilidade());

            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Lfs_jogosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Object object) {
        Lfs_jogos jogo = (Lfs_jogos) object;

        try {
            PreparedStatement pst = cnt.prepareStatement("update lfs_jogos set lfs_nome_jogo=?, lfs_classificacao_indicativa=?, lfs_genero=?, lfs_preco=?, lfs_descricao=?, lfs_data_lancamento=?, lfs_estoque=?, lfs_idioma=?, lfs_data_adicionado=?, lfs_desenvolvedora=?, lfs_avaliacao_media=?, lfs_modo_de_jogo=?, lfs_plataforma=?, lfs_status_disponibilidade=? where lfs_id_jogo=?");

            pst.setString(1, jogo.getLfs_nome_jogo());
            pst.setString(2, jogo.getLfs_classificacao_indicativa());
            pst.setString(3, jogo.getLfs_genero());
            pst.setDouble(4, jogo.getLfs_preco());
            pst.setString(5, jogo.getLfs_descricao());
            java.sql.Date data_lancamento = new java.sql.Date(jogo.getLfs_data_lancamento().getTime());
            pst.setDate(6, data_lancamento);
            pst.setInt(7, jogo.getLfs_estoque());
            pst.setString(8, jogo.getLfs_idioma());
            java.sql.Date data_adicionado = new java.sql.Date(jogo.getLfs_data_adicionado().getTime());
            pst.setDate(9, data_adicionado);
            pst.setString(10, jogo.getLfs_desenvolvedora());
            pst.setDouble(11, jogo.getLfs_avaliacao_media());
            pst.setString(12, jogo.getLfs_modo_de_jogo());
            pst.setString(13, jogo.getLfs_plataforma());
            pst.setString(14, jogo.getLfs_status_disponibilidade());
            pst.setInt(15, jogo.getLfs_id_jogo());

            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Lfs_jogosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Object object) {
        Lfs_jogos jogo = (Lfs_jogos) object;

        try {
            PreparedStatement pst = cnt.prepareStatement("delete from lfs_jogos where lfs_id_jogo=?");
            pst.setInt(1, jogo.getLfs_id_jogo());

            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Lfs_jogosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object list(int id) {
        try {
            PreparedStatement pst = cnt.prepareStatement("select * from lfs_jogos where lfs_id_jogo=?");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                Lfs_jogos jogo = new Lfs_jogos();

                jogo.setLfs_id_jogo(rs.getInt("lfs_id_jogo"));
                jogo.setLfs_nome_jogo(rs.getString("lfs_nome_jogo"));
                jogo.setLfs_classificacao_indicativa(rs.getString("lfs_classificacao_indicativa"));
                jogo.setLfs_genero(rs.getString("lfs_genero"));
                jogo.setLfs_preco(rs.getDouble("lfs_preco"));
                jogo.setLfs_descricao(rs.getString("lfs_descricao"));
                jogo.setLfs_data_lancamento(rs.getDate("lfs_data_lancamento"));
                jogo.setLfs_estoque(rs.getInt("lfs_estoque"));
                jogo.setLfs_idioma(rs.getString("lfs_idioma"));
                jogo.setLfs_data_adicionado(rs.getDate("lfs_data_adicionado"));
                jogo.setLfs_desenvolvedora(rs.getString("lfs_desenvolvedora"));
                jogo.setLfs_avaliacao_media(rs.getDouble("lfs_avaliacao_media"));
                jogo.setLfs_modo_de_jogo(rs.getString("lfs_modo_de_jogo"));
                jogo.setLfs_plataforma(rs.getString("lfs_plataforma"));
                jogo.setLfs_status_disponibilidade(rs.getString("lfs_status_disponibilidade"));

                return jogo;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Lfs_jogosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Object listaAll() {
        List lista;

        try {
            PreparedStatement pst = cnt.prepareStatement("SELECT * FROM lfs_jogos");
            lista = new ArrayList();
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Lfs_jogos jogo = new Lfs_jogos();
                jogo.setLfs_id_jogo(rs.getInt("lfs_id_jogo"));
                jogo.setLfs_nome_jogo(rs.getString("lfs_nome_jogo"));
                jogo.setLfs_classificacao_indicativa(rs.getString("lfs_classificacao_indicativa"));
                jogo.setLfs_genero(rs.getString("lfs_genero"));
                jogo.setLfs_preco(rs.getDouble("lfs_preco"));
                jogo.setLfs_descricao(rs.getString("lfs_descricao"));
                jogo.setLfs_data_lancamento(rs.getDate("lfs_data_lancamento"));
                jogo.setLfs_estoque(rs.getInt("lfs_estoque"));
                jogo.setLfs_idioma(rs.getString("lfs_idioma"));
                jogo.setLfs_data_adicionado(rs.getDate("lfs_data_adicionado"));
                jogo.setLfs_desenvolvedora(rs.getString("lfs_desenvolvedora"));
                jogo.setLfs_avaliacao_media(rs.getDouble("lfs_avaliacao_media"));
                jogo.setLfs_modo_de_jogo(rs.getString("lfs_modo_de_jogo"));
                jogo.setLfs_plataforma(rs.getString("lfs_plataforma"));
                jogo.setLfs_status_disponibilidade(rs.getString("lfs_status_disponibilidade"));

                lista.add(jogo);
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(Lfs_jogosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void main(String[] args) {
        Lfs_jogosDao jogosDao = new Lfs_jogosDao();
        Lfs_jogos jogo = new Lfs_jogos();

        jogo.setLfs_id_jogo(1);
        jogo.setLfs_nome_jogo("The Legend of Zelda: Breath of the Wild");
        jogo.setLfs_classificacao_indicativa("12");
        jogo.setLfs_genero("Aventura");
        jogo.setLfs_preco(299.90);
        jogo.setLfs_descricao("Jogo de aventura em mundo aberto");
        jogo.setLfs_estoque(50);
        jogo.setLfs_idioma("Português");
        jogo.setLfs_desenvolvedora("Nintendo");
        jogo.setLfs_avaliacao_media(9.7);
        jogo.setLfs_modo_de_jogo("Single-player");
        jogo.setLfs_plataforma("Nintendo Switch");
        jogo.setLfs_status_disponibilidade("Disponível");

        jogosDao.insert(jogo);
    }
}
