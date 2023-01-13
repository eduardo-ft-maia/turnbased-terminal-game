package a3;

public class Poder {

    private String nomePoder;
    private int dano, custoPe;

    public Poder(String nomePoder, int dano, int custoPe) {

        this.nomePoder = nomePoder;
        this.dano = dano;
        this.custoPe = custoPe;
    }

    // getters
    
    public String getNomePoder() {
        return nomePoder;
    }
    public int getDano() {
        return dano;
    }
    public int getCustoPe() {
        return custoPe;
    }

}