package Jeu;

public abstract class CarteChance extends Carte {
	private CarteChanceEnum action;
        
        
        public void actionAEffectuer (CarteChanceEnum action){
            Joueur joueur = this.getMonopoly().getCurrentPlayer();
            switch(action){
                case libere_prison:
                    break;
                case payez_reparations_voirie:
                    payezReparationsVoirie(joueur);
                    break;
                case payez_reparations_maison:
                    payezReparationsMaison(joueur);
                    break;
                case payez_amende_vitesse:
                    payezAmendeVitesse(joueur);
                    break;
                case payez_amende_ivresse:
                    payezAmendeIvresse(joueur);
                    break;
                case payez_scolarite:
                    payezScolarite(joueur);
                    break;
                case recevez_prix_mots_croises:
                    recevezPrixMotsCroises(joueur);
                    break;
                case recevez_banque_dividende:
                    recevezBanqueDividende(joueur);
                    break;
                case recevez_immeuble_prêt:
                    recevezImmeublePret(joueur);
                    break;
                case allez_prison:
                    allezPrison(joueur);
                    break;
                case reculez_3cases:
                    reculez3Cases(joueur);
                    break;
                case avancez_depart:
                    avancezDepart();
                    break;
                case avancez_rue_paix:
                    avancezRuePaix();
                    break;
                case avancez_henri_martin:
                    avancezHenriMartin();
                    break;
                case avancez_gare_lyon:
                    avancezGareLyon();
                    break;
                case avancez_boulevard_villette:
                    avancezBoulevardVillette();
                    break;
                default:
            }
        }
        
        public void payezReparationsVoirie(Joueur joueur){
            int i = (joueur.getNbMaisons()*40);
            i += (joueur.getNbHotels()*115);
            joueur.removeCash(i);
        }
        public void payezReparationsMaison(Joueur joueur){
            int i = (joueur.getNbMaisons()*25);
            i += (joueur.getNbHotels()*100);
            joueur.removeCash(i);
        }
        public void payezAmendeVitesse(Joueur joueur){
            joueur.removeCash(15);
        }
        public void payezAmendeIvresse(Joueur joueur){
            joueur.removeCash(20);
        }
        public void payezScolarite(Joueur joueur){
            joueur.removeCash(150);
        }
        public void recevezPrixMotsCroises(Joueur joueur){
            joueur.addCash(100);
        }
        public void recevezBanqueDividende(Joueur joueur){
            joueur.addCash(50);
        }
        public void recevezImmeublePret(Joueur joueur){
            joueur.addCash(150);
        }
        public void allezPrison(Joueur joueur){
            joueur.allerPrison();
        }
        public void reculez3Cases(Joueur joueur){
            joueur.reculer(3);
        }
        public void avancezDepart(){
            avancerCarte(1);
        }
        public void avancezRuePaix(){
            avancerCarte(40);
        }
        public void avancezHenriMartin(){
            avancerCarte(25);
        }
        public void avancezGareLyon(){
            avancerCarte(16);
        }
        public void avancezBoulevardVillette(){
            avancerCarte(12);
        }
}