package tn.esprit.service.interfaces;

import tn.esprit.Persistance.entities.Contrat;

import java.util.List;

public interface ContratService {
    public Contrat afficherContrat(int id);

    public Contrat ajouterContrat(Contrat e);

    public Contrat mettreAjourContrat(Contrat e);

    public void supprimerContrat(int id);

    public List<Contrat> chercherContrat();
}
