package Jeu;

public class Compagnie extends CarreauPropriete {
        
        public Compagnie(int numero, String nomCarreau, Monopoly monopoly, int prixAchat){
            super(numero, nomCarreau, monopoly, prixAchat);
        }
        
        public int getMontantAPayer(){
            int argent;
            int nbrCompagnie = getProprietaire().getNbCompanies();
            int somme;
            
            if (getMonopoly().getCurrentPlayer().getVientCarteChance()){
                somme = getMonopoly().lancerDe() + getMonopoly().lancerDe();
            } else {
                somme = getMonopoly().getCurrentPlayer().getDernierJetDes();
            }

            if (nbrCompagnie == 2){
                argent = somme * 10;
            } else {
                argent = somme * 4;
            }
            
            return argent;
        }
        
}