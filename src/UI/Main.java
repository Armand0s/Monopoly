package UI;

import Jeu.Monopoly;


public class Main {

	public static void main(String[] args) {
		Monopoly m = new Monopoly("../Data/data.txt");
                Interface inter = new Interface(m);
                
                inter.initialiserPartie();
	}
}
