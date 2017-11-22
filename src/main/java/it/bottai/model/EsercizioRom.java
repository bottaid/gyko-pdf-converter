package it.bottai.model;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EsercizioRom  {

    public ArrayList<String> estraiRigheTabella(ArrayList<String> lista) {
        ArrayList<String> righeTabella = new ArrayList<String>();

        for (String riga : lista){
            String primoElemento = riga.substring(0,1);
            if (riga.startsWith("1 ") || riga.startsWith("# ")){
                righeTabella.add(riga);
            }
        }
        System.out.println(righeTabella);
        return righeTabella;
    }

    public void scriviRigheTabella(ArrayList<String> righeTabella) throws IOException {
        //qua scriverai solo su csv
        //stringa del filename da aggiornare a runtime
        FileWriter f = new FileWriter("./src/main/resources/pdfs/rom_nomefile.csv");
        BufferedWriter scriviTabella = new BufferedWriter(f);
        for (String riga : righeTabella){
            scriviTabella.write(riga);
        }
        scriviTabella.flush();
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
