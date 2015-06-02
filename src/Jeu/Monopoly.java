package Jeu;

import UI.Interface;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;

public class Monopoly {
	private int nbMaisons = 32;
	private int nbHotels = 12;
	private ArrayList<Joueur> joueurs = new ArrayList<Joueur>();
	public  Interface inter;
        private ArrayList<Groupe> groupes = new ArrayList();
        private HashMap<Integer, Carreau> carreaux;
        private int numJoueur;
        private LinkedList<CarteChance> carteChances = new LinkedList<>();
        private LinkedList<CarteCaisse> carteCaisses = new LinkedList<>();

        public Monopoly(String dataFilename){
            
                carreaux = new HashMap<>();    
                initGroupe();
		buildGamePlateau(dataFilename);
	}
        
    public int lancerDe() {
        Random jet = new Random();
        int valDe = jet.nextInt(5)+1;
        
        return valDe;
    }
    
    public int lancerDes(){
        int de1;
        int de2;
        de1 = lancerDe();
        de2 = lancerDe();
        getCurrentPlayer().actionDouble(de1 == de2);
        inter.afficherLancerDe(de1,de2);
        return de1 + de2;
        
    }
    
    public void lancerDesEtAvancer(){
        Joueur joueur = this.getCurrentPlayer();
        int des;
        do {
            des = lancerDes();
            joueur.avancer(des);
            if (joueur.getNbDouble()==3){break;}
            //diverses actions
        }while (joueur.getDoubleDe());
        if (joueur.getNbDouble()==3){
            joueur.allerPrison();
        }
    }
    
    
    
    
    public void sortirPrison() {
        
    }
    
    
    
    
        
    public Joueur getCurrentPlayer() {
        return joueurs.get(numJoueur-1);
    }
    public void setCurrentPlayer(Joueur joueur) {
        numJoueur = (joueurs.indexOf(joueur))+1;
    }

    public int getNbMaisons() {
        return nbMaisons;
    }
    public void setNbMaisons(int nbMaisons) {
        this.nbMaisons = nbMaisons;
    }

    public int getNbHotels() {
        return nbHotels;
    }
    public void setNbHotels(int nbHotels) {
        this.nbHotels = nbHotels;
    }

    public ArrayList<Joueur> getJoueurs() {
        return joueurs;
    }
    public void setJoueurs(ArrayList<Joueur> joueurs) {
        this.joueurs = joueurs;
    }

    public Interface getInter() {
        return inter;
    }
    public void setInter(Interface inter) {
        this.inter = inter;
    }

    public ArrayList<Groupe> getGroupes() {
        return groupes;
    }
    public void setGroupes(ArrayList<Groupe> groupes) {
        this.groupes = groupes;
    }

    public HashMap<Integer, Carreau> getCarreaux() {
        return carreaux;
    }
    public void setCarreaux(HashMap<Integer, Carreau> carreaux) {
        this.carreaux = carreaux;
    }
	
    public Carreau getCarreau(int position){
        return carreaux.get(position);
    }
        private void addJoueur (Joueur joueur){
            joueurs.add(joueur);
        }
        
        public void nouveauJoueur(String nomJoueur){
            Joueur j = new Joueur(nomJoueur, getCarreau(1), this);
            addJoueur(j);
        }
        
        
        public void payer(Joueur payeur, Joueur receveur, int somme) {
            payeur.removeCash(somme);
            receveur.addCash(somme);
            
        }
        
        
        
        public void checkPerdu(Joueur joueur) {
            if (joueur.getCash() <= 0) {
                this.removeJoueur(joueur);
            }
        }
        
        
        public void removeJoueur(Joueur joueur) {
            this.getJoueurs().remove(joueur);
        }
        
        
        //////// Creation du plateau /////      
        
