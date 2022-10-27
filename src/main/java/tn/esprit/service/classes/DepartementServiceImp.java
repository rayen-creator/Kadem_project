package tn.esprit.service.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Persistance.entities.Departement;
import tn.esprit.Persistance.repositories.DepartementRepository;
import tn.esprit.service.interfaces.DepartementService;

import java.util.List;

@Service
public class DepartementServiceImp implements DepartementService {
    @Autowired
    DepartementRepository depRepo;
    @Override
    public Departement afficherDepartement(int id) {
        return this.depRepo.findById(id).get();
    }

    @Override
    public Departement ajouterDepartement(Departement e) {
        return this.depRepo.save(e);
    }

    @Override
    public Departement mettreAjourDepartement(Departement e) {
        Departement Departement = depRepo.findById(e.getIdDepart()).orElse(null);
        if (Departement != null)
            depRepo.save(e);
        return e;
    }

    @Override
    public void supprimerDepartement(int id) {
        depRepo.deleteById(id);
    }

    @Override
    public List<Departement> chercherDepartement() {
        return depRepo.findAll();

    }
}
