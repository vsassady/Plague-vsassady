package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Population {
	private int nombreHabitants;
	private IntegerProperty sain;
	private IntegerProperty infecté;	
	private IntegerProperty mort;
	
	public Population(int nombreHabitants){
		this.nombreHabitants = nombreHabitants;
		this.sain = new SimpleIntegerProperty(nombreHabitants);
		this.infecté = new SimpleIntegerProperty(0);
		this.mort = new SimpleIntegerProperty(0);
	}
	
	public int getNombreHabitants(){
		return this.nombreHabitants;
	}
	
	public IntegerProperty getSain() {
		return sain;
	}
	
	public void setSain(int sain) {
		this.sain.setValue(sain);
	}
	
	public IntegerProperty getInfecté() {
		return infecté;
	}

	public void setInfecté(int infecté) {
		this.infecté.setValue(infecté);
	}
	
	public IntegerProperty getMort() {
		return mort;
	}
	
	public void setMort(int mort) {
		this.mort.setValue(mort);;
	}
	
	
	
	public String toString(){
		return "" + this.sain + "   Nombre infectés: " + this.infecté + "    Nombre morts : " + this.mort;
	}
}
