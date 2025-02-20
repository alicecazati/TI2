package com.example.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Produto;

public class DAOProduto extends DAO {

    public DAOProduto() {
        super();
        conectar();
    }

    public void finalize() {
        close();
    }

    public List<Produto> selectAll() {
        List<Produto> produtos = new ArrayList<>();
        try {
            Statement st = conexao.createStatement();
            String sql = "SELECT id, nome, preco, contato FROM produto";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Produto produto = new Produto(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getFloat("preco"),
                        rs.getString("contato"));
                produtos.add(produto);
            }
            rs.close();
            st.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
        return produtos;
    }

    public List<Produto> selectByName(String nome) {

        List<Produto> produtos = new ArrayList<>();
        try {
            String sql = "SELECT id, nome, preco, contato FROM produto WHERE nome ilike ?";
            PreparedStatement st = conexao.prepareStatement(sql);

            st.setString(1, '%' + nome + '%');

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Produto produto = new Produto(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getFloat("preco"),
                        rs.getString("contato"));
                produtos.add(produto);
            }
            rs.close();
            st.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
        return produtos;
    }

    public boolean insert(Produto produto) {
        boolean status = false;
        try {
            String sql = "INSERT INTO produto (nome, preco, contato) VALUES(?, ?, ?)";
            PreparedStatement st = conexao.prepareStatement(sql);

            st.setString(1, produto.getNome());
            st.setFloat(2, produto.getPreco());
            st.setString(3, produto.getContato());

            st.executeUpdate();
            st.close();
            status = true;
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
        return status;
    }

    public boolean update(Produto produto) {
        boolean status = false;
        try {
            String sql = "UPDATE produto SET nome = ?, preco = ?, contato = ? WHERE id = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);

            ps.setString(1, produto.getNome());
            ps.setFloat(2, produto.getPreco());
            ps.setString(3, produto.getContato());
            ps.setInt(4, produto.getId());

            int rowsUpdated = ps.executeUpdate();
            ps.close();
            status = (rowsUpdated > 0);
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
        return status;
    }
    public boolean delete(int id) {
        boolean status = false;
        try {
            String sql = "DELETE FROM produto WHERE id = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, id);

            int rowsDeleted = ps.executeUpdate();
            ps.close();
            status = (rowsDeleted > 0);
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
        return status;
    }
}
