package com.acme.quetion_2;

import com.acme.quetion_2.dao.FilmeDAO;
import com.acme.quetion_2.modelo.Filme;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

    public static List<Filme> listarFilmes(ArrayList<Filme> filmes, int paginaRequisitada, int limiteDeFilmes) {    
    
        List<Filme> listaDeFilmesFiltrada = new ArrayList<Filme>();
        int totalDePaginas =(int) Math.ceil(filmes.size()/limiteDeFilmes);
        int contador = (paginaRequisitada*limiteDeFilmes)-limiteDeFilmes;
        int limitador = contador + limiteDeFilmes;
        
        if(paginaRequisitada <= totalDePaginas) {
            
            for(int i=contador; i<limitador; i++) {
                if(filmes.get(i)!=null) {
                    listaDeFilmesFiltrada.add(filmes.get(i));
                }
                contador++;
            }
        }
        return listaDeFilmesFiltrada;
    }    
    
    public static void main(String[] args) throws SQLException {
        
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Digite quantos filmes você deseja filtrar: ");
        int limiteDeFilmes = Integer.parseInt(scan.nextLine());
        System.out.print("Digite que página você deseja acessar: ");
        int paginaRequisitada = Integer.parseInt(scan.nextLine());
        
        try (Connection con = new ConnectionFactory().getConnection()) {
            FilmeDAO filmeDAO = new FilmeDAO(con);
            List<Filme> lista = listarFilmes(filmeDAO.listar(), paginaRequisitada, limiteDeFilmes);
            for (Filme filme : lista) {
                System.out.println(filme+"\n"); 
            }
        }
    }
    
}
