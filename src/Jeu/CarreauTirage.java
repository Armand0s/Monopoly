package Jeu;

import static Jeu.CarteChanceEnum.libere_prison;
import static Jeu.CarteCaisseEnum.libere_prison;

public class CarreauTirage extends CarreauAction {

    public CarreauTirage(int numero, String nomCarreau, Monopoly monopoly) {
        super(numero, nomCarreau, monopoly);
    }
    
    public void tirerCarte(){
        if (this.getNomCarreau() == "Caisse de Communauté"){
            CarteCaisse carteATirer = this.getMonopoly().getCarteCaisses().pollFirst();
            carteATirer.actionAEffectuer();
            if (carteATirer.getAction() != CarteCaisseEnum.libere_prison){
                this.getMonopoly().getCarteCaisses().add(carteATirer);
            }
            else {
                this.getMonopoly().getCurrentPlayer().setCarteCaisseLibere(true);
            }
        }
        else {
            CarteChance carteATirer = this.getMonopoly().getCarteChances().pollFirst();
            carteATirer.actionAEffectuer();
            if (carteATirer.getAction() != CarteChanceEnum.libere_prison){
                this.getMonopoly().getCarteChances().add(carteATirer);
            }
            else {
                this.getMonopoly().getCurrentPlayer().setCarteChanceLibere(true);
            }
        }
    }
    
}