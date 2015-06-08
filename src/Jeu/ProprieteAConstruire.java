package Jeu;


import java.util.ArrayList;

public class ProprieteAConstruire extends CarreauPropriete {
	private int nbMaisons = 0;
	private int nbHotel = 0;
        private ArrayList<Integer> loyers;
	private Groupe groupePropriete;
        
        public ProprieteAConstruire(int numero, String nomCarreau, Monopoly monopoly, int prixAchat, ArrayList<Integer> loyers, Groupe groupePropriete){
            super(numero, nomCarreau, monopoly, prixAchat);
            setLoyers(loyers);
            setGroupePropriete(groupePropriete);
        }

        public int getNbMaisons() {
            return nbMaisons;
        }

        public void setNbMaisons(int nbMaisons) {
            this.nbMaisons = nbMaisons;
        }

        public int getNbHotel() {
            return nbHotel;
        }

        public void setNbHotel(int nbHotel) {
            this.nbHotel = nbHotel;
        }

        @Override   
        public int getMontantAPayer() {
            Joueur prop = getProprietaire();
            if (groupePropriete.groupePossede(prop))
                if (nbHotel == 1)
                    return loyers.get(5);
                else if (nbMaisons != 0)
                    return loyers.get(nbMaisons);
                else
                    return loyers.get(0)*2;
            else
                return loyers.get(0);
        }
        
        public ArrayList<Integer> getLoyers() {
            return loyers;
        }

        public void setLoyers(ArrayList<Integer> loyerMaison) {
            this.loyers = loyerMaison;
        }

        public Groupe getGroupePropriete() {
            return groupePropriete;
        }

        public void setGroupePropriete(Groupe groupePropriete) {
            this.groupePropriete = groupePropriete;
        }
       
        
        
}