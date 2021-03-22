package azienda;

import java.util.ArrayList;
import java.util.List;

public class Analista {
    private Azienda azienda;

    public void analizzaRuoli(){
        List<Ruolo> ruoli = azienda.getRuoli();
        for(Ruolo r:ruoli){
            List<Competenza> ruoliRichiesti = new ArrayList<>();
            List<Competenza> competenzeRichiesteDaRuolo = r.getCompetenze();
            Unità unità = r.getUnità();
            List<Competenza> competenzeUnità = unità.getCompetenze();

            for(Competenza c:competenzeRichiesteDaRuolo){
                boolean haQuestaCompetenza = false;
                for(Competenza cc:competenzeUnità){
                    if(c.getNome().compareTo(cc.getNome())==0 && !haQuestaCompetenza)
                        haQuestaCompetenza = true;
                }
                if(!haQuestaCompetenza){
                    ruoliRichiesti.add(Competenza.createCompetenza(c.getNome()));
                }
            }
            for(Competenza comp: ruoliRichiesti) {
                creaCorso(r, comp);
            }
        }
    }

    private void creaCorso(Ruolo r, Competenza c){
        boolean corsoGiaInserito = false;
        for(Corso corso:r.getCorsi()){
            if (corso.getNome() == c.getNome())
                corsoGiaInserito = true;
        }
        if(!corsoGiaInserito)
                r.addCorso(new Corso(c.getNome(), null));
    }

    public Analista(Azienda azienda){
        this.azienda = azienda;
    }
}
