package azienda;

import java.util.ArrayList;
import java.util.List;

public class Ruolo {
    private List<Corso> corsi;
    private List<Competenza> competenzeRuolo;
    private Unità unità = null;
    private Settore settore;
    private String nome;

    public List<Competenza> getCompetenze(){
        return competenzeRuolo;
    }

    public Ruolo(Settore c, String nome){
        settore = c;
        corsi = new ArrayList<>();
        this.nome = nome;
        this.competenzeRuolo = new ArrayList<>();
    }
    public List<Corso> getCorsi(){
        return corsi;
    }
    public void setCompetenzeRuolo(List <Competenza> competenzeRuolo){
        this.competenzeRuolo = competenzeRuolo;
    }

    public void addCompetenzeRuolo(Competenza c){
        competenzeRuolo.add(c);
    }

    public void setUnità(Unità unità){
        this.unità = unità;
        unità.setRuolo(this);
    }

    public Unità getUnità(){
        return unità;
    }

    public void addCorso(Corso c){
        corsi.add(c);
    }
    public String getNome(){
        return nome;
    }

}

