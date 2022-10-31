package com.acme.question_1;

import com.acme.question_1.dao.ProdutoDAO;
import com.acme.question_1.modelo.Produto;
import java.sql.Connection;
import java.sql.SQLException;

public class Opcao {
    
    private boolean b=true;
    private int rows;
    
    Produto mouse = new Produto(1, "Mouse", "Mouse com fio", 9, 32.99);
    Produto teclado = new Produto(2, "Teclado", "Teclado Mecânico Gamer RGB - Switch Red", 1, 378.99);
    Produto monitor = new Produto(3, "Monitor", "Monitor Curvo 4k 144Hz", 5, 1989.99);
    
    Produto mouseGamer = new Produto(1, "Mouse Gamer", "Mouse Gamer RGB", 3, 159.99);
    
    public void printOption(Integer i, String opcao) {    
        if(i==0) {
            System.out.printf("Digite %d se quiser %s.\n", i, opcao);
        } else {
            System.out.printf("Digite %d se quiser %s produto(s) na base.\n", i, opcao);
        }
    }
    
    public String getOption(Byte numeroDaOpcao) throws SQLException {
        
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection con = connectionFactory.getConnection();
        ProdutoDAO produtoDAO = new ProdutoDAO(con);
        
        switch (numeroDaOpcao) {
            case 0: 
                produtoDAO.removerTudo();
                con.close();
                setBoolean(false);
                return "Finalizando programa...";
                
            case 1:
                try {
                    produtoDAO.inserir(mouse, this);
                    produtoDAO.inserir(teclado, this);
                    produtoDAO.inserir(monitor, this);
                } catch (SQLException ex) {
                    return "Produtos já inseridos!";
                }
                return "Produtos inseridos com sucesso!";

            case 2:
                produtoDAO.alterar(mouseGamer, this);
                if(this.rows==0) {
                    return "Produto ainda não foi inserido";
                } else {
                    return "Produto 1 alterado com sucesso!";
                }
            case 3:
                produtoDAO.remover(teclado, this);
                if(this.rows==0) {
                    return "Produto ainda não foi inserido";
                } else {
                    return "Produto 2 excluído com sucesso!";
                }
        }
        return "Por favor, escolha entre uma das opções.";
    }

    public boolean getBoolean() {
        return b;
    }
    
    public void setBoolean(boolean b) {
        this.b=b;
    }
    
    public int getRows() {
        return rows;
    }
    
    public void setRows(int rows) {
        this.rows=rows;
    }
}
