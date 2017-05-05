package tk.ap17.app.autoconcept.models;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class Orm {
	/**
	 * Select generique sur la bdd MySql
	 */
	public Map select (List<String> colums){

		return Map<String,String>;
	}

	/**
	 * Insérrer des champs
	 */
	public boolean insert(Map<String, String> value) {

		return true;
	}

	/**
	 * Modifier des champs
	 */
	public boolean update(Map<String, String> value) {

		return true;
	}

	/**
	 * Supprimer des champs
	 */
	public boolean delete(Map<String, String> value) {

		return true;
	}

	/**
	 * Récupérer une table
	 */
	public String getTable() {

		return "";
	}

	/**
	 * Collection de tables unique
	 * 
	 * @param name
	 */
	public List setTable(String name) {

		return;
	}

	/**
	 * Récuperer une colonne 
	 */
	public List getColums() {

		return
	}

	/**
	 * Collection de colonnes unique
	 */
	public List setColums() {

		return
	}
}
