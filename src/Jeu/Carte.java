/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jeu;


public abstract class Carte {
    private Monopoly monopoly;
    
    public Carte(Monopoly monopoly){
        setMonopoly(monopoly);
    }
    
    public Monopoly getMonopoly(){
        return monopoly;
    }
    private void setMonopoly(Monopoly monopoly){
        this.monopoly = monopoly;
    }
    
}
