package com.acme.question_1.dao;

import com.acme.question_1.Opcao;
import com.acme.question_1.modelo.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProdutoDAO {
    
    private Connection con;
    
    public ProdutoDAO(Connection con) {
        this.con=con;
    }
    public void inserir(Produto produto, Opcao opcao) throws SQLException {
        String sql = "INSERT INTO PRODUTOS (ID, NOME, DESCRICAO, QUANTIDADE, PRECO) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = this.con.prepareStatement(sql)) {
            stmt.setInt(1, produto.getId());
            stmt.setString(2, produto.getNome());
            stmt.setString(3, produto.getDescricao());
            stmt.setInt(4, produto.getQuantidade());
            stmt.setDouble(5, produto.getPreco());
            opcao.setRows(stmt.executeUpdate());
        } catch (SQLException ex) {
            con.rollback();
        } 
    }
    
    public void alterar(Produto produto, Opcao opcao) throws SQLException {
        String sql = "UPDATE PRODUTOS SET NOME=?, DESCRICAO=?, QUANTIDADE=?, PRECO=? WHERE ID=?";
        
        try (PreparedStatement stmt = this.con.prepareStatement(sql)) {
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getDescricao());
            stmt.setInt(3, produto.getQuantidade());
            stmt.setDouble(4, produto.getPreco());
            stmt.setInt(5, produto.getId());
            opcao.setRows(stmt.executeUpdate());
        } catch (SQLException ex) {;
            System.out.println("Erro: " + ex.getMessage());
        }
    }
    
    public void remover(Produto produto, Opcao opcao) throws SQLException {
        String sql = "DELETE FROM PRODUTOS WHERE ID=?";
        
        try (PreparedStatement stmt = this.con.prepareStatement(sql)) {
            stmt.setInt(1, produto.getId());
            opcao.setRows(stmt.executeUpdate());
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
    }
    
    public void removerTudo() throws SQLException {
        String sql = "DELETE FROM PRODUTOS";
        
        try (PreparedStatement stmt = this.con.prepareStatement(sql)) {
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
    }
}
