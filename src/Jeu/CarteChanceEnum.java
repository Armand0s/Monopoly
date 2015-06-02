/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jeu;


public enum CarteChanceEnum {
    libere_prison("Vous êtes libéré de prison. Cette carte peut êtr econservée jusqu'à ce qu'elle soit utilisée."),
    payez_reparations_voirie("Vous êtes imposé pour les réparations de voirie à raison de : 40€ par maison et 115€ par hôtel."),  
    payez_reparations_maison("Faites des réparations dans toutes vos maisons : versez pour chaque maison 25€ et pour chaque hôtel 100€."),
    payez_amende_vitesse("Amende pour excès de vitesse : 15€."),
    payez_amende_ivresse("Amende pour ivresse : 20€."), 
    payez_scolarite("Payez pour frais de scolarité : 150€."), 
    recevez_prix_mots_croises("Vous avez gagné le prix de mots croisés. Recevez 100€"),
    recevez_banque_dividende("La Banque vous verse un dividende de 50€."),   
    recevez_immeuble_prêt("Votre immeuble et votre prêt rapportent. Vous devez toucher 150€."),
    allez_prison("Allez en prison. Avancez tout droit en prison. Ne passez pas par la case Départ. Ne touchez pas 200€."),   
    reculez_3cases("Reculez de trois cases."),
    avancez_depart("Avancez jusqu'à la case Départ."),
    avancez_rue_paix("Rendez-vous à la rue de la Paix."),
    avancez_henri_martin("Rendez-vous à l'avenue Henri-Martin. Si vous passez par la case Départ, recevez 200€."),
    avancez_gare_lyon("Allez à la gare de Lyon. Si vous passez par la case Départ, recevez 200€."),
    avancez_boulevard_villette("Accédez au Boulevard de la Villette. Si vous passez par la case Départ, recevez 200€.");
    
    private final String libelle;
    
    private CarteChanceEnum(String libelle){
        this.libelle = libelle;
    }
    
    public String toString() {return this.libelle;}
}
