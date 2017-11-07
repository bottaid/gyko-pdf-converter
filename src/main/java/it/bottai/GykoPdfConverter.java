package it.bottai;

import it.bottai.util.LettoreTabellaEsercizio;

import java.io.IOException;

public class GykoPdfConverter {

    public static void main (String ...args){
        System.out.println("hello world");
        LettoreTabellaEsercizio lettoreTabella = new LettoreTabellaEsercizio();
        try {
            System.out.println(lettoreTabella.parsePdf());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
