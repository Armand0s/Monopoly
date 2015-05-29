package Jeu;


import java.util.ArrayList;

public class ProprieteAConstruire extends CarreauPropriete {
	private int nbMaisons = 0;
	private ArrayList<Integer> loyerMaison;
	private int nbHotel = 0;
	private Groupe groupePropriete;
        private Joueur proprietaire;
        
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

           
        @Override
        public int getLoyerMaison() {
            return loyerMaison.get(this.getNbMaisons()+ this.getNbHotel()*5);
        }
        
        public ArrayList<Integer> getLoyerProp() {
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

        @Override
        public void setProprietaire(Joueur _proprietaire) {
            this.proprietaire = _proprietaire; //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Joueur getProprietaire() {
            return this.proprietaire; //To change body of generated methods, choose Tools | Templates.
        }
        
        
        
}