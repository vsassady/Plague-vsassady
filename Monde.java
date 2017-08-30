package model;
import java.util.ArrayList;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;

public class Monde {

	private long nbHabitantsBase = 0;
	private LongProperty nbHabitantsSains;
	private LongProperty nbHabitantsInfectés;
	private LongProperty nbHabitantsMorts;
	
	private IntegerProperty aDN;
	
	public Monde(ArrayList<Pays> listePays){
		nbHabitantsMorts = new SimpleLongProperty(0);
		nbHabitantsSains = new SimpleLongProperty();
		nbHabitantsInfectés = new SimpleLongProperty(0);
		aDN = new SimpleIntegerProperty(1);
		
		for(int i = 0; i < listePays.size(); i ++){
			nbHabitantsBase += listePays.get(i).getPopulation().getNombreHabitants();
		}
		nbHabitantsSains.setValue(nbHabitantsBase);
	}
	
	public void majValeursMonde(ArrayList<Pays> listePaysInfectés){
		nbHabitantsInfectés.setValue(0);
		for(int i = 0; i < listePaysInfectés.size(); i ++){
			nbHabitantsInfectés.setValue(nbHabitantsInfectés.get()+listePaysInfectés.get(i).getPopulation().getInfecté().get());
		}
		nbHabitantsSains.setValue(nbHabitantsBase-nbHabitantsInfectés.get());
		nbHabitantsMorts.setValue(nbHabitantsBase-nbHabitantsInfectés.get() - nbHabitantsSains.get());
	}
	
	public LongProperty getNbHabitantsInfectés() {
		return nbHabitantsInfectés;
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
