package Jeu;

import java.util.ArrayList;

public class Joueur {
	private String nomJoueur;
	private int cash = 1500;
	private Monopoly monopoly;
	private ArrayList<Compagnie> compagnies = new ArrayList<Compagnie>();
	private ArrayList<Gare> gares = new ArrayList<Gare>();
	private Carreau positionCourante;
	private ArrayList<ProprieteAConstruire> proprietesAConstruire = new ArrayList<ProprieteAConstruire>();
        
        private boolean doubleDe;
        private int nbDouble;

        public Joueur(String nomJoueur,Carreau positionCourante, Monopoly monopoly) {
            setNomJoueur(nomJoueur);
            setPositionCourante(positionCourante);
            setMonopoly(monopoly);
        }
        
        
        public void avancer(int nbcase) {
            if (getPositionCourante().getNumero()+nbcase > 40) {
                this.setPositionCourante(monopoly.getCarreau(getPositionCourante().getNumero() + nbcase - 40));
                this.addCash(200);
            } else {
                this.setPositionCourante(monopoly.getCarreau(getPositionCourante().getNumero() + nbcase));
            }
        }

    public boolean getDoubleDe() {
        return doubleDe;
    }

    public void setDoubleDe(boolean doubleDe) {
        this.doubleDe = doubleDe;
    }

    public int getNbDouble() {
        return nbDouble;
    }

    public void setNbDouble(int nbDouble) {
        this.nbDouble = nbDouble;
    }
    
    public void incrNbDouble(){
        this.nbDouble += 1;
    }

    public void actionDouble(boolean doubleDe){
        if(doubleDe){
            incrNbDouble();
        }
        setDoubleDe(doubleDe);
    }
        
        
        public String getNomJoueur() {
            return nomJoueur;
        }
        public void setNomJoueur(String nomJoueur) {
            this.nomJoueur = nomJoueur;
        }
        
        public int getCash() {
            return cash;
        }
        public void setCash(int cash) {
            this.cash = cash;
        }
        public void addCash(int cash){
            this.cash += cash;
        }

        public Monopoly getMonopoly() {
            return monopoly;
        }
        public void setMonopoly(Monopoly monopoly) {
            this.monopoly = monopoly;
        }

        public ArrayList<Compagnie> getCompagnies() {
            return compagnies;
        }
        public void setCompagnies(ArrayList<Compagnie> compagnies) {
            this.compagnies = compagnies;
        }

        public ArrayList<Gare> getGares() {
            return gares;
        }
        public void setGares(ArrayList<Gare> gares) {
            this.gares = gares;
        }

        public Carreau getPositionCourante() {
            return positionCourante;
        }
        public void setPositionCourante(Carreau positionCourante) {
            this.positionCourante = positionCourante;
        }

        public ArrayList<ProprieteAConstruire> getProprietesAConstruire() {
            return proprietesAConstruire;
        }
        public void setProprietesAConstruire(ArrayList<ProprieteAConstruire> proprietesAConstruire) {
            this.proprietesAConstruire = proprietesAConstruire;
        }
       
        public void paye(int somme) {
            this.setCash(this.getCash()- somme);
            
        }    
        
        public boolean proprioGroupe(Carreau carreau) {
            
            Groupe groupe;
            groupe = carreau.getGroupePropriete();
            
            boolean res = true;
            
            if (groupe != null) {
                for (ProprieteAConstruire prop : groupe.getProprietes()) {
                    if (prop.getProprietaire() != this) {
                        res = false;
                    }
                }
                
            }
            return res;
        }
}