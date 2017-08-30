package model;
import java.util.ArrayList;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;

public class Monde {

	private long nbHabitantsBase = 0;
	private LongProperty nbHabitantsSains;
	private LongProperty nbHabitantsInfect�s;
	private LongProperty nbHabitantsMorts;
	
	private IntegerProperty aDN;
	
	public Monde(ArrayList<Pays> listePays){
		nbHabitantsMorts = new SimpleLongProperty(0);
		nbHabitantsSains = new SimpleLongProperty();
		nbHabitantsInfect�s = new SimpleLongProperty(0);
		aDN = new SimpleIntegerProperty(1);
		
		for(int i = 0; i < listePays.size(); i ++){
			nbHabitantsBase += listePays.get(i).getPopulation().getNombreHabitants();
		}
		nbHabitantsSains.setValue(nbHabitantsBase);
	}
	
	public void majValeursMonde(ArrayList<Pays> listePaysInfect�s){
		nbHabitantsInfect�s.setValue(0);
		for(int i = 0; i < listePaysInfect�s.size(); i ++){
			nbHabitantsInfect�s.setValue(nbHabitantsInfect�s.get()+listePaysInfect�s.get(i).getPopulation().getInfect�().get());
		}
		nbHabitantsSains.setValue(nbHabitantsBase-nbHabitantsInfect�s.get());
		nbHabitantsMorts.setValue(nbHabitantsBase-nbHabitantsInfect�s.get() - nbHabitantsSains.get());
	}
	
	public LongProperty getNbHabitantsInfect�s() {
		return nbHabitantsInfect�s;
	}
	
	public LongProperty getNbHabitantsMorts() {
		return nbHabitantsMorts;
	}
	
	public LongProperty getNbHabitantsSains() {
		return nbHabitantsSains;
	}
	
	public long getNbHabitantsBase(){
		return nbHabitantsBase;
	}
	
	public IntegerProperty getADN(){
		return aDN;
	}
}
