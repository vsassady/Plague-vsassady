package model;

import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class Carte {
	private ArrayList<Pays> listePays;
	private ArrayList<Pays> listePaysInfectés;
	private String couleurPays;
	private Image carteDuMonde;

	private Monde monde;
	
	public static Pays premierPays = null;	
	
	public Carte(){
		carteDuMonde = new Image("/ressources/CarteCouleur2.png");
		this.listePays = new ArrayList<Pays>();
		this.listePaysInfectés = new ArrayList<Pays>();
		initialisation();
		monde = new Monde(listePays);
		
	}
	
	public Monde getMonde(){
		return monde;
	}
	
	public void initialisation(){
		
		String[][] tableauPays = new String[58][7];
		LecturePays.lirePays(tableauPays);
		for(int i=0; i < 58; i++){
			listePays.add(new Pays(tableauPays[i][0], null, Integer.parseInt(tableauPays[i][1]), Integer.parseInt(tableauPays[i][2]), Integer.parseInt(tableauPays[i][3]), Integer.parseInt(tableauPays[i][4]), (tableauPays[i][5]), new Population(Integer.parseInt(tableauPays[i][6]))));	
			
		}
		LecturePays.lireLiaisons(listePays);
	}
	
	
	
	public ArrayList<Pays> getListeInfectés(){
		return this.listePaysInfectés;
	}
	
	public void addPaysInfectes(Pays pays){
		this.listePaysInfectés.add(pays);
	}
	
	public void afficheListePays(){
		for (int i = 0; i < 57; i++){
			System.out.println(listePays.get(i));
		}
	}
	
	
	public Pays getInfosDuPays(MouseEvent e){
		String couleurPaysImage;
		
		
		couleurPays = (carteDuMonde.getPixelReader().getColor((int)e.getX(),(int)e.getY()).toString());
			for (int i = 0; i < listePays.size(); i++){
				couleurPaysImage = (listePays.get(i).getColorPays());
				System.out.println(couleurPays);
				
				if(couleurPaysImage.equals(couleurPays)){
					return listePays.get(i);
				}
			}
			return null;
	}
}