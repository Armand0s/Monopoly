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
        private boolean carteChanceLibere = false;
        private boolean carteCaisseLibere = false;
        
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

        /**
         * Réduit le capital financier du joueur
         * @param cash L'argent à enlevé au joueur
         * @return L'argent réellement enlevé au joueur.
         */
        public int removeCash(int cash){
            int cashJoueur = this.getCash();
            if (cashJoueur >= cash){ // Si le joueur a asser d'argent on lui enleve cash
                this.setCash(cashJoueur - cash);
                return cash; // Et on retourne cash
            } else { // Sinon, on lui enlève toute son argent
                this.setCash(0);
                return cashJoueur; // et on retourne ce qu'il avait
            }
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
        private void setCompagnies(ArrayList<Compagnie> compagnies) {
            this.compagnies = compagnies;
        }
        private void addCompagnie(Compagnie compagnie){
            this.compagnies.add(compagnie);
        }
        

        public ArrayList<Gare> getGares() {
            return gares;
        }
        private void setGares(ArrayList<Gare> gares) {
            this.gares = gares;
        }
        private void addGare(Gare Gare){
            this.gares.add(Gare);
        }
        

        public ArrayList<ProprieteAConstruire> getProprietesAConstruire() {
            return proprietesAConstruire;
        }
        private void setProprietesAConstruire(ArrayList<ProprieteAConstruire> proprietesAConstruire) {
            this.proprietesAConstruire = proprietesAConstruire;
        }
        
        private void addProprieteAConstruire(ProprieteAConstruire propriete){
            this.proprietesAConstruire.add(propriete);
        }
        
        /**
         * Convertie et ajoute la propriete c aux propriete du joueur
         * @param c Le CarreauPropriete à ajouter au joueur
         */
        public void ajouterPropriete(CarreauPropriete c){
            if (c instanceof Compagnie){
                Compagnie compagnie = (Compagnie) c;
                this.addCompagnie(compagnie);
            } else if (c instanceof Gare){
                Gare gare = (Gare) c;
                this.addGare(gare);
            } else if (c instanceof ProprieteAConstruire){
                ProprieteAConstruire propriete = (ProprieteAConstruire) c;
                this.addProprieteAConstruire(propriete);
            }
        }
        

        public Carreau getPositionCourante() {
            return positionCourante;
        }
        public void setPositionCourante(Carreau positionCourante) {
            //if (this.getPositionCourante() ==  // Cheacker si il vient d'une carte chance ou pas
            this.positionCourante = positionCourante;
        }
        
        
        public void payer(Joueur joueur, int montant){
            int montantEffectif = removeCash(montant);
            joueur.addCash(montantEffectif);
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
        
        public boolean getCarteChanceLibere(){
            return this.carteChanceLibere;
        }
        public void setCarteChanceLibere(boolean carteChanceLibere){
            this.carteChanceLibere = carteChanceLibere;
        }
        
        public boolean getCarteCaisseLibere(){
            return this.carteCaisseLibere;
        }
        public void setCarteCaisseLibere(boolean carteCaisseLibere){
            this.carteCaisseLibere = carteCaisseLibere;
        }
        
        public boolean getDrapeauPrison(){
            return this.drapeauPrison;
        }
        public void setDrapeauPrison(boolean drapeauPrison){
            this.drapeauPrison = drapeauPrison;
        }
        
        public void actionCarreau() { //regarde l'etat de la case propriete sur laquelle est tombé le joueur
           
            Carreau cTemp = this.getPositionCourante();
            
            if (cTemp instanceof CarreauPropriete) {
                CarreauPropriete c = (CarreauPropriete) cTemp;
                Joueur proprio = c.getProprietaire(); 
                
                // Si le propriétaire est un autre joueur on paye le loyer
                if (proprio != null && proprio != this) {
                    int montantAPayer = c.getMontantAPayer();
                    getMonopoly().getInter().afficheMontantAPayer(proprio, montantAPayer);
                    this.payer(proprio, montantAPayer);
                    
                // Si y a pas de proprio on regarde si on peut lui proposer l'achat
                } else if (proprio == null) {
                    // Si il a assez d'argent
                    if (this.getCash() >= c.getPrixAchat()){
                        // Et qu'il accepte l'achat
                        if (getMonopoly().getInter().proposerAchat(c)){
                            this.removeCash(c.getPrixAchat());
                            this.ajouterPropriete(c);
                            c.setProprietaire(this);
                        }
                    }
                // Enfin, si il est lui même propriétaire et qu'il peut construire
                // Alors on lance la procedure de construction
                } else if (proprio == this & this.peutConstruire()){
                    //this.construire();
                }
            }
            else {//(cTemp instanceof CarreauAction)
                if (cTemp instanceof CarreauTirage){
                    CarreauTirage c = (CarreauTirage) cTemp;
                    c.tirerCarte();
                }
                else if (cTemp instanceof CarreauArgent){
                    CarreauArgent c = (CarreauArgent) cTemp;
                    if (cTemp.getNumero() != 1){
                        this.removeCash(c.getMontant() * -1);
                    }
                } else { //(cTemp instanceof CarreauMouvement)
                    this.allerPrison();
                }
                
            }
        }
        
        public void allerPrison() {
            this.setPositionCourante(monopoly.getCarreau(11)); // 11 = position de la prison
            this.setDrapeauPrison(true);
            this.monopoly.getInter().afficherAllerPrison();
        }
        
        public void reculer(int nbcases) {
            if (getPositionCourante().getNumero()-nbcases < 1) {
                this.setPositionCourante(monopoly.getCarreau(getPositionCourante().getNumero() - nbcases + 40));
            } else {
                this.setPositionCourante(monopoly.getCarreau(getPositionCourante().getNumero() - nbcases));
            }
        }
        
        public void avancerCarte(int numcase){ // Méthode appelée exclusivement par une Carte (Chance ou Caisse)
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
        
        public boolean peutConstruire(){
            Carreau c = this.getPositionCourante();
            if (c instanceof ProprieteAConstruire){
                ProprieteAConstruire propriete = (ProprieteAConstruire) c;
                Groupe g = propriete.getGroupePropriete();
                return g.groupePossede(this);
            }
            return false;
        }
        
        /**
         * Lance la procédure de construction
         * (nécessite que peutConstruire soit vrai)
         */
        public void construire(){
            ProprieteAConstruire propriete = (ProprieteAConstruire) this.getPositionCourante();
            Groupe groupe = propriete.getGroupePropriete();
            ArrayList<ProprieteAConstruire> proprietes = groupe.getProprietes();
            ArrayList<ProprieteAConstruire> proprietesConstructible = new ArrayList<>();
            int nbrMaisonsConstruitesTotales = groupe.nbrMaisonsConstruites();
            int nbrHotelsConstruitsTotals = groupe.nbrHotelsConstruits();
            boolean choix = true;
            int choixTerrainOuConstruire;
            
            // TANT QUE le joueur n'a pas construit toute les maisons qu'il faut
            // Que la banque à encore des maisons
            // Que le joueur a assez d'argent
            // Et qu'il a dis oui pour construire une maison précédemment
            while (nbrMaisonsConstruitesTotales < proprietes.size()*4 &  nbrHotelsConstruitsTotals == 0
                    & getMonopoly().getNbMaisons() > 0
                    & this.getCash() > groupe.getPrixAchatMaison()
                    & choix){
                
                // On demande si il veut construire une maison
                getMonopoly().getInter().afficherArgentJoueur(this);
                choix = getMonopoly().getInter().proposerConstruction(groupe.getPrixAchatMaison(), "une maison");
                
                // Si il est d'accord
                if (choix) {
                    proprietesConstructible.clear();
                    for (ProprieteAConstruire prop : proprietes){
                        // On récupère les proprietes qui ont un nombre de maison inférieur à la moyenne
                        if (((float) nbrMaisonsConstruitesTotales / (float) proprietes.size()) >= (float) prop.getNbMaisons()){
                            proprietesConstructible.add(prop);
                        }
                    }
                    // On lui affiche où il peut construire
                    choixTerrainOuConstruire = getMonopoly().getInter().demandeTerrainOuConstruire(proprietesConstructible);
                    // On construit la maison
                    proprietesConstructible.get(choixTerrainOuConstruire).construireMaison();
                    // On enleve une maison du monopoly
                    getMonopoly().enleveMaison();
                }
                
                // On modifie les variables à vérifier pour le prochain début de boucle
                nbrMaisonsConstruitesTotales = groupe.nbrMaisonsConstruites();
            }
            // FIN PARTIE MAISON
            
            choix = true;
            // DEBUT PARTIE HOTEL
            // TANT QUE le a 4 maisons sur chaque propriétés
            // OU que le nombre total d'hotel construit est compris entre 0 et
            // le nombre de terrain dans le groupe
            // ET Que la banque à encore des hotels
            // ET Que le joueur a assez d'argent
            // Et qu'il a dis oui pour construire un hotel précédemment
            while (((nbrMaisonsConstruitesTotales == proprietes.size()*4) 
                    | (nbrHotelsConstruitsTotals > 0 & nbrHotelsConstruitsTotals < proprietes.size()))
                    & getMonopoly().getNbHotels() > 0
                    & this.getCash() > groupe.getPrixAchatHotel()
                    & choix){
                
                // On demande si il veut construire une maison
                getMonopoly().getInter().afficherArgentJoueur(this);
                choix = getMonopoly().getInter().proposerConstruction(groupe.getPrixAchatMaison(), "un hotel");
                
                // Si il est d'accord
                if (choix) {
                    proprietesConstructible.clear();
                    for (ProprieteAConstruire prop : proprietes){
                        // On récupère les proprietes qui ont un nombre de maison inférieur à la moyenne
                        if (prop.getNbHotel() == 0){
                            proprietesConstructible.add(prop);
                        }
                    }
                    // On lui affiche où il peut construire
                    choixTerrainOuConstruire = getMonopoly().getInter().demandeTerrainOuConstruire(proprietesConstructible);
                    // On construit l'hotel
                    proprietesConstructible.get(choixTerrainOuConstruire).construireHotel();
                    // On enleve un hotel du monopoly
                    getMonopoly().enleveHotel();
                }
                // On modifie les variables à vérifier pour le prochain début de boucle
                nbrHotelsConstruitsTotals = groupe.nbrHotelsConstruits();
            }
            
            
            
            
            
        }
}
