package Jeu;


import java.util.ArrayList;

public class ProprieteAConstruire extends CarreauPropriete {
	private int nbMaisons = 0;
	private ArrayList<Integer> loyerMaison;
	private int nbHotel = 0;
	private Groupe groupePropriete;
        
        public ProprieteAConstruire(int numero, String nomCarreau, Monopoly monopoly, int prixAchat, ArrayList<Integer> loyerMaison, Groupe groupePropriete){
            super(numero, nomCarreau, monopoly, prixAchat);
            setLoyerMaison(loyerMaison);
            setGroupePropriete(groupePropriete);
        }

        public int getNbMaisons() {
            return nbMaisons;
        }

        public void setNbMaisons(int nbMaisons) {
            this.nbMaisons = nbMaisons;
        }

        public ArrayList<Integer> getLoyerMaison() {
            return loyerMaison;
        }

        public void setLoyerMaison(ArrayList<Integer> loyerMaison) {
            this.loyerMaison = loyerMaison;
        }

        public int getNbHotel() {
            return nbHotel;
        }

        public void setNbHotel(int nbHotel) {
            this.nbHotel = nbHotel;
        }

        public Groupe getGroupePropriete() {
            return groupePropriete;
        }

        public void setGroupePropriete(Groupe groupePropriete) {
            this.groupePropriete = groupePropriete;
        }
        
        
}