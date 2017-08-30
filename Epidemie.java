package model;

public class Epidemie {
	private String nom;
	private double infectuosite;
	private double letalite;
	
	public final static double MAX_INFECT = 0.3;
	
	//Class comportement epidemie, caractéristiques épidémie, clonage
	public Epidemie(String nom) {
		this.nom = nom;
		this.infectuosite = 1.0;
		this.letalite = 0;
	}
	
	public double getInfectuosite() {
		return infectuosite;
	}
	
	public double getLetalite() {
		return letalite;
	}
	
}
