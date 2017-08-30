package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LecturePays {
	
	public static void lirePays(String [][]tableau){
		try
		{
		    File file = new File("src/view/ListePays");
		    FileReader fileReader = new FileReader (file);
		    BufferedReader buffer = new BufferedReader (fileReader);
		 
		    try
		    {
		        String line;
		        for(int i=0; i < 58; i ++){		            
		        	line = buffer.readLine();
		        	tableau[i] = line.split(";");
		        }

		        buffer.close();
		        fileReader.close();
		    }
		    catch (IOException exception)
		    {
		        System.out.println ("Erreur lors de la lecture : " + exception.getMessage());
		    }
		}
		catch (FileNotFoundException exception)
		{
		    System.out.println ("Le fichier n'a pas été trouvé");
		}
	}
	
	public static void lireLiaisons(ArrayList<Pays> listePays){
		try
		{
		    File file = new File("src/ressources/Liaisons");
		    FileReader fileReader = new FileReader (file);
		    BufferedReader buffer = new BufferedReader (fileReader);
		 
		    try
		    {
		        String line;
		        String lineSplited[];
		        for(int i=0; i < 58; i ++){		            
		        	line = buffer.readLine(); 
		        	lineSplited = line.split(";");
		        	if(lineSplited.length > 1){
		        		for(int j = 1 ; j < lineSplited.length ; j++){
		        			listePays.get(i).ajouterPaysVoisin(returnPaysAddr(lineSplited[j], listePays));
		        		}
		        	}
		        	
		        }

		        buffer.close();
		        fileReader.close();
		    }
		    catch (IOException exception)
		    {
		        System.out.println ("Erreur lors de la lecture : " + exception.getMessage());
		    } 
		}
		catch (FileNotFoundException exception)
		{
		    System.out.println ("Le fichier n'a pas été trouvé");
		}
	}
	
	public static Pays returnPaysAddr(String nomPays, ArrayList<Pays> listePays){
		for(int i= 0; i< listePays.size(); i++){
			if(nomPays.equals(listePays.get(i).getNomPays()))
				return listePays.get(i);
		}
		return null;
		
	}
	
	
}
	
	
	

