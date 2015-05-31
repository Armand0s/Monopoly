package Jeu;

public class Gare extends CarreauPropriete {
    
    private Joueur proprietaire;
    
    
    public Gare (int numero, String nomCarreau, Monopoly monopoly, int prixAchat){
        super(numero, nomCarreau, monopoly, prixAchat);
    }

    @Override
    public int getMontantAPayer() {
        int nbGare = getProprietaire().getNbGare();
        return 25 * nbGare;
    }

    
}