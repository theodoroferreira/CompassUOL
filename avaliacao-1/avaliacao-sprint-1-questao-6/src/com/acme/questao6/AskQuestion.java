package com.acme.questao6;

import java.util.Scanner;
import java.util.ArrayList;

public class AskQuestion {

    public static void main(String[] args) {
        
        int rightAnswers = 0;
        int wrongAnswers = 0;
        
        Scanner scan = new Scanner(System.in);
        ArrayList<String> question = new ArrayList<String>();
        ArrayList<String> answer = new ArrayList<String>();
        
        System.out.print("Digite seu nome: ");
        String user = scan.nextLine().trim();
        
        question.add("Qual é o país mais populoso do mundo? ");        
        question.add("Como se chama a capital da espanha? ");
        question.add("Qual é o resultado da expressão (5+4)/3? ");
        question.add("Como se chama o rio que banha o Egito? ");
        question.add("Qual é o animal mais rápido do mundo? ");
        
        answer.add("china");        
        answer.add("madrid");
        answer.add("3");
        answer.add("nilo");
        answer.add("guepardo");
        
        for (int i=0; i<5; i++) {
            System.out.print((i+1) + ". " + question.get(i) + " ");
            String userAnswer = scan.nextLine().trim().toLowerCase();
            
            if (!userAnswer.equals(answer.get(i))) {
                System.out.println("Resposta errada!");
                wrongAnswers++;
            } else {            
            System.out.println("Resposta certa!");
            rightAnswers++;
            }
        }
        
        System.out.println("");
        System.out.println("Usuário " + user + ": ");
        System.out.println("Acertos: " + rightAnswers);
        System.out.println("Erros: " + wrongAnswers);
        
    }
    
}
