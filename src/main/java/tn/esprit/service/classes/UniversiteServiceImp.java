package tn.esprit.service.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Persistance.entities.Universite;
import tn.esprit.Persistance.entities.Universite;
import tn.esprit.Persistance.repositories.UniversiteRepository;
import tn.esprit.service.interfaces.UniversiteService;

import java.util.List;

@Service
public class UniversiteServiceImp implements UniversiteService {
    @Autowired
    UniversiteRepository universiteRepo;
    @Override
    public Universite afficherUniversite(int id) {

        return this.universiteRepo.findById(id).get();
    }

    @Override
    public Universite ajouterUniversite(Universite e) {
        return this.universiteRepo.save(e);
     
    }

    @Override
    public Universite mettreAjourUniversite(Universite e) {
        Universite Universite = universiteRepo.findById(e.getIdUniv()).orElse(null);
        if(Universite != null)
            universiteRepo.save(e);
        return e;
       
    }

    @Override
    public void supprimerUniversite(int id) {
        universiteRepo.deleteById(id);
    }

    @Override
    public List<Universite> chercherUniversites() {
        return universiteRepo.findAll();
    }		 

}
