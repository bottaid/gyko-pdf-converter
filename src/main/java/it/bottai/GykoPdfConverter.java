package it.bottai;

import it.bottai.model.EsercizioRom;
import it.bottai.model.EsercizioSway;
import it.bottai.util.LettoreTabellaEsercizio;

import java.io.IOException;
import java.util.ArrayList;

public class GykoPdfConverter {

    public static void main (String ...args){
        System.out.println("hello world");
        LettoreTabellaEsercizio lettoreTabella = new LettoreTabellaEsercizio();
        try {
            EsercizioRom esercizio = new EsercizioRom();
            ArrayList<String> righeTabella = esercizio.estraiRigheTabella(lettoreTabella.parsePdf());
            esercizio.scriviRigheTabella(righeTabella);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
