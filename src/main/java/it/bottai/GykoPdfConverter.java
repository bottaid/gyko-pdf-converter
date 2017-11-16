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
                /*
                 Allora qui a mio parere potresti anche valutare l'utilizzo di uno switch, ma è una scelta estetica, le if vanno bene.
                 Ti faccio notare che ciascuna tua if esegue le stesse operazioni, cambia solamente il tipo di esercizio. Potresti
                 valutare di craeare una funzione in questa classe che prenda come argomento un esercizio generico e rimuovere così la
                 duplicazione di codice.
                 Altra nota, non stai commentando quello che ciascuna tua funzione fa, praticamente non stai creando la documentazione
                 necessaria a far capire ad altri sviluppatori cosa fa il tuo codice.
                 */
                if (elencoFile[i].startsWith("rom_") && elencoFile[i].endsWith(".pdf")){
                    EsercizioRom esercizio = new EsercizioRom();
                    ArrayList<String> righeTabella = esercizio.estraiRigheTabella(lettoreTabella.parsePdf());
                    righeTabella =  esercizio.parsaRigheTabella(righeTabella);
                    String newPath = dir+"\\"+elencoFile[i];
                    System.out.println(newPath);
                }
                if (elencoFile[i].startsWith("power_") && elencoFile[i].endsWith(".pdf")){
                    EsercizioPower esercizio = new EsercizioPower();
                    ArrayList<String> righeTabella = esercizio.estraiRigheTabella(lettoreTabella.parsePdf());
                    righeTabella =  esercizio.parsaRigheTabella(righeTabella);
                    String newPath = dir+"\\"+elencoFile[i];
                    System.out.println(newPath);
                }
                if (elencoFile[i].startsWith("sway_") && elencoFile[i].endsWith(".pdf")){
                    EsercizioSway esercizio = new EsercizioSway();
                    ArrayList<String> righeTabella = esercizio.estraiRigheTabella(lettoreTabella.parsePdf());
                    righeTabella =  esercizio.parsaRigheTabella(righeTabella);
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
