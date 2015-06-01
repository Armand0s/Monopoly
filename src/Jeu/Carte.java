/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jeu;


public abstract class Carte {
    private Monopoly monopoly;
    
    public Monopoly getMonopoly(){
        return monopoly;
    }
    private void setMonopoly(Monopoly monopoly){
        this.monopoly = monopoly;
    }
    
    public void avancerCarte(int numcase){
        Joueur joueur = monopoly.getCurrentPlayer();
        int i = joueur.getPositionCourante().getNumero();
            if (i > numcase){
                i = 40-i + numcase;
            }
            else {
                i = numcase-i;
            }
            joueur.avancer(i);
        }
}
