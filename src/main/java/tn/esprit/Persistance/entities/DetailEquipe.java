package tn.esprit.Persistance.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "DetailEquipe")
public class DetailEquipe implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idDetailEquipe")
	private Integer idDetailEquipe;
	private Integer salle;
	private String thematique;
	
	@OneToOne(mappedBy="detailEquipes")
	private Equipe equipes;


	public Integer getIdDetailEquipe() {
		return idDetailEquipe;
	}

	public void setIdDetailEquipe(Integer idDetailEquipe) {
		this.idDetailEquipe = idDetailEquipe;
	}

	public Integer getSalle() {
		return salle;
	}

	public void setSalle(Integer salle) {
		this.salle = salle;
	}

	public String getThematique() {
		return thematique;
	}

	public void setThematique(String thematique) {
		this.thematique = thematique;
	}

	public Equipe getEquipes() {
		return equipes;
	}

	public void setEquipes(Equipe equipes) {
		this.equipes = equipes;
	}
}
