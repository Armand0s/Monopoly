package Jeu;

public abstract class CarreauPropriete extends Carreau {
	private int prixAchat;
        private int prixloyer;
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

        @Override
        public Joueur getProprietaire() {
            return null;
        }
        @Override
        public void setProprietaire(Joueur proprietaire) {
            
        }


        public int getPrixloyer() {
            return prixloyer;
        }


        public void setPrixloyer(int prixloyer) {
            this.prixloyer = prixloyer;
        }
        

        
}