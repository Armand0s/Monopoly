package Jeu;

public abstract class CarreauPropriete extends Carreau {
	private int prixAchat;
        private Joueur proprietaire;
        
        public CarreauPropriete (int numero, String nomCarreau, Monopoly monopoly, int prixAchat){
            super(numero, nomCarreau, monopoly);
            setPrixAchat(prixAchat);
        }

        public int getPrixAchat() {
            return prixAchat;
        }

        public void setPrixAchat(int prixAchat) {
            this.prixAchat = prixAchat;
        }

        public Joueur getProprietaire() {
            return this.proprietaire;
        }
        
        public void setProprietaire(Joueur proprietaire) {
            this.proprietaire = proprietaire;
        }

        abstract public int getMontantAPayer();
        

        
}