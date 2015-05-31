package Jeu;

import java.util.ArrayList;

public class Groupe {
	private CouleurPropriete couleur;
	private int prixAchatMaison;
	private int prixAchatHotel;
	private ArrayList<ProprieteAConstruire> proprietes = new ArrayList<ProprieteAConstruire>();

    public Groupe(CouleurPropriete couleur, int prixAchatMaison, int prixAchatHotel) {
        this.couleur = couleur;
        this.prixAchatMaison = prixAchatMaison;
        this.prixAchatHotel = prixAchatHotel;
    }

    public CouleurPropriete getCouleur() {
        return couleur;
    }

    public void setCouleur(CouleurPropriete couleur) {
        this.couleur = couleur;
    }

    public int getPrixAchatMaison() {
        return prixAchatMaison;
    }

    public void setPrixAchatMaison(int prixAchatMaison) {
        this.prixAchatMaison = prixAchatMaison;
    }

    public int getPrixAchatHotel() {
        return prixAchatHotel;
    }

    public void setPrixAchatHotel(int prixAchatHotel) {
        this.prixAchatHotel = prixAchatHotel;
    }

    public ArrayList<ProprieteAConstruire> getProprietes() {
        return proprietes;
    }

    public void setProprietes(ArrayList<ProprieteAConstruire> proprietes) {
        this.proprietes = proprietes;
    }
        
    public boolean groupePossede(Joueur joueur){
        Boolean res = true;
        for (ProprieteAConstruire prop : proprietes){
            if (joueur != prop.getProprietaire()){
                res = false;
            }
        }
        return res;
    }
        
}