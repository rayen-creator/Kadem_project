package tn.esprit.service.classes;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Persistance.entities.Contrat;
import tn.esprit.Persistance.entities.Departement;
import tn.esprit.Persistance.repositories.DepartementRepository;
import tn.esprit.service.interfaces.DepartementService;

import java.util.List;
@Slf4j
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
        List<Departement> departements=depRepo.findAll();
        for (Departement departement:departements){
            log.info("departement :"+departements);
        }
        return departements;

    }
}
