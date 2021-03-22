package azienda;

import java.util.ArrayList;
import java.util.List;

public class Unità {
    private List<Competenza> competenze;
    private String nome;
    private Azienda azienda;
    private Ruolo ruolo;

    public Unità(String nome, Azienda azienda){
        this.nome = nome;
        this.azienda = azienda;
        competenze = new ArrayList<>();
    }

    public void setRuolo(Ruolo ruolo){
        this.ruolo = ruolo;
    }

    public void cercaCorsiRuolo(){
        if(ruolo != null){
            if(!ruolo.getCorsi().isEmpty()){
                for(Corso c: ruolo.getCorsi()){
                    System.out.println(this.nome + "si è iscritto al corso " +
                            c.iscriviUnita(this));
                }
            }
        }
    }

    public void cercaCorsiRuolo(Ruolo ruolo){
        if(ruolo != null){
            if(!ruolo.getCorsi().isEmpty()){
                for(Corso c: ruolo.getCorsi()){
                    System.out.println(this.nome + "si è iscritto al corso " +
                            c.iscriviUnita(this));
                }
            }
        }
    }

    public boolean addCompetenza(Competenza competenza){
        for(Competenza c:competenze){
            if(c.getNome().equals(competenza.getNome()))
                return false;
        }
        competenze.add(competenza);
        return true;
    }

    public String getNome(){
        return nome;
    }

    public List<Competenza> getCompetenze(){
        return competenze;
    }

}
