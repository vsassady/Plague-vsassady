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
		carteDuMonde.getMonde().majValeursMonde(carteDuMonde.getListeInfectés());
		KeyFrame kf = new KeyFrame(Duration.seconds(1.5), (ev ->{
			date.augmenter();
			if(tourDeBoucle %6 == 0)
				carteDuMonde.getMonde().getADN().setValue(carteDuMonde.getMonde().getADN().get()+1);
			for (int i = 0; i < carteDuMonde.getListeInfectés().size(); i++){
				propagation(carteDuMonde.getListeInfectés().get(i));				
			}
			carteDuMonde.getMonde().majValeursMonde(carteDuMonde.getListeInfectés());
			changement();
			tourDeBoucle++;
		}));
		gameLoop.getKeyFrames().add(kf);
		gameLoop.play();
	}
	
	
	public void infecterPays(Pays pays){
		pays.getPopulation().setInfecté(2);
		pays.getPopulation().setSain(pays.getPopulation().getNombreHabitants()-2);
		carteDuMonde.addPaysInfectes(pays);
		carteDuMonde.getMonde().getADN().setValue(carteDuMonde.getMonde().getADN().get()+3);
	}
	
	public void propagation(Pays pays){
		if(carteDuMonde.getListeInfectés().contains(pays)){
			//INFECTION DU MEME PAYS
			/*double infectRand;
			infectRand = (Math.random()*Epidemie.MAX_INFECT) + this.epidemie.getInfectuosite();
			pays.getPopulation().setInfecté((int)Math.round(pays.getPopulation().getInfecté().get()*infectRand));*/
			
			pays.getPopulation().setInfecté(pays.getPopulation().getInfecté().get() + pays.getPopulation().getNombreHabitants()/3);
		
			if(pays.getPopulation().getInfecté().get() >pays.getPopulation().getSain().get()){
				pays.getPopulation().setInfecté(pays.getPopulation().getNombreHabitants());
				pays.getPopulation().setSain(0);
			}
			else{
				pays.getPopulation().setSain(pays.getPopulation().getNombreHabitants() - pays.getPopulation().getInfecté().get());
			}
			
			//INFECTION DES VOISINS
			// Paramètres épidémie..%infectés, vitesse de propagation suite, n=n+1, n^p..
			//Frontières, proba..Nombre de voyageurs infectés..
			if(pays.getPaysVoisins().size() > 0){
				for(int i = 0 ; i < pays.getPaysVoisins().size() ; i++){
					if(pays.getPopulation().getInfecté().get() / pays.getPopulation().getNombreHabitants() > 0.5 && pays.getPaysVoisins().get(i).getPopulation().getInfecté().get() == 0 ){
						if(Math.random() >= 0.6){
							infecterPays(pays.getPaysVoisins().get(i));
							System.out.println("pays infécté !");
						}	
					}
				}
			}
		}	
	}
	public void changement(){
		carteRouge.setOpacity((double)carteDuMonde.getMonde().getNbHabitantsInfectés().get()/(double)carteDuMonde.getMonde().getNbHabitantsBase());
	}
}
