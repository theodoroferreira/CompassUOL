package com.acme.question_3;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        Emote emote = new Emote();
        
        System.out.print("Digite sua mensagem: ");
        
        String input = scan.nextLine().trim().toLowerCase();
        
        System.out.println(emote.getEmote(input));
    }
    
}
