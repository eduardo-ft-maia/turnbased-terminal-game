package a3;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        ArrayList<Personagem> personagens = new ArrayList<>();

        Heroi spiderman = new Heroi("Spider-Man", "Marvel", 80, 50, false, false, "Peter Parker");
        Heroi superman = new Heroi("Superman", "DC Comics", 100, 70, false, false, "Clark Kent");
        Heroi fenix = new Heroi("Fênix", "Marvel", 150, 100, false, false, "Jean Grey");
        Heroi mimico = new Heroi("Mímico", "Marvel", 70, 50, true, false, "Calvin Montgomery Rankin");

        Vilao superbiz = new Vilao("Superbizarro", "DC Comics", 95, 65, false, false, 50);
        Vilao duende = new Vilao("Duende Verde", "Marvel", 80, 60, false, false, 70);
        Vilao otto = new Vilao("Doutor Octopus", "Marvel", 70, 40, false, false, 40);
        Vilao superskull = new Vilao("Super Skull", "Marvel", 90, 60, true, false, 100);
        Vilao parasita = new Vilao("Parasita", "Marvel", 90, 70, false, true, 70);

        Poder forcaS = new Poder("Força", 7, 5);
        Poder soltarTeia = new Poder("Soltar Teia", 5, 5);

        spiderman.addPoder(soltarTeia);
        spiderman.addPoder(forcaS);

        Poder forcaM = new Poder("Força", 10, 8);
        Poder raiosM = new Poder("Visão de Raios", 5, 5);
        Poder soproM = new Poder("Supersopro", 4, 4);

        superman.addPoder(forcaM);
        superman.addPoder(raiosM);
        superman.addPoder(soproM);

        Poder forcaF = new Poder("Força", 12, 10);

        fenix.addPoder(forcaF);

        Poder forcaBiz = new Poder("Força", 10, 8);
        Poder raiosBiz = new Poder("Visão de Raios", 5, 5);
        Poder soproBiz = new Poder("Supersopro", 4, 4);

        superbiz.addPoder(raiosBiz);
        superbiz.addPoder(forcaBiz);
        superbiz.addPoder(soproBiz);

        Poder forcaD = new Poder("Força", 7, 5);
        Poder granada = new Poder("Granada de Abóbora", 5, 5);

        duende.addPoder(forcaD);
        duende.addPoder(granada);

        Poder tentaculo = new Poder("Tentáculos", 6, 4);

        otto.addPoder(tentaculo);

        Poder forcaP = new Poder("Força", 7, 8);
        Poder rajada = new Poder("Rajada Energética", 6, 8);

        parasita.addPoder(forcaP);
        parasita.addPoder(rajada);

        personagens.add(spiderman);
        personagens.add(superman);
        personagens.add(fenix);
        personagens.add(mimico);
        personagens.add(superbiz);
        personagens.add(duende);
        personagens.add(otto);
        personagens.add(superskull);
        personagens.add(parasita);

        System.out.println("Digite 1 para jogar...");
        int p = sc.nextInt();
        while (p == 1) {

            int randOponente1 = random.nextInt(0, personagens.size()); // randomizando os personagens
            int randOponente2 = random.nextInt(0, personagens.size());

            while (personagens.get(randOponente1).getMimico() == true && personagens.get(randOponente2).getMimico() == true) {      
                randOponente1 = random.nextInt(0, personagens.size()); // não podemos ter 2 mimicos entao...
                randOponente2 = random.nextInt(0, personagens.size());
            }
            confronto(personagens.get(randOponente1), personagens.get(randOponente2));

            System.out.printf("\nPressione '1' para jogar novamente e '2' para sair.\n");
            p = sc.nextInt();
        }

        System.out.println("Obrigado por jogar!!!");
    }

    public static void confronto(Personagem oponente1, Personagem oponente2) {
        
        int i = 0; // i = numerador de rounds

        oponente1.recuperarFull(); 
        oponente2.recuperarFull();

        System.out.println("O seu Personagem é " + oponente1.getNome() + " e seu oponente é " + oponente2.getNome() + "!");
        
        // Caixas de dialogo para alguns casos

        if (oponente1.getNome() == oponente2.getNome()) {
            System.out.println("\nBatalha espelhada!");
        }

        if (oponente1.getClass() == oponente2.getClass()) {
            System.out.println("\nBatalha entre aliados!\n");
        } else {
            System.out.printf("\nHerói contra Vilão!\n");
        }

        if (oponente1.getEditora() != oponente2.getEditora()) {
            System.out.println("\nCrossover das melhores editoras!\n");
        }

        // mimicos

        if (oponente2.getMimico() == true) {
            oponente2.clonar(oponente1);

        } else if (oponente1.getMimico() == true) {
            oponente1.clonar(oponente2);
        }

        System.out.println();
        // drenadores

        if (oponente1.getDrenador() == true) {
            oponente1.drenar(oponente2);

        } else if (oponente2.getDrenador() == true) {
            oponente2.drenar(oponente1);
        }

        while (oponente1.getPf() > 0 && oponente2.getPf() > 0) {
            
            i ++;

            System.out.printf("\nROUND %d!!!\n\n", i);

            oponente1.atacar(oponente2);
            
            // log do round
            System.out.println(oponente2.getNome() + " está com " + oponente2.getPf() + " de PF e " + oponente2.getPe() + " de PE!");

            if (oponente2.getPf() <= 0) {

                System.out.println(oponente2.getNome() + " perde.");
                System.out.println(oponente1.getNome() + " vence a batalha!!!");

                break;

            } else {

                System.out.println();
                oponente2.atacar(oponente1);

                // log do round
                System.out.println(oponente1.getNome() + " está com " + oponente1.getPf() + " de PF e " + oponente1.getPe() + " de PE!");

            }

            if (oponente1.getPf() <= 0) {

                System.out.println(oponente1.getNome() + " perde.");
                System.out.println(oponente2.getNome() + " vence a batalha!!!");

                break;
            }
        }
    }
}
