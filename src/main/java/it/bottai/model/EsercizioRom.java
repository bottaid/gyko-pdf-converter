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
        //qua scriverai solo su csv
    }

    public ArrayList<String> parsaRigheTabella(ArrayList<String> righeTabella) {
        StringBuilder nuovaRiga;
        ArrayList<String> righeTabellaParsate = new ArrayList<String>();
        for (String riga : righeTabella){
            nuovaRiga = new StringBuilder( riga.replace(" ", ";"));
            nuovaRiga.append(";");
            righeTabellaParsate.add(nuovaRiga.toString());
        }
        System.out.println("New Table: " + righeTabellaParsate);
        return righeTabellaParsate;
    }
}
