package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Population {
	private int nombreHabitants;
	private IntegerProperty sain;
	private IntegerProperty infect�;	
	private IntegerProperty mort;
	
	public Population(int nombreHabitants){
		this.nombreHabitants = nombreHabitants;
		this.sain = new SimpleIntegerProperty(nombreHabitants);
		this.infect� = new SimpleIntegerProperty(0);
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
	
	public IntegerProperty getInfect�() {
		return infect�;
	}

	public void setInfect�(int infect�) {
		this.infect�.setValue(infect�);
	}
	
	public IntegerProperty getMort() {
		return mort;
	}
	
	public void setMort(int mort) {
		this.mort.setValue(mort);;
	}
	
	
	
	public String toString(){
		return "" + this.sain + "   Nombre infect�s: " + this.infect� + "    Nombre morts : " + this.mort;
	}
}
