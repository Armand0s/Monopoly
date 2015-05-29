package Jeu;

public abstract class CarreauPropriete extends Carreau {
	private int prixAchat;
        private int loyerMaison;
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


        @Override
        public int getLoyerMaison() {
            return loyerMaison;
        }


        @Override
        public void setLoyerMaison(int prixloyer) {
            this.loyerMaison = prixloyer;
        }
        

        
}