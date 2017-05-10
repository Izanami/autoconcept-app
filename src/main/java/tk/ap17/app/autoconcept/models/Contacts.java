package tk.ap17.app.autoconcept.models;

import java.time.LocalDate;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import tk.ap17.app.autoconcept.orm.Connector;
import tk.ap17.app.autoconcept.orm.Table;

public class Contacts extends Table<Contacts> {
	private StringProperty professionnel;
	private StringProperty adresse;
	private StringProperty ville;
	private IntegerProperty codePostal;
	private StringProperty nom;
	private StringProperty prenom;
	private StringProperty dateDeNaissance;
	private IntegerProperty sexe;
	private StringProperty courriel;
	private StringProperty telephone;
	private SimpleStringProperty anciennete;

	public Contacts(Connector connector) {
		super(connector);
		this.setNameTable("Contact");
		this.addColumn("nom");
	}

	/**
	 * Constructor with some initial data.
	 * 
	 * @param nom
	 * @param prenom
	 * @param dateDeNaissance
	 */
	public Contacts(Connector connector, String nom, String prenom, String dateDeNaissance) {
		super(connector);
		
		this.professionnel = new SimpleStringProperty("Professionnel");
		this.adresse = new SimpleStringProperty("7 rue du bois");
		this.ville = new SimpleStringProperty("Pau");
		this.codePostal = new SimpleIntegerProperty(64000);
		this.nom = new SimpleStringProperty(nom);
		this.prenom = new SimpleStringProperty(prenom);
		this.dateDeNaissance = new SimpleStringProperty(dateDeNaissance);
		this.sexe = new SimpleIntegerProperty(0);
		this.courriel = new SimpleStringProperty ("nom.prenom@exemple.com");
		this.telephone = new SimpleStringProperty("0102030405");
		this.anciennete = new SimpleStringProperty("12/04/1997");
	}

	public String getProfessionnel() {
		return professionnel.get();
	}

	public void setProfessionnel(String professionnel) {
		this.professionnel.set(professionnel);
	}

	public StringProperty professionnelProperty() {
		return professionnel;
	}

	public String getAdresse() {
		return adresse.get();
	}

	public void setAdresse(String adresse) {
		this.adresse.set(adresse);
	}

	public StringProperty adresseProperty() {
		return adresse;
	}

	public String getVille() {
		return ville.get();
	}

	public void setVille(String ville) {
		this.ville.set(ville);
	}

	public StringProperty villeProperty() {
		return ville;
	}

	public int getCodePostal() {
		return codePostal.get();
	}

	public void setCodePostal(int codePostal) {
		this.codePostal.set(codePostal);
	}

	public IntegerProperty codePostalProperty() {
		return codePostal;
	}

	public String getNom() {
		return nom.get();
	}

	public void setNom(String nom) {
		this.nom.set(nom);
	}

	public StringProperty nomProperty() {
		return nom;
	}

	public String getPrenom() {
		return prenom.get();
	}

	public void setPrenom(String prenom) {
		this.prenom.set(prenom);
	}

	public StringProperty prenomProperty() {
		return prenom;
	}

	public String getDateDeNaissance() {
		return dateDeNaissance.get();
	}

	public void setDateDeNaissance(String dateDeNaissance) {
		this.dateDeNaissance.set(dateDeNaissance);
	}

	public StringProperty dateDeNaissanceProperty() {
		return dateDeNaissance;
	}

	public int getSexe() {
		return sexe.get();
	}

	public void setSexe(int sexe) {
		this.sexe.set(sexe);
	}

	public IntegerProperty sexeProperty() {
		return sexe;
	}

	public String getCourriel() {
		return courriel.get();
	}

	public void setCourriel(String courriel) {
		this.courriel.set(courriel);
	}

	public StringProperty courrielProperty() {
		return courriel;
	}

	public String getTelephone() {
		return telephone.get();
	}

	public void setTelephone(String telephone) {
		this.telephone.set(telephone);
	}

	public StringProperty telephoneProperty() {
		return telephone;
	}

	public String getAnciennete() {
		return anciennete.get();
	}

	public void setAnciennete(String anciennete) {
		this.anciennete.set(anciennete);
	}

	public StringProperty ancienneteProperty() {
		return anciennete;
	}

    public Contacts create() {	
    	String nom = (String) getTable().getField("nom");
        return new Contacts(getConnector(), nom, nom, nom);
    }
}
