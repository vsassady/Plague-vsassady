package model;

import java.util.ArrayList;

public class Pays {
	
	private String nomPays;
	private ArrayList<Aeroport> listeAeroport;
	private ArrayList<Pays> paysVoisins;
	private Population population;
	private String couleurPays;
	/**
	 * Pour indiquer si un pays est chaud/froid/tempéré, urbain/rural/les deux, riche/pauvre/moyen, aride/humide/normal
	 * habitant sain/infecté/mort
	 */
	public final static int BAS = 0;
	public final static int MOYEN = 1;
	public final static int HAUT = 2;
	
	private int temperature;
	private int milieu;
	private int richesse;
	private int climat;
	
	
	
	public Pays(String nomPays, ArrayList<Aeroport> listeAeroport, int richesse, int milieu, int temperature, int climat, String couleurPays, Population population){
		this.nomPays = nomPays;
		this.listeAeroport = listeAeroport;
		this.temperature = temperature;
		this.milieu = milieu;
		this.richesse = richesse;
		this.climat = climat;
		this.couleurPays = couleurPays;
		this.population = population;
		this.paysVoisins = new ArrayList<Pays>();
	}
	
	public void ajouterPaysVoisin(Pays pays){
		this.paysVoisins.add(pays);
	}
	
	public ArrayList<Pays> getPaysVoisins() {
		return paysVoisins;
	}
	
	public String getNomPays(){
		return this.nomPays;
	}
	
	public String getColorPays(){
		return this.couleurPays;
	}
	
	public String getRichessePaysString(){
		if(richesse == 0)
			return "Pauvre";
		else if (richesse == 1)
			return "Riche";
		else
			return "Moyen";
	}
	
	public String getMilieuString(){
		if(milieu == 0)
			return "Rural";
		else if(milieu == 1)
			return "Urbain";
		else
			return "Les Deux";
	}
	
	public String getTemperatureString(){
		if(temperature == 0)
			return "Froid";
		else  if(temperature == 1)
			return "Chaud";
		else 
			return "Ambiant";
	}
	
	public String getClimatString(){
		if(climat == 0)
			return "Humide";
		else if(climat == 1)
			return "Aride";
		else 
			return "Tempéré";
			
	}
	
	public Population getPopulation(){
		return this.population;
	}
		
	public String toString(){
		return this.nomPays + ",  Richesse: " + this.getRichessePaysString() + ",  Milieu: " + this.getMilieuString() + ",  Température: " + this.getTemperatureString() + ",  Climat: " + this.getClimatString();
	}
	
	
}
