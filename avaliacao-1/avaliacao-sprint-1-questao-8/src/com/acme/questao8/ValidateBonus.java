package com.acme.questao8;

import java.util.Scanner;
import java.util.ArrayList;

public class ValidateBonus {
    
    public static void print(String employee, float wage, float bonus, float liquidWage) {
        
        System.out.println("- Funcionário " + employee);
        System.out.println("    - Salário: " + wage);
        System.out.println("    - Bônus: " + bonus);
        System.out.println("    - Salário Líquido " + liquidWage);
        
    }
    
    public static void main(String[] args) {    
        
        Scanner scan = new Scanner(System.in);
        ArrayList<String> employee = new ArrayList<String>();
        ArrayList<Float> wage = new ArrayList<Float>();
        ArrayList<Float> bonus = new ArrayList<Float>();
        ArrayList<Float> liquidWage = new ArrayList<Float>();
        
        System.out.print("Digite quantos funcionários serão cadastrados: ");
        int n = Integer.parseInt(scan.nextLine());
        
        for (int i=0; i<n; i++) {
            
            System.out.printf("Digite o nome do %dº funcionário: ", i+1);
            employee.add(scan.nextLine().trim());   
            System.out.printf("Digite o salário do funcionário %s: ", employee.get(i));
            wage.add(Float.parseFloat(scan.nextLine()));
            bonus.add(0f);
            liquidWage.add(0f);
            
            if (wage.get(i)<1000) {
                bonus.set(i, wage.get(i)*0.2f);
                liquidWage.set(i, wage.get(i)+bonus.get(i));
            }
            
            else if (wage.get(i)<2000) {
                bonus.set(i, wage.get(i)*0.1f);
                liquidWage.set(i, wage.get(i)+bonus.get(i));
            } 
            
            else {
                bonus.set(i, wage.get(i)*0.1f);
                liquidWage.set(i, wage.get(i)-bonus.get(i));
            }
            
        }

        for (int i=0; i<n; i++) {
            print(employee.get(i), wage.get(i), bonus.get(i), liquidWage.get(i));
        }
    } 
    
}
