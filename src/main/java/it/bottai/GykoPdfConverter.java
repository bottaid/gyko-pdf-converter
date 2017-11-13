package it.bottai;

import it.bottai.model.EsercizioPower;
import it.bottai.model.EsercizioRom;
import it.bottai.model.EsercizioSway;
import it.bottai.util.LettoreTabellaEsercizio;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GykoPdfConverter {

    public static void main (String ...args){
        System.out.println("hello world");
        LettoreTabellaEsercizio lettoreTabella = new LettoreTabellaEsercizio();
        File dir = new File("./src/main/resources/pdfs");
        String elencoFile[] = dir.list();
        try {
            for (int i = 0; i < elencoFile.length; i++){
                if (elencoFile[i].startsWith("rom_") && elencoFile[i].endsWith(".pdf")){
                    EsercizioRom esercizio = new EsercizioRom();
                    ArrayList<String> righeTabella = esercizio.estraiRigheTabella(lettoreTabella.parsePdf());
                    esercizio.scriviRigheTabella(righeTabella);
                    String newPath = dir+"\\"+elencoFile[i];
                    System.out.println(newPath);
                }
                if (elencoFile[i].startsWith("power_") && elencoFile[i].endsWith(".pdf")){
                    EsercizioPower esercizio = new EsercizioPower();
                    ArrayList<String> righeTabella = esercizio.estraiRigheTabella(lettoreTabella.parsePdf());
                    esercizio.scriviRigheTabella(righeTabella);
                    String newPath = dir+"\\"+elencoFile[i];
                    System.out.println(newPath);
                }
                if (elencoFile[i].startsWith("sway_") && elencoFile[i].endsWith(".pdf")){
                    EsercizioSway esercizio = new EsercizioSway();
                    ArrayList<String> righeTabella = esercizio.estraiRigheTabella(lettoreTabella.parsePdf());
                    esercizio.scriviRigheTabella(righeTabella);
                    String newPath = dir+"\\"+elencoFile[i];
                    System.out.println(newPath);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(dir);
    }
}
