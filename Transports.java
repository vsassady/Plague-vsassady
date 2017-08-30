package model;

public abstract class Transports {
	private boolean estOuvert;
	private double x;
	private double y;
	
	
	public Transports(){
		this.estOuvert();
	}
	
	public double getX(){
		return this.x;
	}
	
	public double getY(){
		return this.y;
	}
	
	public boolean estOuvert(){
		return estOuvert;
	}
}
