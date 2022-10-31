package com.acme.question_1;

import java.sql.SQLException;
import java.util.Scanner;

public class Application {
    
    public static void main(String[] args) throws SQLException {
        
        Scanner scan = new Scanner(System.in);
        Opcao opcao = new Opcao();
        
        opcao.printOption(0, "finalizar o programa");
        opcao.printOption(1, "inserir");
        opcao.printOption(2, "atualizar");
        opcao.printOption(3, "deletar");
        
        while (opcao.getBoolean()) {
            System.out.println(opcao.getOption(scan.nextByte()));
        }
            
        scan.close();
    }
}
