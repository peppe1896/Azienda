import azienda.*;

public class Main {
    public static void main(String args[]){
        /*List<Competenza> competenzeIng = new ArrayList<>();

        competenzeIng.add(Competenza.createCompetenza("Disegno"));
        competenzeIng.add(Competenza.createCompetenza("Matematica"));

        Azienda azienda = new Azienda();
        Unità giuseppe = new Unità("Giuseppe", azienda);
        Settore gestione = new Settore("Gestione");
        Ruolo ingegnere = new Ruolo(gestione, "Ingegnere");
        ingegnere.setCompetenzeRuolo(competenzeIng);
        Analista analista = new Analista(azienda);
        giuseppe.addCompetenza(Competenza.createCompetenza("Disegno"));
        azienda.addRuolo(ingegnere);
        ingegnere.setUnità(giuseppe);
        analista.analizzaRuoli();
        System.out.println("");

        giuseppe.cercaCorsiRuolo();
        System.out.println("");
        ingegnere.getCorsi().get(0).registraCompetenze();
        System.out.println("");
        analista.analizzaRuoli();
        System.out.println("");
*/
        Azienda azienda = new Azienda("CalabrianSoftware");
        Controller c = new Controller(azienda);
        GUI gui = new GUI(c);
        // System.out.println("");
        // c.aggiungiUnità("Giuseppe");
        // c.aggiungiUnità("Michele");
        // c.aggiungiUnità("Giulio");
        // c.autoSetRuoli();
        // c.analizza();
        // System.out.println("");

    }
}
