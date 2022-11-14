package tn.esprit.service.interfaces;

import java.util.List;

import tn.esprit.Persistance.entities.Etudiant;

public interface EtudiantService {
	
	public Etudiant afficherEtudiant(int id);
	
	public int ajouterEtudiant(Etudiant e);
	
	public Etudiant mettreAjourEtudiant(Etudiant e);

	public void supprimerEtudiant (int id);
	
	public List<Etudiant> chercherEtudiants();
	
}
