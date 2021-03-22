package azienda;

import java.util.ArrayList;
import java.util.List;

public class Corso {
    private final String nome;
    private List<Unità> iscritti;
    private int iscrittiMax;
    private int iscrittiAttuali = 0;

    Corso(String nomeCompetenza, Integer postiTotali) {
        this.nome = nomeCompetenza;

        if(postiTotali == null)
            iscrittiMax = 1;
        else
            iscrittiMax = postiTotali;

        iscritti = new ArrayList<>(iscrittiMax);
    }

    public String getNome() {
        return nome;
    }

    public boolean iscriviUnita(Unità unitaDaIscrivere){
        if(iscrittiAttuali <= iscrittiMax) {
            iscritti.add(unitaDaIscrivere);
            iscrittiAttuali++;
        }
        else
            System.out.println("Non ci sono più posti disponibili per "+this.nome);
        return iscritti.contains(unitaDaIscrivere);
    }

    public void registraCompetenze(){
        for(Unità u:iscritti)
           addCompetenza(u);
        iscrittiAttuali = 0;
    }

    private void addCompetenza(Unità unità){
        if(iscritti.contains(unità))
            if (unità.addCompetenza(Competenza.createCompetenza(nome)))
                System.out.println(unità.getNome() + " ha conseguito la competenza " + nome);
        else
            System.out.println(unità.getNome() + " non iscritto al corso.");
    }

}
