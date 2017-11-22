package it.bottai;

import it.bottai.model.*;
import it.bottai.util.LettoreTabellaEsercizio;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GykoPdfConverter {

    public static void main (String ...args){
        LettoreTabellaEsercizio lettoreTabella = new LettoreTabellaEsercizio();
        File dir = new File("./src/main/resources/pdfs");
        String elencoFile[] = dir.list();
        try {
            //Analizzo ogni file all'interno della cartella
            for (int i = 0; i < elencoFile.length; i++){
                String filename = elencoFile[i];
                System.out.println("Controllo file da analizzare: " +filename);
                String outputDir = lettoreTabella.getOutputDirectory();
                if ((filename.startsWith("rom_") || filename.startsWith("power_") || filename.startsWith("sway_")) &&  filename.endsWith(".pdf")){
                    lettoreTabella.setFilename(filename);
                    EsercizioDefault esercizio = new EsercizioDefault();
                    ArrayList<String> righeTabella = esercizio.estraiRigheTabella(lettoreTabella.parsePdf());
                    righeTabella = esercizio.parsaRigheTabella(righeTabella);
                    esercizio.scriviRigheTabella(righeTabella, outputDir, filename);
                }
                else {
                    System.out.println(elencoFile[i] + " non convertibile.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
