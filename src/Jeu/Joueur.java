package Jeu;

import java.util.ArrayList;

public class Joueur {
	private String nomJoueur;
	private int cash = 1500;
	private Monopoly monopoly;
        private Carreau positionCourante;
	private ArrayList<Compagnie> compagnies = new ArrayList<Compagnie>();
	private ArrayList<Gare> gares = new ArrayList<Gare>();
	private ArrayList<ProprieteAConstruire> proprietesAConstruire = new ArrayList<ProprieteAConstruire>();
        private boolean vientCarteChance;
        private int dernierJetDes;
        private boolean drapeauPrison;
        
        private boolean doubleDe;
        private int nbDouble;

        public Joueur(String nomJoueur,Carreau positionCourante, Monopoly monopoly) {
            setNomJoueur(nomJoueur);
            setPositionCourante(positionCourante);
            setMonopoly(monopoly);
        }
        
        
        public void avancer(int nbcase) {
            this.dernierJetDes = nbcase;
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
        if (this.nbDouble == 3) {
            this.allerPrison();
            setDoubleDe(false);
        } else {
        setDoubleDe(doubleDe);
        }
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
        private void setCash(int cash) {
            this.cash = cash;
        }
        public void addCash(int cash){
            this.setCash(this.getCash() + cash);
        }
        public void removeCash(int cash){
            this.setCash(this.getCash() - cash);
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
            //if (this.getPositionCourante() ==  // Cheacker si il vient d'une carte chance ou pas
            this.positionCourante = positionCourante;
        }

        public ArrayList<ProprieteAConstruire> getProprietesAConstruire() {
            return proprietesAConstruire;
        }
        public void setProprietesAConstruire(ArrayList<ProprieteAConstruire> proprietesAConstruire) {
            this.proprietesAConstruire = proprietesAConstruire;
        }
        
        public void payer(Joueur joueur, int montant){
            if (this.getCash() >= montant){
                this.removeCash(montant);
                joueur.addCash(montant);
            } else {
                int argentJoueur = this.getCash();
                this.removeCash(argentJoueur);
                joueur.addCash(argentJoueur);
            }
        }
        
        public int getNbGare() {
            return this.gares.size();
        }
        
        public int getNbCompanies() {
            return this.compagnies.size();
        }

        public boolean getVientCarteChance() {
            return vientCarteChance;
        }

        public void setVientCarteChance(boolean vientCarteChance) {
            this.vientCarteChance = vientCarteChance;
        }

        public int getDernierJetDes() {
            return dernierJetDes;
        }

        public void setDernierJetDes(int dernierjetdes) {
            this.dernierJetDes = dernierjetdes;
        }
        
        public int getNbMaisons(){
            int i = 0;
            for (ProprieteAConstruire prop : proprietesAConstruire){
                i += prop.getNbMaisons();
            }
            return i;
        }
        public int getNbHotels(){
            int i = 0;
            for (ProprieteAConstruire prop : proprietesAConstruire){
                i += prop.getNbHotel();
            }
            return i;
        }
        
        
        
        public void actionCarreau() { //regarde l'etat de la case propriete sur laquelle est tombé le joueur
           
            Carreau cTemp = this.getPositionCourante();
            
            if (cTemp instanceof CarreauPropriete) {
                CarreauPropriete c = (CarreauPropriete) cTemp;
                Joueur proprio = c.getProprietaire();
                if (proprio != null && proprio != this) {
                    int montantAPayer = c.getMontantAPayer();
                    this.payer(proprio, montantAPayer);
                } else if (proprio == null) {
                    //getMonopoly().getInter().proposerAchat();
                }
            } else { // (c instanceof CarreauAction)
                // Faire la fonction pour déplacer ou payer suivant la carte mais réservé à la semaien bloquée je crois
            }
        }
        
        public void allerPrison() {
            this.setPositionCourante(monopoly.getCarreau(31)); // 31 = position de la prison
            this.monopoly.getInter().afficherAllerPrison();
        }
        
        public void reculer(int nbcases) {
            if (getPositionCourante().getNumero()-nbcases < 1) {
                this.setPositionCourante(monopoly.getCarreau(getPositionCourante().getNumero() - nbcases + 40));
            } else {
                this.setPositionCourante(monopoly.getCarreau(getPositionCourante().getNumero() - nbcases));
            }
        }
}
