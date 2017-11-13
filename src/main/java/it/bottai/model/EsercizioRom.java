package it.bottai.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EsercizioRom implements Esercizio {


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
            System.out.println("Nuova riga Rom: " +newRiga);
        }
        System.out.println(righeTabella);
    }
}