	private void buildGamePlateau(String dataFilename)
	{
		try{
			ArrayList<String[]> data = readDataFile(dataFilename, ",");
			
			//TODO: create cases instead of displaying
			for(int i=0; i<data.size(); ++i){
				String caseType = data.get(i)[0];
				if(caseType.compareTo("P") == 0){
                                    // Recupération des différentes variables
                                        int num = Integer.parseInt(data.get(i)[1]);
                                        String nomC = data.get(i)[2];
                                        Groupe grp = getGroupe(data.get(i)[3]);
                                        int prix = Integer.parseInt(data.get(i)[4]);
                                        int nu = Integer.parseInt(data.get(i)[5]);
                                        int mais1 = Integer.parseInt(data.get(i)[6]);
                                        int mais2 = Integer.parseInt(data.get(i)[7]);
                                        int mais3 = Integer.parseInt(data.get(i)[8]);
                                        int mais4 = Integer.parseInt(data.get(i)[9]);
                                        int hotel = Integer.parseInt(data.get(i)[10]);
                                        ArrayList<Integer> loyer = new ArrayList<>();
                                        loyer.add(nu);
                                        loyer.add(mais1);
                                        loyer.add(mais2);
                                        loyer.add(mais3);
                                        loyer.add(mais4);
                                        loyer.add(hotel);
                                        
                                        ProprieteAConstruire c = new ProprieteAConstruire(num,nomC,this,prix,loyer,grp);                                    
                                        carreaux.put(num,c);
				}
				else if(caseType.compareTo("G") == 0){
                                        int num = Integer.parseInt(data.get(i)[1]);
                                        String nomC = data.get(i)[2];
                                        int prix = Integer.parseInt(data.get(i)[3]);
                                        
                                        Gare c = new Gare(num,nomC,this,prix);
                                        carreaux.put(num,c);
				}
				else if(caseType.compareTo("C") == 0){
                                        int num = Integer.parseInt(data.get(i)[1]);
                                        String nomC = data.get(i)[2];
                                        int prix = Integer.parseInt(data.get(i)[3]);
                                        
                                        Compagnie c = new Compagnie(num,nomC,this,prix);
                                        carreaux.put(num,c);
				}
				else if(caseType.compareTo("CT") == 0){
                                        int num = Integer.parseInt(data.get(i)[1]);
                                        String nomC = data.get(i)[2];
                                        
                                        CarreauTirage c = new CarreauTirage(num,nomC,this);
                                        carreaux.put(num,c);
				}
				else if(caseType.compareTo("CA") == 0){
                                        int num = Integer.parseInt(data.get(i)[1]);
                                        String nomC = data.get(i)[2];
                                        int montant = Integer.parseInt(data.get(i)[3]);
                                        
                                        CarreauArgent c = new CarreauArgent(num,nomC,this,montant);
                                        carreaux.put(num,c);
				}
				else if(caseType.compareTo("CM") == 0){
                                        int num = Integer.parseInt(data.get(i)[1]);
                                        String nomC = data.get(i)[2];
                                        
                                        CarreauTirage c = new CarreauTirage(num,nomC,this);
                                        carreaux.put(num,c);
				}
				else
					System.err.println("[buildGamePleateau()] : Invalid Data type");
			}
			
		} 
		catch(FileNotFoundException e){
			System.err.println("[buildGamePlateau()] : File is not found!");
		}
		catch(IOException e){
			System.err.println("[buildGamePlateau()] : Error while reading file!");
		}
	}
        
        private void initGroupe(){
            Groupe bleuFonce = new Groupe(CouleurPropriete.bleuFonce, 200, 200);
            Groupe orange    = new Groupe(CouleurPropriete.orange, 100, 100);
            Groupe mauve     = new Groupe(CouleurPropriete.mauve, 50, 50);
            Groupe violet    = new Groupe(CouleurPropriete.violet, 100, 100);
            Groupe bleuCiel  = new Groupe(CouleurPropriete.bleuCiel, 50, 50);
            Groupe jaune     = new Groupe(CouleurPropriete.jaune, 150, 150);
            Groupe vert      = new Groupe(CouleurPropriete.vert, 200, 200);
            Groupe rouge     = new Groupe(CouleurPropriete.rouge, 150, 150);
            
            groupes.add(bleuFonce);
            groupes.add(orange);
            groupes.add(mauve);
            groupes.add(violet);
            groupes.add(bleuCiel);
            groupes.add(jaune);
            groupes.add(vert);
            groupes.add(rouge);
        }
        
        private Groupe getGroupe(String couleur){
            for (Groupe grp : groupes){
                if (grp.getCouleur().toString() == couleur){
                  return grp;
                }
            }
            return null;
        }
        
 /*       private void initCarte(){
            for (CarteCaisseEnum carteCaisse : CarteCaisseEnum.values()){
                carteCaisses.add(new CarteCaisse());
            }
            
            for (CarteChanceEnum carteChance : CarteChanceEnum.values()){
                carteChances.add(new CarteChances());
            }
        }
*/	
	private ArrayList<String[]> readDataFile(String filename, String token) throws FileNotFoundException, IOException
	{
		ArrayList<String[]> data = new ArrayList<String[]>();
		
		BufferedReader reader  = new BufferedReader(new FileReader(filename));
		String line = null;
		while((line = reader.readLine()) != null){
			data.add(line.split(token));
		}
		reader.close();
		
		return data;
	}
        
        
}
