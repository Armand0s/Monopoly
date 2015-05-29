package Jeu;

public abstract class CarreauAction extends Carreau {

    public CarreauAction(int numero, String nomCarreau, Monopoly monopoly) {
        super(numero, nomCarreau, monopoly);
    }
    
    @Override
    public void setMontant(int montant) {
            
        }
        
    @Override
        public int getMontant() {
            return 0;
        }
    
}