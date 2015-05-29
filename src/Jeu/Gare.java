package Jeu;

public class Gare extends CarreauPropriete {
    
    private Joueur proprietaire;
    
    
    public Gare (int numero, String nomCarreau, Monopoly monopoly, int prixAchat){
        super(numero, nomCarreau, monopoly, prixAchat);
    }

    @Override
    public void setProprietaire(Joueur _proprietaire) {
        this.proprietaire = _proprietaire; 
    }

    @Override
    public Joueur getProprietaire() {
        return this.proprietaire; 
    }
    
    
    
    
}