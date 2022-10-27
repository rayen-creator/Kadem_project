package tn.esprit.Persistance.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import tn.esprit.Persistance.enumm.Option;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "Etudiant")
public class Etudiant implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idEtudiant")
	private Integer idEtudiant; // Clé primaire
	private String prenomE;
	private String nomE;
	// TIME : 30-09-19 10:50:56.780000000 AM
	// DATE : 30-09-19
	// TIMESTAMP : 1569840656 (nbre de secondes entre 01/01/1970 et la date
	// voulue)
	@Temporal(TemporalType.DATE)
	private Date dateDebut;

	@Enumerated(EnumType.STRING)
	private Option options;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "etudiants")
	private Set<Contrat> contrat;
	@ManyToMany(mappedBy = "etudiants", cascade = CascadeType.ALL)
	private Set<Equipe> equipes;
	@ManyToOne
	private Departement departements;

	public Integer getIdEtudiant() {
		return idEtudiant;
	}

	public void setIdEtudiant(Integer idEtudiant) {
		this.idEtudiant = idEtudiant;
	}

	public String getPrenomE() {
		return prenomE;
	}

	public void setPrenomE(String prenomE) {
		this.prenomE = prenomE;
	}

	public String getNomE() {
		return nomE;
	}

	public void setNomE(String nomE) {
		this.nomE = nomE;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Set<Contrat> getContrat() {
		return contrat;
	}

	public void setContrat(Set<Contrat> contrat) {
		this.contrat = contrat;
	}

	public Set<Equipe> getEquipes() {
		return equipes;
	}

	public void setEquipes(Set<Equipe> equipes) {
		this.equipes = equipes;
	}

	public Departement getDepartements() {
		return departements;
	}

	public void setDepartements(Departement departements) {
		this.departements = departements;
	}

}