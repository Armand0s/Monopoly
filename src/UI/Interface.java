package UI;

import Jeu.CarreauPropriete;
import Jeu.CarteCaisseEnum;
import Jeu.CarteChanceEnum;
import Jeu.Monopoly;
import java.util.Scanner;
import Jeu.Joueur;
import Jeu.ProprieteAConstruire;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;

public class Interface {
	public Monopoly monopoly;

    public Interface(Monopoly monopoly) {
        setMonopoly(monopoly);
    }
       
    public Monopoly getMonopoly() {
        return monopoly;
    }
    public void setMonopoly(Monopoly monopoly) {
        this.monopoly = monopoly;
    }
    
    public void initialiserPartie (){
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        String[] nomj = new String[6];
        int[]    nbrj = new int[6];
        int nbrJoueur = 0;
        String nomJoueur;
        while(nbrJoueur<2 | nbrJoueur>6){
            System.out.println("Veuillez indiquer le nombre de joueur : ");
            nbrJoueur = sc.nextInt();
        }
        for(int i=0; i<nbrJoueur; i++){
            System.out.println("Veuillez saisir le nom du joueur n°"+(i+1)+" : ");
            nomJoueur = sc1.nextLine();
            nomj[i] = nomJoueur;
            //monopoly.nouveauJoueur(nomJoueur);
        }
        
        // met un lancé de dé pour chaque joueur pour savoir qui commence
        System.out.println("---------------------------------------");
        System.out.println("Les joueurs vont jouer dans cet ordre :");
        for(int i=0; i<nbrJoueur; i++){ 
            nbrj[i] = monopoly.lancerDe();
            //System.out.println(nbrj[i]);
        }
        
        for(int i=0; i<nbrJoueur; i++){
            int maxi = 0; //  le nombre max des lancés de dés
            int jmax = 0; //  le joueur ayant le nombre max
            for(int j=0; j<nbrJoueur; j++){
                if (nbrj[j]>maxi) {
                   maxi = nbrj[j]; 
                   jmax = j;
                }
            }
            nbrj[jmax] = 0; // met la valeur du lancé du joueur selectionné à 0
            System.out.println(nomj[jmax]);
            monopoly.nouveauJoueur(nomj[jmax]); // crée un joueur avec son nom
        
        }
        monopoly.setCurrentPlayer(monopoly.getJoueurs().get(0));
        
    }
    
    public void test(){
        ProprieteAConstruire c = (ProprieteAConstruire) monopoly.getCarreau(2);
        System.out.println(c.getGroupePropriete().getCouleur());
    }
    
    public void jouer() {
        Joueur joueur = monopoly.getCurrentPlayer();
        this.afficherEtatDebutTour();
        
        // On rappelle où en est le joueur
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------------");
        System.out.println("Joueur : " + joueur.getNomJoueur());
        System.out.println("Vous êtes sur la case : " + joueur.getPositionCourante().getNomCarreau());
        System.out.println("--------------------------");
        
        
        // On lance les des et on avance
        joueur.setDoubleDe(true); // Nécessaire pour que la boucle se lance
        joueur.setNbDouble(0);
        while (joueur.getDoubleDe() == true && joueur.getDrapeauPrison() == false){
            System.out.println("Appuyez sur ENTRER pour lancer les dés");
            sc.nextLine();
            
            monopoly.lancerDesEtAvancer(); // Lance les des et affiche l'etat du joueur
            // On effectue l'action sur la case
            joueur.actionCarreau();
            
            // SI IL PEUT : On propose d'acheter un titre de propriété
            // SI IL PEUT : On propose de construire
            if (joueur.peutConstruire()){
                joueur.construire();
            }
            // SI IL PEUT : On propose de passer au tour suivant
            
            // SI IL PEUT : On propose de quitter la partie
  
        }

        
        
        
        
        
        
        

        
        
        // On affiche ensuite l'état courant du jeu et la patrimoine de chaque joueur
        
        
        // On incremente de 1 le numéro du joueur
        
        
        monopoly.setCurrentPlayer( // Incrémente le CurrentJoueur
                monopoly.getJoueurs().get((
                    monopoly.getJoueurs().indexOf( // int
                            joueur
                    )
                +1)% monopoly.getJoueurs().size())
        );
    }
    
    
     // Fonctions d'affichage :
    
    
    public void afficherLancerDe(int de1, int de2) {
        System.out.println("Le résultat du premier dé est " + de1 + " et le résultat du deuxième est " + de2 + "\nCe qui donne une somme de " + (de1 + de2));
    }
    
