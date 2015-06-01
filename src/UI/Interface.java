package UI;

import Jeu.Monopoly;
import java.util.Scanner;

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
    
    public void jouer() {
        
        System.out.println("--------------------------");
        System.out.println("------ Joueur : " + monopoly.getCurrentPlayer().getNomJoueur());
        System.out.println("------ Vous êtes sur la case : " + monopoly.getCurrentPlayer().getPositionCourante().getNomCarreau() +"---");
        System.out.println("--------------------------");
        
        
        monopoly.setCurrentPlayer( // Incrémente le CurrentJoueur
                monopoly.getJoueurs().get(
                    monopoly.getJoueurs().indexOf( // int
                        monopoly.getJoueurs().indexOf(
                            monopoly.getCurrentPlayer(
                            )
                        )
                    +1)
                )
        );
    }
    
    
}