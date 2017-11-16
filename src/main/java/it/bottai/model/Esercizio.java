package it.bottai.model;

import java.util.ArrayList;

public interface Esercizio {
    public ArrayList<String> estraiRigheTabella(ArrayList<String> lista);
    public ArrayList<String> parsaRigheTabella(ArrayList<String> righeTabella);
    public void scriviRigheTabella(ArrayList<String> righeTabella);
}
