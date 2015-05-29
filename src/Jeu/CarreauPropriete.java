package Jeu;

public abstract class CarreauPropriete extends Carreau {
	private int prixAchat;
        private Groupe groupePropriete;
        
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
        public void setGroupePropriete(Groupe groupe) {
            this.groupePropriete = groupe;
        }
        
        @Override
        public Groupe getGroupePropriete() {
            return this.groupePropriete;
        }
        
}