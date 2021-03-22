import azienda.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Controller {

    private Azienda azienda;
    private Settore gestione = new Settore("Gestione");
    private Settore produzione = new Settore("Manutenzione");
    private Settore senzaSettore = new Settore("Da assegnare");
    private Analista analista;

    public Controller(Azienda azienda) {
        this.azienda = azienda;
        createRoleIngegnere();
        createRoleManutenzione();
        createRoleMetalmeccanico();
        analista = new Analista(azienda);
    }

    public String getNomeAzienda(){
        return azienda.getNome();
    }

    private void createRoleIngegnere(){
        Ruolo r = new Ruolo(gestione, "Ingegnere");
        azienda.addRuolo(r);
        List<Competenza> competenzeIng = new ArrayList<>();
        competenzeIng.add(Competenza.createCompetenza("Disegno"));
        competenzeIng.add(Competenza.createCompetenza("Matematica"));
        r.setCompetenzeRuolo(competenzeIng);
    }

    private void createRoleManutenzione(){
        Ruolo r = new Ruolo(produzione, "Manutentore");
        azienda.addRuolo(r);
        List<Competenza> competenzeManutentore = new ArrayList<>();
        competenzeManutentore.add(Competenza.createCompetenza("Elettrotecnica"));
        competenzeManutentore.add(Competenza.createCompetenza("Manualità"));
        r.setCompetenzeRuolo(competenzeManutentore);
    }

    private void createRoleMetalmeccanico(){
        Ruolo r = new Ruolo(produzione, "Metalmeccanico");
        azienda.addRuolo(r);
        List<Competenza> competenzeMetalmeccanico = new ArrayList<>();
        competenzeMetalmeccanico.add(Competenza.createCompetenza("Manualità"));
        r.setCompetenzeRuolo(competenzeMetalmeccanico);
    }

    public void autoSetRuoli(){
        ArrayList<Unità> unità = new ArrayList<>();
        unità.addAll(azienda.getUnità());
        for(Ruolo r: azienda.getRuoli())
            if(r.getUnità() == null)
                r.setUnità(unità.remove(0));
    }

    public void addCompetenzaRuolo(Ruolo ruolo, String competenza){
        ruolo.addCompetenzeRuolo(Competenza.createCompetenza(competenza));
        System.out.println("Aggiunta " + competenza + " per il ruolo " + ruolo.getNome());
    }

    public boolean addUnità(String nomeUnità){
        if(nomeUnità.length() > 0){
            Unità temp = new Unità(nomeUnità, azienda);
            azienda.addUnità(temp);
            return true;
        }
        return false;
    }

    public void analizza(){
        boolean tuttiRuoliRicoperti = true;
        for(Ruolo r:azienda.getRuoli())
            if(r.getUnità() == null)
                tuttiRuoliRicoperti = false;
        if(tuttiRuoliRicoperti)
            analista.analizzaRuoli();
        else
            System.out.println("Alcuni ruoli non sono ricoperti!");
        //TODO fai qualcosa in questa funzione per prenderti il messaggio
    }

    public List<Unità> getUnitaAzienda(){
        return new ArrayList<>(azienda.getUnità());
    }

    public List<Ruolo> getRuoliAzienda(){
        return new ArrayList<>(azienda.getRuoli());
    }

    private void addRuolo(Ruolo r){
        this.azienda.addRuolo(r);
    }

    public void addRuolo(String nomeRuolo){
        this.azienda.addRuolo(new Ruolo(senzaSettore, nomeRuolo));
    }

    public Ruolo getRuolo(String nomeRuolo){
        for(Ruolo ruolo:azienda.getRuoli()) {
            String ruoloString = ruolo.getNome();
            if (ruoloString.equals(nomeRuolo))
                return ruolo;
        }
        return null;
    }

    public boolean haveThisCompetenza(Ruolo r, String competenza){
        for(Competenza c:r.getCompetenze())
            if(c.getNome().equals(competenza))
                return true;
        return false;
    }
}
