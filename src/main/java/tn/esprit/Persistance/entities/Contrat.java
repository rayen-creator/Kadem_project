package tn.esprit.Persistance.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import tn.esprit.Persistance.enumm.Specialite;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="Contrat")
public class Contrat implements Serializable{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idContrat")
	private Integer idContrat;
	@Temporal (TemporalType.DATE)
	private Date dateDebutContrat;
	@Temporal (TemporalType.DATE)
	private Date dateFinContrat;
	@Enumerated(EnumType.STRING)
	private Specialite specalitee;
	private boolean archive;
	private Integer montantContrat;
	@ManyToOne
	private Etudiant etudiants;

	public Integer getIdContrat() {
		return idContrat;
	}

	public void setIdContrat(Integer idContrat) {
		this.idContrat = idContrat;
	}

	public Date getDateDebutContrat() {
		return dateDebutContrat;
	}

	public void setDateDebutContrat(Date dateDebutContrat) {
		this.dateDebutContrat = dateDebutContrat;
	}

	public Date getDateFinContrat() {
		return dateFinContrat;
	}

	public void setDateFinContrat(Date dateFinContrat) {
		this.dateFinContrat = dateFinContrat;
	}

	public boolean isArchive() {
		return archive;
	}

	public void setArchive(boolean archive) {
		this.archive = archive;
	}

	public Specialite getSpecalitee() {
		return specalitee;
	}

	public void setSpecalitee(Specialite specalitee) {
		this.specalitee = specalitee;
	}

	public Integer getMontantContrat() {
		return montantContrat;
	}

	public void setMontantContrat(Integer montantContrat) {
		this.montantContrat = montantContrat;
	}

	public Etudiant getEtudiants() {
		return etudiants;
	}

	public void setEtudiants(Etudiant etudiants) {
		this.etudiants = etudiants;
	}
}
