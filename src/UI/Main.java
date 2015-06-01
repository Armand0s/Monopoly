package UI;

import Jeu.Monopoly;


public class Main {

	public static void main(String[] args) {
		Monopoly m = new Monopoly("src//Data//data.txt");
                Interface inter = new Interface(m);
                
                inter.initialiserPartie();
                
                while (m.getJoueurs().size() !=1) {
                    inter.jouer();
                }
                
                System.out.println("Bravo ! Parfit finit !");
                System.out.println("Joueur " + m.getJoueurs().get(0).getNomJoueur() + " a gagné !");
	}
}
