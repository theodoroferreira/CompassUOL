package com.acme.question_3;

public class Emote {
    
    private int contEmoteFeliz;
    private int contEmoteTriste;
    
    public String getEmote(String s) {
        
        String subtractString = s.replaceAll("[^-)(:]", "");
        String parsedString = subtractString.replaceAll("(?<!:-)[()]", "");
        String casoFeliz = parsedString.replaceAll("[^)]", "");
        String casoTriste = parsedString.replaceAll("[^(]", "");
        
        this.contEmoteFeliz=casoFeliz.length();
        this.contEmoteTriste=casoTriste.length();
        
        if (contEmoteFeliz > contEmoteTriste) {
            return "divertido";
        } else if (contEmoteFeliz < contEmoteTriste) {
            return "chateado";
        } else {
            return "neutro";
        }
    }
}
