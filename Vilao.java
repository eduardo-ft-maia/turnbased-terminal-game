package a3;

public class Vilao extends Personagem {

    int maldade;

    public Vilao(String nome, String editora, int pf, int pe, boolean mimico, boolean drenador, int maldade) {
        super(nome, editora, pf, pe, mimico, drenador);
        

        this.maldade = maldade;
    }
}