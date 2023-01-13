package a3;

import java.util.ArrayList;
import java.util.Random;

public class Personagem {

    Random random = new Random();

    private String nome, editora;
    private int pf, pe, pfInicial, peInicial;
    private boolean mimico, drenador;
    private ArrayList<Poder> poder = new ArrayList<>();

    public Personagem(String nome, String editora, int pf, int pe, boolean mimico, boolean drenador) {
        
        this.nome = nome;
        this.editora = editora;
        this.pf = pf;
        this.pe = pe;
        this.pfInicial = pf;
        this.peInicial = pe;
        this.mimico = mimico;
        this.drenador = drenador;
    }

    // getters

    public String getNome() {
        return nome;
    }

    public String getEditora() {
        return editora;
    }

    public int getPf() {
        return pf;
    }

    public int getPe() {
        return pe;
    }

    public boolean getMimico() {
        return mimico;
    }

    public boolean getDrenador() {
        return drenador;
    }

    public ArrayList<Poder> getPoder() {
        return poder;
    }

    public void atacar(Personagem oponente) {

        int randPoder = random.nextInt(0, poder.size()); // randomizando o ataque

        if (pe >= poder.get(randPoder).getCustoPe()) {

            System.out.println(nome + " usou " + poder.get(randPoder).getNomePoder() + " em " + oponente.nome + "! Dano causado: " + poder.get(randPoder).getDano());
        
            pe = pe - poder.get(randPoder).getCustoPe();
            oponente.pf = oponente.pf - poder.get(randPoder).getDano();

        }else {

            System.out.println("PE insuficiente..." + nome + " fica triste e usa Recuperar!");
            recuperar();
        }    
    }   

    public void addPoder(Poder poder) {
        
        this.poder.add(poder);
    }

    void removerPoder(Poder poder) {

        this.poder.remove(poder);
    }

    void recuperar() {

        pe = (int) (pe + (peInicial * 0.3));       
        System.out.println(nome + " recuperou sua energia e agora está com " + pe + " de PE!");
    }

    void recuperarFull() {

        pf = pfInicial;
        pe = peInicial;
    }

    void drenar(Personagem oponente) {

        peInicial = peInicial + oponente.pe;
        
        System.out.println(nome + " tem " + pe + " de PE...");
        System.out.println("Mas Drenou seu oponente e agora está com " + peInicial + " de PE!");
    }

    void clonar(Personagem oponente) {
        poder.clear();

        ArrayList<Poder> clonados = oponente.getPoder();

        this.poder.addAll(clonados);

        System.out.println(nome + " copiou os poderes de seu oponente!");
        System.out.println("Agora " + nome + " tem os poderes: ");

        for (int j = 0; j < oponente.getPoder().size(); j ++) {

            System.out.println(poder.get(j).getNomePoder());
        }
    }
}