package Jeu;

public class CarreauArgent extends CarreauAction {
	private int montant;

    public CarreauArgent(int numero, String nomCarreau, Monopoly monopoly, int montant) {
        super(numero, nomCarreau, monopoly);
        setMontant(montant);
    }

        @Override
    public int getMontant() {
        return montant;
    }

        @Override
    public void setMontant(int montant) {
        this.montant = montant;
    }  
}