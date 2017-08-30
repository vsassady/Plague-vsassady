package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.sun.prism.paint.Color;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Jeu {
	
	private Carte carteDuMonde;
	private Epidemie epidemie;
	
	private int tourDeBoucle = 0;
	
	private Date date;
	private Timeline gameLoop;
	
	private ImageView carteRouge;
	
	public Jeu(ImageView carteRouge) {
		this.carteDuMonde = new Carte();
		this.epidemie = new Epidemie("H1Z1");
		this.date = new Date();
		this.carteRouge = carteRouge;
	}

	public Carte getCarteDuMonde() {
		return carteDuMonde;
	}
	
	public Date getDate(){
		return this.date;
	}
	
	public void lancerJeu(Pays pays){
		
		gameLoop = new Timeline();
		gameLoop.setCycleCount(Timeline.INDEFINITE);
		infecterPays(pays);
		carteDuMonde.getMonde().majValeursMonde(carteDuMonde.getListeInfect�s());
		KeyFrame kf = new KeyFrame(Duration.seconds(1.5), (ev ->{
			date.augmenter();
			if(tourDeBoucle %6 == 0)
				carteDuMonde.getMonde().getADN().setValue(carteDuMonde.getMonde().getADN().get()+1);
			for (int i = 0; i < carteDuMonde.getListeInfect�s().size(); i++){
				propagation(carteDuMonde.getListeInfect�s().get(i));				
			}
			carteDuMonde.getMonde().majValeursMonde(carteDuMonde.getListeInfect�s());
			changement();
			tourDeBoucle++;
		}));
		gameLoop.getKeyFrames().add(kf);
		gameLoop.play();
	}
	
	
	public void infecterPays(Pays pays){
		pays.getPopulation().setInfect�(2);
		pays.getPopulation().setSain(pays.getPopulation().getNombreHabitants()-2);
		carteDuMonde.addPaysInfectes(pays);
		carteDuMonde.getMonde().getADN().setValue(carteDuMonde.getMonde().getADN().get()+3);
	}
	
	public void propagation(Pays pays){
		if(carteDuMonde.getListeInfect�s().contains(pays)){
			//INFECTION DU MEME PAYS
			/*double infectRand;
			infectRand = (Math.random()*Epidemie.MAX_INFECT) + this.epidemie.getInfectuosite();
			pays.getPopulation().setInfect�((int)Math.round(pays.getPopulation().getInfect�().get()*infectRand));*/
			
			pays.getPopulation().setInfect�(pays.getPopulation().getInfect�().get() + pays.getPopulation().getNombreHabitants()/3);
		
			if(pays.getPopulation().getInfect�().get() >pays.getPopulation().getSain().get()){
				pays.getPopulation().setInfect�(pays.getPopulation().getNombreHabitants());
				pays.getPopulation().setSain(0);
			}
			else{
				pays.getPopulation().setSain(pays.getPopulation().getNombreHabitants() - pays.getPopulation().getInfect�().get());
			}
			
			//INFECTION DES VOISINS
			// Param�tres �pid�mie..%infect�s, vitesse de propagation suite, n=n+1, n^p..
			//Fronti�res, proba..Nombre de voyageurs infect�s..
			if(pays.getPaysVoisins().size() > 0){
				for(int i = 0 ; i < pays.getPaysVoisins().size() ; i++){
					if(pays.getPopulation().getInfect�().get() / pays.getPopulation().getNombreHabitants() > 0.5 && pays.getPaysVoisins().get(i).getPopulation().getInfect�().get() == 0 ){
						if(Math.random() >= 0.6){
							infecterPays(pays.getPaysVoisins().get(i));
							System.out.println("pays inf�ct� !");
						}	
					}
				}
			}
		}	
	}
	public void changement(){
		carteRouge.setOpacity((double)carteDuMonde.getMonde().getNbHabitantsInfect�s().get()/(double)carteDuMonde.getMonde().getNbHabitantsBase());
	}
}
