package a3;

public class Heroi extends Personagem {

    String nomeReal;

    public Heroi(String nome, String editora, int pf, int pe, boolean mimico, boolean drenador, String nomeReal) {
        super(nome, editora, pf, pe, mimico, drenador);   

        this.nomeReal = nomeReal;
    } 
}