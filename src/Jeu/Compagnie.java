package Jeu;

public class Compagnie extends CarreauPropriete {
    
    private Joueur proprietaire;
        
        public Compagnie(int numero, String nomCarreau, Monopoly monopoly, int prixAchat){
            super(numero, nomCarreau, monopoly, prixAchat);
        }

    @Override
    public void setProprietaire(Joueur proprietaire) {
        this.proprietaire = proprietaire; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Joueur getProprietaire() {
        return this.proprietaire; //To change body of generated methods, choose Tools | Templates.
    }
        
        
        
}