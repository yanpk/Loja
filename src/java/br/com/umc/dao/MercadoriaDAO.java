package br.com.umc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import br.com.umc.model.Mercadoria;
import br.com.umc.util.DbUtil;

public class MercadoriaDAO {

    private Connection connection;

    public MercadoriaDAO() {
        connection = DbUtil.getConnection();
    }

    public void addMercadoria(Mercadoria mercadoria) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into mercadorias(tipo,nome,quantidade,preco,tiponegocio) values (?, ?, ?, ? ,?)");
            
            preparedStatement.setString(1, mercadoria.getTipo());
            preparedStatement.setString(2, mercadoria.getNome());
            preparedStatement.setInt(3, mercadoria.getQuantidade());
            preparedStatement.setDouble(4, mercadoria.getPreco());
            preparedStatement.setString(5, mercadoria.getTiponegocio());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletaMercadoria(int id) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from mercadorias where id=?");
            
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
        }
    }

    public void atualizaMercadoria(Mercadoria mercadoria) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update mercadorias set tipo=?, nome=?, quantidade=?, preco=?, tiponegocio=?" +
                            "where id=?");
            
            preparedStatement.setString(1, mercadoria.getTipo());
            preparedStatement.setString(2, mercadoria.getNome());
            preparedStatement.setInt(3, mercadoria.getQuantidade());
            preparedStatement.setDouble(4, mercadoria.getPreco());
            preparedStatement.setString(5, mercadoria.getTiponegocio());
            preparedStatement.setInt(6, mercadoria.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
        }
    }

    public List<Mercadoria> getTodasMercadorias() {
        List<Mercadoria> mercadorias = new ArrayList<Mercadoria>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM mercadorias");
            while (rs.next()) {
                Mercadoria mercadoria = new Mercadoria();
                
                mercadoria.setId(rs.getInt("id"));
                mercadoria.setTipo(rs.getString("tipo"));
                mercadoria.setNome(rs.getString("nome"));
                mercadoria.setQuantidade(rs.getInt("quantidade"));
                mercadoria.setPreco(rs.getDouble("preco"));
                mercadoria.setTiponegocio(rs.getString("tiponegocio"));
                mercadorias.add(mercadoria);
            }
        } catch (SQLException e) {
        }

        return mercadorias;
    }

    public Mercadoria getMercadoriabyId(int id) {
        Mercadoria mercadoria = new Mercadoria();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from mercadorias where id=?");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                mercadoria.setId(rs.getInt("id"));
                mercadoria.setTipo(rs.getString("tipo"));
                mercadoria.setNome(rs.getString("nome"));
                mercadoria.setQuantidade(rs.getInt("quantidade"));
                mercadoria.setPreco(rs.getDouble("preco"));
                mercadoria.setTiponegocio(rs.getString("tiponegocio"));
            }
        } catch (SQLException e) {
        }

        return mercadoria;
    }
}