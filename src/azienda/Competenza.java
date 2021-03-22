package azienda;

public class Competenza {

    private String nome;

    private Competenza(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }

    public static Competenza createCompetenza(String nomeCompetenza){
        return new Competenza(nomeCompetenza);
    }
}