    public void afficherAllerPrison() {
        if (this.getMonopoly().getCurrentPlayer().getNbDouble() == 3) {
            System.out.println( "Le joueur " + this.getMonopoly().getCurrentPlayer().getNomJoueur() + " va en prison car il a fait 3 doubles d'affilé !");
        } else {
        System.out.println("Le joueur " + this.getMonopoly().getCurrentPlayer().getNomJoueur() + " va en prison!");
        }
    }
    
    public void afficherEtatJoueur(Joueur j){
        //System.out.println("Vous faites un lancé de " + j.getDernierJetDes());
        System.out.println("Vous arrivez sur la case : " + j.getPositionCourante().getNomCarreau());
    }
    
    public void afficherEtatDebutTour(){
        System.out.println("----------------------------------------");
        for (Joueur joueur : getMonopoly().getJoueurs()){
            System.out.println("");
            System.out.println(" - Le joueur " + joueur.getNomJoueur() + " se trouve sur la case "
                    + joueur.getPositionCourante().getNumero() + " : "
                    + joueur.getPositionCourante().getNomCarreau());
            System.out.println("   Et il possède " + joueur.getCash() + " euros");
        }
    }
    
    public void afficherFinDuTour(){
        Joueur joueur = monopoly.getCurrentPlayer();
        System.out.println(joueur.getNomJoueur() + " a fini son tour.");
    }
    
    public void afficherActionCarteChance(CarteChanceEnum action){
        System.out.println("************** Carte Chance **************");
        System.out.println(action.toString());
        System.out.println("******************************************");
    }
    
    public void afficherActionCarteCaisse(CarteCaisseEnum action){
        System.out.println("********** Caisse de communauté **********");
        System.out.println(action.toString());
        System.out.println("******************************************");
    }
    
    public void afficheMontantAPayer(Joueur proprio, int montant){
        System.out.println("Vous payez " + montant + " au joueur " + proprio.getNomJoueur());
    }
    
    public boolean proposerAchat(CarreauPropriete c){
        Scanner sc = new Scanner(System.in);
        System.out.println("Voulez vous acheter " + c.getNomCarreau() + " pour la somme de " + c.getPrixAchat() + " euros ? (oui/non)");
        String choix = sc.nextLine();
        while (!"oui".equals(choix) & !"non".equals(choix)){
            System.out.println("Je n'ai pas compris votre choix");
            System.out.println("oui/non : ");
            choix = sc.nextLine();
        }
            return "oui".equals(choix);
    }
    
    public boolean proposerConstruction(int prix, String construction){
        Scanner sc = new Scanner(System.in);
        System.out.println("Voulez vous construire " + construction + " pour la somme de " + prix + " ? (oui/non)");
        String choix = sc.nextLine();
        while (!"oui".equals(choix) & !"non".equals(choix)){
            System.out.println("Je n'ai pas compris votre choix");
            System.out.println("oui/non : ");
            choix = sc.nextLine();
        }
            return "oui".equals(choix);
    }
    
    public void afficherArgentJoueur(Joueur j){
        System.out.println("Vous possédez actuellement " + j.getCash());
    }
    
    public void afficheFicheCarte(CarreauPropriete c){
        System.out.println("+----------------------+");
        System.out.println("|" + c.getNomCarreau() + "|");
        System.out.println("+----------------------+");
    }
    
    public int demandeTerrainOuConstruire(ArrayList<ProprieteAConstruire> proprietesConstructible){
        Scanner sc = new Scanner(System.in);
        int choix = 0;
        
        System.out.println("Vous pouvez construire sur les terrains suivant :");
        for (int i = 1; i < proprietesConstructible.size(); i++){
            System.out.println(i + ". " + proprietesConstructible.get(i).getNomCarreau());
        }
        System.out.println("Où voulez vous construire ?");
        while (choix < 1 | choix > proprietesConstructible.size()){
            System.out.println("Je n'ai pas compris votre demande");
            choix = sc.nextInt();
        }
        return choix;
    }

}