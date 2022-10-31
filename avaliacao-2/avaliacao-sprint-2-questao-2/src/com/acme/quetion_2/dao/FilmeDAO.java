package com.acme.quetion_2.dao;

import com.acme.quetion_2.modelo.Filme;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FilmeDAO {
    private Connection con;
    
    public FilmeDAO(Connection con) {
        this.con=con;
    }
    
    public ArrayList<Filme> listar() throws SQLException {
        
        String sql = "SELECT ID, NOME, DESCRICAO, ANO FROM FILMES";
        ArrayList<Filme> filmes = new ArrayList<Filme>();
        
        try (PreparedStatement stmt = this.con.prepareStatement(sql)) {
            stmt.execute();
            
            try (ResultSet rst = stmt.getResultSet()) {
                while (rst.next()) {
                    Filme filme = new Filme(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getInt(4));
                    
                    filmes.add(filme);
                }
            }
        }    
        return filmes;
    }
}
