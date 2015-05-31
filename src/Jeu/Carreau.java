package Jeu;

public abstract class Carreau {
	private int numero;
	private String nomCarreau;
        private Monopoly monopoly;
        
        public Carreau(int numero, String nom, Monopoly monopoly){
            setNumero(numero);
            setNomCarreau(nom);
            setMonopoly(monopoly);
        }
        
        public int getNumero() {
            return numero;
        }
        public void setNumero(int numero) {
            this.numero = numero;
        }

        public String getNomCarreau() {
            return nomCarreau;
        }
        public void setNomCarreau(String nomCarreau) {
            this.nomCarreau = nomCarreau;
        }

        public Monopoly getMonopoly() {
            return monopoly;
        }
        public void setMonopoly(Monopoly monopoly) {
            this.monopoly = monopoly;
        }
        
        
}