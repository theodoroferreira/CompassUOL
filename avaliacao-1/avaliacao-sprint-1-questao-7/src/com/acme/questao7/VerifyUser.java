package com.acme.questao7;

import java.util.Scanner;
import java.time.LocalTime;
import java.util.ArrayList;

public class VerifyUser {
    
    public static String getGreeting() {
        
        final int hour = LocalTime.now().getHour();
                
        if (hour < 6) {
            return "Boa madrugrada";
        }
            
        if (hour < 12) {
            return "Bom dia";
        }
            
        if (hour < 18) {
            return "Boa tarde";
        }
           
        return "Boa noite";                
    }
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        ArrayList<String> user = new ArrayList<String>();
        ArrayList<String> password = new ArrayList<String>();
        
        System.out.println("----------------------------");
        
        System.out.println("Bem vindo(a) ao sistema!");
        
        System.out.println("----------------------------");
        
        System.out.print("Crie um usuário: ");
        user.add(scan.nextLine().trim());
        
        System.out.print("Crie uma senha: ");
        password.add(scan.nextLine().trim());
        
        System.out.println("----------------------------");        
        
        System.out.print("Digite seu usuário: ");
        String verifyUser = scan.nextLine().trim();
        
        System.out.print("Digite sua senha: ");
        String verifyPassword = scan.nextLine().trim();
        
        if (verifyUser.equals(user.get(0)) && verifyPassword.equals(password.get(0))) {
            
            System.out.println("------------------------------------------");
            System.out.println(getGreeting() + ", você se logou ao nosso sistema.");
            System.out.println("------------------------------------------");
                    
        } else {
        
            System.out.println("------------------------------");
            System.out.println("Usuário e/ou senha incorretos.");
            System.out.println("------------------------------");
            
        }
    }
    
}