package fr.but.info.sae.Weapons;

import java.util.ArrayList;

import fr.but.info.sae.Coordinates;

public class WoodenSword{
	private final int EnergyCost;
	private final int DamageDealt;
	private ArrayList<Coordinates> list;

	public WoodenSword() {
		EnergyCost = 1;
		DamageDealt = 7;
	}	

	public String toString() {
		return "Cout energie : " + EnergyCost + ", dommage inflige : " + DamageDealt;
	}
	
	public ArrayList<Coordinates> area() {
		this.list = new ArrayList<>();
		var matrix = new char[3][1];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				list.add(new Coordinates(i, j));
			}
		}
		return list;
	}
	
	public ArrayList<Coordinates> rotate() {
		this.list = new ArrayList<>();
		var matrix = new char[1][3];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				list.add(new Coordinates(i, j));
			}
		}
		return list;
	}
	
	
	public boolean isPlaceable(Coordinates[][] inventory, int i, int j) {
		for (var coor : list) {
			if ( coor.i() + i >= inventory.length || coor.j() + j >= inventory[0].length ) {
				return false;
			}
		}
		return true;
	}
	
	public void place(Object[][] inventory, int i, int j) {
		for (var coor : list) {
			inventory[coor.i()+i][coor.j()+j] = "W";
		}
	}

}
