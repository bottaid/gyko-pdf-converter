package it.bottai.model;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Classe che contiene metodi che estraggono dalla tabella le righe,
//le memorizzano in un ArrayList e poi scrivono su csv
public class EsercizioDefault implements Esercizio {

    //Estraggo le righe dalla tabella
    public ArrayList<String> estraiRigheTabella(ArrayList<String> lista) {
        ArrayList<String> righeTabella = new ArrayList<String>();
        Integer contatoreRighe = 0;
        //Rivedere questo ciclo nel caso di PDF con piu misurazioni
        for (String riga : lista){
            String primoElemento = riga.split(" ")[0];
            int numeroRiga = estraiNumeroRiga(primoElemento);
            if (riga.startsWith("# ")){
                righeTabella.add(riga);
            }
            else if ((controllaIntero(primoElemento)&& numeroRiga == contatoreRighe+1)){
                righeTabella.add(riga);
                contatoreRighe++;
            }
        }
        System.out.println(righeTabella);
        return righeTabella;
    }

    public boolean controllaIntero(String primoElemento){
        if(primoElemento == null || primoElemento.trim().isEmpty())
            return false;
        try{
            Integer.parseInt(primoElemento);
        }catch (NumberFormatException e){
            return false;
        }
        System.out.println("Primo elemento: " + primoElemento);
        return true;
    }

    public int estraiNumeroRiga(String primoElemento){
        int risultato = 0;
        try{
            risultato = Integer.parseInt(primoElemento);
        }catch (NumberFormatException e){

        }
        return risultato;

    }

    //Scrivo le righe estratte sul csv
    public void scriviRigheTabella(ArrayList<String> righeTabella, String outputDir, String filename) throws IOException {
        //qua scriverai solo su csv
        //stringa del filename da aggiornare a runtime
        StringBuilder finalPath = new StringBuilder(outputDir + filename.split(".pdf")[0]);
        finalPath.append(".csv");
        FileWriter f = new FileWriter(finalPath.toString());
        BufferedWriter scriviTabella = new BufferedWriter(f);
        for (String riga : righeTabella){
            scriviTabella.write(riga+"\n");
        }
        scriviTabella.flush();
    }

    //Memorizzo le righe in un ArrayList nella forma dei documenti di tipo csv
    public ArrayList<String> parsaRigheTabella(ArrayList<String> righeTabella) {
        StringBuilder nuovaRiga;
        ArrayList<String> righeTabellaParsate = new ArrayList<String>();
        for (String riga : righeTabella){
            if(!riga.startsWith("# ")) {
                nuovaRiga = new StringBuilder(riga.replace(" ", ";"));
                nuovaRiga.append(";");
                righeTabellaParsate.add(nuovaRiga.toString());
            }else {
                righeTabellaParsate.add(riga);
            }

        }
        System.out.println("New Table: " + righeTabellaParsate);
        return righeTabellaParsate;
    }

}

