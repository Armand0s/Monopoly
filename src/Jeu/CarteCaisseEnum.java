/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jeu;


public enum CarteCaisseEnum {
    libere_prison("Vous êtes libéré de prison. Cette carte peut être conservée jusqu'à ce qu'elle soit utilisée."),
    payez_amende("Payez une amende de 10€."),
    payez_note_medecin("Payez la note du médecin : 50€."),
    payez_hopital("Payez à l'hôpital 100€."),
    payez_assurance("Payez votre police d'assurance : 50€."),
    recevez_anniversaire("C'est votre anniversaire. Chaque joueur doit vous donner 10€."),
    recevez_erreur_banque("Erreur de la banque en votre faveur. Recevez 200€."),
    recevez_contributions("Les contributions vous remboursent la somme de 20€"),
    recevez_heritage("Vous héritez : 100€."),
    recevez_vente_stock("La vente de votre stock vous rapport : 50€."),
    recevez_interet_emprunt("Recevez votre intérêt sur l'emprunt à 7% : 25€"),
    recevez_revenu_annuel("Recevez votre revenu annuel : 100€."),
    recevez_prix_beaute("Vous avez gagné le deuxième prix de beauté : recevez 10€."),
    allez_prison("Allez en prison. Avancez tout droit en prison. Ne passez pas par la case Départ. Ne recevez oas 200€."),
    reculez_belleville("Retournez à Belleville."),
    avancez_depart("Avancez jusqu'à la case Départ.");
    
    private final String libelle;
    
    private CarteCaisseEnum(String libelle){
        this.libelle = libelle;
    }
    
    public String toString() { return this.libelle;}
}
