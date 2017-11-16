package it.bottai.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EsercizioPower implements Esercizio {


    public ArrayList<String> parsaRigheTabella(ArrayList<String> righeTabella) {

        //Stesso discorso che ti ho scritto su sull'esercizio Sway, qua alla fine abbiamo duplicazione di codice con la classe Rom
        return null;
    }

    public ArrayList<String> estraiRigheTabella(ArrayList<String> lista) {
        ArrayList<String> righeTabella = new ArrayList<String>();

        for (String riga : lista){
            String primoElemento = riga.substring(0,1);
            if (riga.startsWith("1 ")){
                righeTabella.add(riga);
            }
        }
        System.out.println(righeTabella);
        return righeTabella;
    }

    public void scriviRigheTabella(ArrayList<String> righeTabella) {
        for (String riga : righeTabella){
            String newRiga = riga.replace(" ", ";");
            newRiga = newRiga + ";";
            System.out.println(newRiga);
        }
        System.out.println(righeTabella);
    }
}