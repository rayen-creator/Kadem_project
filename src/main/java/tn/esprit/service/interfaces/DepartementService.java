package tn.esprit.service.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.Persistance.entities.Departement;

import java.util.List;

public interface DepartementService{

    public Departement afficherDepartement(int id);

    public int ajouterDepartement(Departement e);

    public Departement mettreAjourDepartement(Departement e);

    public void supprimerDepartement(int id);

    public List<Departement> chercherDepartement();
}
