package tn.esprit.service.interfaces;

import java.util.List;

import tn.esprit.Persistance.entities.Equipe;

public interface EquipeService {

	public Equipe afficherEquipe(int id);

	public int ajouterEquipe(Equipe e);

	public Equipe mettreAjourEquipe(Equipe e);

	public void supprimerEquipe(int id);

	public List<Equipe> chercherEquipes();
}
