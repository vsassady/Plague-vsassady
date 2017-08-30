package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Date {
	private IntegerProperty jour;
	private IntegerProperty mois;
	private IntegerProperty annee;	
	
	private StringProperty stp;
	

	public Date(){
		jour = new SimpleIntegerProperty(31);
		mois = new SimpleIntegerProperty(8);
		annee = new SimpleIntegerProperty(2017);
		stp = new SimpleStringProperty();
	}
	
	public void augmenter(){
		if(annee.get() % 4 != 0){
			if(mois.get() == 2){
				if(jour.get() == 28){
					jour.setValue(1);
					mois.set(mois.get()+1);
				}
				else
					jour.setValue(jour.get()+1);;
			}
			else if(mois.get() == 1 || mois.get() == 3 || mois.get() == 5 || mois.get() == 7 || mois.get() == 8 || mois.get() == 10 || mois.get() == 12){
				if(mois.get() == 12 && jour.get() == 31){
					mois.set(1);
					jour.set(1);
					annee.set(annee.get()+1);
				}
				else if(mois.get() != 12 && jour.get() == 31){
					mois.set(mois.get()+1);
					jour.set(1);
				}
				else{
					jour.set(jour.get()+1);
				}
			}
			else {
				if(jour.get() == 30){
					jour.set(1);
					mois.set(mois.get()+1);
				}
				else
					jour.set(jour.get()+1);
			}
				
		}
		else {
			if(mois.get() == 2){
				if(jour.get() == 29){
					jour.setValue(1);
					mois.set(mois.get()+1);
				}
				else
					jour.setValue(jour.get()+1);;
			}
			else if(mois.get() == 1 || mois.get() == 3 || mois.get() == 5 || mois.get() == 7 || mois.get() == 8 || mois.get() == 10 || mois.get() == 12){
				if(mois.get() == 12 && jour.get() == 31){
					mois.set(1);
					jour.set(1);
					annee.set(annee.get()+1);
				}
				else if(mois.get() != 12 && jour.get() == 31){
					mois.set(mois.get()+1);
					jour.set(1);
				}
				else{
					jour.set(jour.get()+1);
				}
			}
			else {
				if(jour.get() == 30){
					jour.set(1);
					mois.set(mois.get()+1);
				}
				else
					jour.set(jour.get()+1);
			}
				
		}
		
		stp.setValue(jour.get() + "-" + mois.get() + "-" + annee.get());
	}
	
	public IntegerProperty getJour() {
		return jour;
	}
	
	public IntegerProperty getMois() {
		return mois;
	}
	
	public IntegerProperty getAnnee() {
		return annee;
	}
	
	public StringProperty toStringProperty(){
		return stp;
	}
			
}
	
