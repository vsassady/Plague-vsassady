package controller;

import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import model.Jeu;
import model.Pays;

public class MainController implements Initializable {
	
	@FXML
	private Text infosPays;
	
	@FXML
	private Label aDN;
	
	@FXML
	private Button jouer;
		
	@FXML 
	private Label sain;
	
	@FXML
	private Label infectés;
	
	@FXML 
	private Label morts;
	
	@FXML
	private ImageView a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, a21, a22, a23;
	
	@FXML 
	private Text date;
	
	private Pays paysSelect = null;
	
	@FXML
	private ImageView carteRouge = new ImageView("/ressources/CarteRouge.png");
	
	
	private Jeu jeu;

	@Override
	public void initialize(java.net.URL location, ResourceBundle resources) {
		this.jeu = new Jeu(carteRouge);		
	}
	
	public void getInfosPaysController(MouseEvent e) {
		paysSelect = this.jeu.getCarteDuMonde().getInfosDuPays(e);
		if(paysSelect != null){
			infosPays.textProperty().setValue(paysSelect.toString());
			sain.textProperty().bind(paysSelect.getPopulation().getSain().asString());
			infectés.textProperty().bind(paysSelect.getPopulation().getInfecté().asString());
			morts.textProperty().bind(paysSelect.getPopulation().getMort().asString());
		}
		else{
			infosPays.textProperty().setValue("Monde");
			sain.textProperty().bind(jeu.getCarteDuMonde().getMonde().getNbHabitantsSains().asString());
			infectés.textProperty().bind(jeu.getCarteDuMonde().getMonde().getNbHabitantsInfectés().asString());
			morts.textProperty().bind(jeu.getCarteDuMonde().getMonde().getNbHabitantsMorts().asString());
		}
	}
	
	public void lancerJeu(MouseEvent e) {
		if (paysSelect != null){
			jeu.lancerJeu(paysSelect);
			jouer.setDisable(true);
			aDN.textProperty().bind(jeu.getCarteDuMonde().getMonde().getADN().asString());
			date.textProperty().bind(jeu.getDate().toStringProperty());
			
			
		}
	}
	
}
