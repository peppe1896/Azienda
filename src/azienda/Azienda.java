package azienda;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Azienda {
    private List<Ruolo> ruoli;
    private HashSet<Unità> unità;
    private String nome;


    public Azienda(){
        ruoli = new ArrayList<>();
        unità = new HashSet<>();
    }

    public Azienda(String nome){
        this();
        this.nome = nome;
    }

    public List<Ruolo> getRuoli(){
        return ruoli;
    }

    public void addRuolo(Ruolo r){
        ruoli.add(r);
    }

    public void addUnità(Unità u){
        unità.add(u);
    }

    public String getNome(){
        return nome;
    }
    public HashSet<Unità> getUnità(){
        return unità;
    }
}
