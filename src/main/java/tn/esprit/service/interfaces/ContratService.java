package tn.esprit.service.interfaces;

import io.swagger.v3.oas.models.info.Contact;
import tn.esprit.Persistance.entities.Contrat;

import java.util.List;

public interface ContratService {
    public Contrat afficherContrat(int id);

    public int ajouterContrat(Contrat c);

    public Contrat mettreAjourContrat(Contrat c);

    public void supprimerContrat(int id);

    public List<Contrat> chercherContrat();
}
